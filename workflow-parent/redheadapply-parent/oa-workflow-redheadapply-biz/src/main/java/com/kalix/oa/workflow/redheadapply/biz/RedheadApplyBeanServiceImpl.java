package com.kalix.oa.workflow.redheadapply.biz;

import com.kalix.middleware.statemachine.api.biz.IStatemachineService;
import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.workflow.redheadapply.api.biz.IRedheadApplyBeanService;
import com.kalix.oa.workflow.redheadapply.api.dao.IDocumentBeanDao;
import com.kalix.oa.workflow.redheadapply.api.dao.IDocumentConfigBeanDao;
import com.kalix.oa.workflow.redheadapply.api.dao.IRedheadApplyBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.RedheadApplyBean;

import java.util.Map;

/**
 * @author sunlf
 */
public class RedheadApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IRedheadApplyBeanDao, RedheadApplyBean> implements IRedheadApplyBeanService {
    private IStatemachineService statemachineService;
    private IDocumentBeanDao documentBeanDao;
    private IDocumentConfigBeanDao documentConfigBeanDao;

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
        return null;
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

    public void setDocumentBeanDao(IDocumentBeanDao documentBeanDao) {
        this.documentBeanDao = documentBeanDao;
    }

    public void setDocumentConfigBeanDao(IDocumentConfigBeanDao documentConfigBeanDao) {
        this.documentConfigBeanDao = documentConfigBeanDao;
    }
}
