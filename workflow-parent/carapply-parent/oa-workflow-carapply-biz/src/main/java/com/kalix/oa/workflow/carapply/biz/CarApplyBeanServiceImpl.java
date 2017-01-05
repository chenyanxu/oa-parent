package com.kalix.oa.workflow.carapply.biz;

import com.kalix.middleware.statemachine.api.biz.IStatemachineService;
import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.workflow.carapply.api.biz.ICarApplyBeanService;
import com.kalix.oa.workflow.carapply.api.dao.ICarApplyBeanDao;
import com.kalix.oa.workflow.carapply.entities.CarApplyBean;

import java.io.InputStream;
import java.util.Map;

/**
 * @author chenyanxu
 */
public class CarApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<ICarApplyBeanDao, CarApplyBean> implements ICarApplyBeanService {
    private IStatemachineService statemachineService;

    public void setStatemachineService(IStatemachineService statemachineService) {
        this.statemachineService = statemachineService;
    }

    @Override
    public String getProcessKeyName() {
        return PROCESS_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map,CarApplyBean bean) {
        //测试状态机
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("config.xml");
        statemachineService.initFSM(is, "START");
        String currentState = statemachineService.getCurrentState();
        statemachineService.processFSM("MOVELEFT");
        currentState = statemachineService.getCurrentState();

        map.put("city", bean.isCity());
        return map;
    }
}
