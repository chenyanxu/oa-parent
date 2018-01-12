package com.kalix.oa.workflow.redheadapply.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.middleware.statemachine.api.biz.IStatemachineService;
import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.system.dict.api.biz.IOADictBeanService;
import com.kalix.oa.system.dict.entities.OADictBean;
import com.kalix.oa.workflow.redheadapply.api.biz.IDocumentBeanService;
import com.kalix.oa.workflow.redheadapply.api.biz.IDocumentConfigBeanService;
import com.kalix.oa.workflow.redheadapply.api.biz.IRedheadApplyBeanService;
import com.kalix.oa.workflow.redheadapply.api.dao.IRedheadApplyBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.DocumentBean;
import com.kalix.oa.workflow.redheadapply.entities.DocumentConfigBean;
import com.kalix.oa.workflow.redheadapply.entities.RedheadApplyBean;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Map;

/**
 * @author sunlf
 */
public class RedheadApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IRedheadApplyBeanDao, RedheadApplyBean> implements IRedheadApplyBeanService {
    private IStatemachineService statemachineService;
    private IDocumentBeanService documentBeanService;
    private IDocumentConfigBeanService documentConfigBeanService;
    private IOADictBeanService oaDictBeanService;

    /**
     * 创建流程业务编号-----文号
     * 格式：
     * 类型： 吉动院字
     * 吉动院人字
     * 吉动院教字
     * 吉动院学字
     * 吉动院招字
     * 吉动院研字
     * 吉动院学位字
     * 吉动校友字
     * 吉动院研学字
     * 文号： [2017]1号
     *
     * @return
     */
    @Override
    public synchronized String createBusinessNo(RedheadApplyBean bean) {
        /*if (bean.getDocCategory().equals("对内")) { // 吉动X字〔2017〕X号

        } else if (bean.getDocCategory().equals("对外")) { //吉动院字〔2017〕X号

        }
        return super.createBusinessNo(bean);*/
        String businessNo = "";
        //获取年份信息
        Calendar c = Calendar.getInstance();
        String year = String.valueOf(c.get(Calendar.YEAR));
        //获取最小文号发文信息
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("document-state.xml");
        statemachineService.initFSM(is, "已撤回");
        DocumentBean documentBean = documentBeanService.getMinEntity(bean.getDocType(), year, statemachineService.getCurrentState());
        //存在记录，使用最小文号(状态重置为【使用中】且更新记录为当前业务，注保证最新)
        if (documentBean != null) {
            businessNo = documentBean.getBusinessNo();
            //修改记录状态(状态重置为【使用中】)
            statemachineService.processFSM("回收");
            documentBean.setStatus(statemachineService.getCurrentState());
            //更新业务数据
            documentBean.setRedheadId(bean.getId());
            /*documentBean.setDocDate(bean.getDocDate());
            documentBean.setDocDept(bean.getDocDept());
            documentBean.setTitle(bean.getTitle());
            documentBean.setDocUrl(bean.getDocUrl());
            documentBean.setDocContent(bean.getDocContent());*/
            documentBeanService.updateEntity(documentBean);
        } else { //不存在记录,使用配置表文号(取号码)
            Integer num = 1;
            DocumentConfigBean documentConfigBean = documentConfigBeanService.getEntity(bean.getDocType(), year);
            if (documentConfigBean != null) {
                //存在配置信息,取号码
                num = documentConfigBean.getNumber();
                //修改配置信息
                documentConfigBeanService.updateNumber(documentConfigBean.getId(), (num + 1));
            } else {
                //不存在配置信息,生成并保存配置信息
                documentConfigBean = new DocumentConfigBean();
                documentConfigBean.setDocType(bean.getDocType());
                documentConfigBean.setYear(year);
                documentConfigBean.setNumber(num.intValue() + 1);
                documentConfigBeanService.saveEntity(documentConfigBean);
            }
            //生成文号【吉动X字〔2017〕X号】【吉动院字〔2017〕X号】
            OADictBean oaDictBean = oaDictBeanService.getByTypeAndValue("文号类型", bean.getDocType());
            businessNo = oaDictBean.getLabel() + "[" + year + "]" + num.toString() + "号";
            //保存发文信息
            documentBean = new DocumentBean();
            documentBean.setRedheadId(bean.getId());
            /*documentBean.setDocDate(bean.getDocDate());
            documentBean.setDocDept(bean.getDocDept());
            documentBean.setTitle(bean.getTitle());
            documentBean.setDocUrl(bean.getDocUrl());
            documentBean.setDocContent(bean.getDocContent());*/
            documentBean.setDocType(bean.getDocType());
            documentBean.setYear(year);
            documentBean.setNumber(num);
            documentBean.setBusinessNo(businessNo);
            is = this.getClass().getClassLoader().getResourceAsStream("document-state.xml");
            statemachineService.initFSM(is, "新建");
            statemachineService.processFSM("使用");
            documentBean.setStatus(statemachineService.getCurrentState());
            documentBeanService.saveEntity(documentBean);
        }
        return businessNo;
    }

    @Override
    public void beforeSaveEntity(RedheadApplyBean entity, JsonStatus status) {
        if (entity.getId() > 0) {
//            update
        } else {
//            add
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
            statemachineService.initFSM(is, "新建");
            entity.setDocStatus(statemachineService.getCurrentState());
        }
        super.beforeSaveEntity(entity, status);
    }

    @Override
    public void beforeUpdateEntity(RedheadApplyBean entity, JsonStatus status) {
        // 判断entity.editDocType，是否允许修改文号（处理逻辑放在流程里处理，通过环境变量配置处理entity.editDocType）
        // 如果允许修改，根据主键entity.id查找RedheadApplyBean对象，比较文号类型是否改变
        // 文号类型改变，设置文号状态为【已撤回】，调用createBusinessNo方法生成新文号
        // 是否修改文号
        if (entity.getEditDocType()) {
            RedheadApplyBean oldRedheadApplyBean = this.getEntity(entity.getId());
            // 比较新旧文号类型是否改变,如果改变
            if (!oldRedheadApplyBean.getDocType().equals(entity.getDocType())) {
                InputStream is = this.getClass().getClassLoader().getResourceAsStream("document-state.xml");
                statemachineService.initFSM(is, "使用中");
                statemachineService.processFSM("撤回");
                DocumentBean documentBean = documentBeanService.getEntityByBusinessNo(oldRedheadApplyBean.getBusinessNo());
                // 文号使用记录表中存在记录，修改状态为【已撤回】，保证该文号下次生成可用
                if (documentBean != null) {
                    documentBean.setStatus(statemachineService.getCurrentState());
                    documentBeanService.updateEntity(documentBean);
                } else {
                    // 文号记录表中无记录（正常不应该存在该情况，可以insert补充）
                }
                // 取新的文号
                String newBusinessNo = this.createBusinessNo(entity);
                entity.setBusinessNo(newBusinessNo);
            }
        }
        super.beforeUpdateEntity(entity, status);
    }

    @Override
    public void afterFinishProcess(RedheadApplyBean bean, String result) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
        statemachineService.initFSM(is, bean.getDocStatus());
        statemachineService.processFSM("通过");
        bean.setDocStatus(statemachineService.getCurrentState());
    }

    @Override
    public void beforeStartProcess(RedheadApplyBean bean) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
        statemachineService.initFSM(is, bean.getDocStatus());
        statemachineService.processFSM("审批");
        bean.setDocStatus(statemachineService.getCurrentState());
    }

    @Override
    public String getProcessKeyName() {
        return PROCESS_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map, RedheadApplyBean bean) {
        //测试状态机
//        InputStream is = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
//        statemachineService.initFSM(is, "START");
//        String currentState = statemachineService.getCurrentState();
//        statemachineService.processFSM("MOVELEFT");
//        currentState = statemachineService.getCurrentState();

//        map.put("city", bean.isCity());
        return map;
    }

    public void setStatemachineService(IStatemachineService statemachineService) {
        this.statemachineService = statemachineService;
    }

    public void setDocumentBeanService(IDocumentBeanService documentBeanService) {
        this.documentBeanService = documentBeanService;
    }

    public void setDocumentConfigBeanService(IDocumentConfigBeanService documentConfigBeanService) {
        this.documentConfigBeanService = documentConfigBeanService;
    }

    public void setOaDictBeanService(IOADictBeanService oaDictBeanService) {
        this.oaDictBeanService = oaDictBeanService;
    }
}
