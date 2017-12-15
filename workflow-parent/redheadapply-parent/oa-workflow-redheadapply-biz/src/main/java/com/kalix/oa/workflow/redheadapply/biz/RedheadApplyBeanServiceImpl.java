package com.kalix.oa.workflow.redheadapply.biz;

import com.kalix.middleware.statemachine.api.biz.IStatemachineService;
import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.workflow.redheadapply.api.biz.IRedheadApplyBeanService;
import com.kalix.oa.workflow.redheadapply.api.dao.IRedheadApplyBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.RedheadApplyBean;

import java.util.Map;

/**
 * @author chenyanxu
 */
public class RedheadApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IRedheadApplyBeanDao, RedheadApplyBean> implements IRedheadApplyBeanService {
    private IStatemachineService statemachineService;

    public void setStatemachineService(IStatemachineService statemachineService) {
        this.statemachineService = statemachineService;
    }

    @Override
    public String getProcessKeyName() {
        return PROCESS_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map, RedheadApplyBean bean) {
        //测试状态机
//        InputStream is = this.getClass().getClassLoader().getResourceAsStream("config.xml");
//        statemachineService.initFSM(is, "START");
//        String currentState = statemachineService.getCurrentState();
//        statemachineService.processFSM("MOVELEFT");
//        currentState = statemachineService.getCurrentState();

        map.put("city", bean.isCity());
        return map;
    }
}
