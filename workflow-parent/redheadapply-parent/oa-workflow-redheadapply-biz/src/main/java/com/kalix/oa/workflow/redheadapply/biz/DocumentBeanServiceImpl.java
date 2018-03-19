package com.kalix.oa.workflow.redheadapply.biz;

import com.kalix.framework.core.api.exception.KalixRuntimeException;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.middleware.statemachine.api.biz.IStatemachineService;
import com.kalix.oa.workflow.redheadapply.api.biz.IDocumentBeanService;
import com.kalix.oa.workflow.redheadapply.api.biz.IRedheadApplyBeanService;
import com.kalix.oa.workflow.redheadapply.api.dao.IDocumentBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.DocumentBean;
import com.kalix.oa.workflow.redheadapply.entities.RedheadApplyBean;

import javax.transaction.Transactional;
import java.io.InputStream;
import java.util.Date;


/**
 * @author sunlf
 */
public class DocumentBeanServiceImpl extends ShiroGenericBizServiceImpl<IDocumentBeanDao, DocumentBean> implements IDocumentBeanService {
    private IStatemachineService statemachineService;
    private IRedheadApplyBeanService redheadApplyBeanService;

    @Override
    public DocumentBean getMinEntity(Integer docType, String year, String status) {
        return this.dao.getMinEntity(docType, year, status);
    }

    @Override
    public DocumentBean getEntityByBusinessNo(String businessNo) {
        return this.dao.getEntityByBusinessNo(businessNo);
    }

    @Override
    @Transactional
    public JsonStatus revokeBusinessNo(Long id) {
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setSuccess(true);
        try {
            DocumentBean documentBean = this.getEntity(id);
            RedheadApplyBean redheadApplyBean = redheadApplyBeanService.getEntity(documentBean.getRedheadId());
            // 判断文件状态,未发文前才能撤回,即[审批中]和[审批通过]均可撤回
            if (redheadApplyBean.getDocStatus().equals("已发文")){
                jsonStatus.setSuccess(false);
                jsonStatus.setMsg("文号撤回失败!原因:文件已发文,文号不允许撤回,只能废除!");
            } else {
                // 判断文件使用状态（处于工作流中和工作流结束）
                if (redheadApplyBean.getDocStatus().equals("审批中")){
                    // 处于工作流中，调用工作流中止服务
                    redheadApplyBeanService.deleteProcess(redheadApplyBean.getProcessInstanceId(), "撤回文号");
                }

                // 修改文件使用状态，撤回后废除
                InputStream isRedhead = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
                statemachineService.initFSM(isRedhead, redheadApplyBean.getDocStatus());
                statemachineService.processFSM("撤回");
                redheadApplyBean.setDocStatus(statemachineService.getCurrentState());
                redheadApplyBeanService.updateEntity(redheadApplyBean);

                // 修改文号状态，撤回后可继续使用
                // 要求初始状态必须[使用中]才能[撤回],否则会出错
                InputStream isDocument = this.getClass().getClassLoader().getResourceAsStream("document-state.xml");
                statemachineService.initFSM(isDocument, documentBean.getStatus());
                statemachineService.processFSM("撤回");
                documentBean.setStatus(statemachineService.getCurrentState());
                this.updateEntity(documentBean);

                jsonStatus.setMsg("文号撤回成功!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("文号撤回失败！");
        }
        return jsonStatus;
    }

    @Override
    @Transactional
    public JsonStatus abolishBusinessNo(Long id) {
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setSuccess(true);
        try {
            DocumentBean documentBean = this.getEntity(id);
            RedheadApplyBean redheadApplyBean = redheadApplyBeanService.getEntity(documentBean.getRedheadId());
            /*// 判断文件使用状态（处于工作流中和工作流结束）
            if (redheadApplyBean.getDocStatus().equals("审批中")){
                // 处于工作流中，调用工作流中止服务
                redheadApplyBeanService.deleteProcess(redheadApplyBean.getProcessInstanceId(), "废除文号");
            }*/

            // 判断文件状态，[已发文]才能废除
            if (redheadApplyBean.getDocStatus().equals("已发文")) {
                // 修改文件使用状态
                InputStream isRedhead = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
                statemachineService.initFSM(isRedhead, redheadApplyBean.getDocStatus());
                statemachineService.processFSM("废除");
                redheadApplyBean.setDocStatus(statemachineService.getCurrentState());
                redheadApplyBeanService.updateEntity(redheadApplyBean);

                // 修改文号状态
                // 要求初始状态必须[使用中]才能[废除],否则会出错
                InputStream isDocument = this.getClass().getClassLoader().getResourceAsStream("document-state.xml");
                statemachineService.initFSM(isDocument, documentBean.getStatus());
                statemachineService.processFSM("废除");
                documentBean.setStatus(statemachineService.getCurrentState());
                this.updateEntity(documentBean);

                jsonStatus.setMsg("文号废除成功!");
            } else {
                jsonStatus.setSuccess(false);
                jsonStatus.setMsg("文号废除失败!原因:文件未发文,文号不允许废除!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("文号废除失败！");
        }
        return jsonStatus;
    }

    @Override
    @Transactional
    public JsonStatus publishRedhead(Long id, DocumentBean entity) {
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setSuccess(true);
        try {
            RedheadApplyBean redheadApplyBean = redheadApplyBeanService.getEntity(entity.getRedheadId());
            // 判断文件使用状态（处于工作流结束,审批通过）
            if (redheadApplyBean.getDocStatus().equals("审批通过")){
                // 可以发文
                // 修改文件使用状态
                InputStream isRedhead = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
                statemachineService.initFSM(isRedhead, redheadApplyBean.getDocStatus());
                statemachineService.processFSM("发文");
                redheadApplyBean.setDocStatus(statemachineService.getCurrentState());
                redheadApplyBeanService.updateEntity(redheadApplyBean);

                // 修改文号实体类
                //entity.setDocDate(new Date()); //日期前台可以设置
                this.updateEntity(entity);

                jsonStatus.setMsg("发文成功!");
            } else {
                jsonStatus.setSuccess(false);
                jsonStatus.setMsg("发文失败!原因:文件未审批通过,不允许发文!");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("发文失败！");
        }
        return jsonStatus;
    }

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        return dao.getAllRelations(page, limit, jsonStr, sort);
    }

    public void setStatemachineService(IStatemachineService statemachineService) {
        this.statemachineService = statemachineService;
    }

    public void setRedheadApplyBeanService(IRedheadApplyBeanService redheadApplyBeanService) {
        this.redheadApplyBeanService = redheadApplyBeanService;
    }
}
