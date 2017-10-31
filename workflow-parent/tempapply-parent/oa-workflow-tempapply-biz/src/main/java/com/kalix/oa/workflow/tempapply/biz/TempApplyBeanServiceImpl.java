package com.kalix.oa.workflow.tempapply.biz;


import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.workflow.tempapply.api.biz.ITempApplyBeanService;
import com.kalix.oa.workflow.tempapply.api.dao.ITempApplyBeanDao;
import com.kalix.oa.workflow.tempapply.entities.TempApplyBean;

import java.util.Map;

/**
 * @author chenyanxu
 */
public class TempApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<ITempApplyBeanDao, TempApplyBean> implements ITempApplyBeanService {
    @Override
    public String getProcessKeyName() {
        return PROCESS_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map, TempApplyBean bean) {
        map.put("targetDuty", bean.getTargetDuty());
        return map;
    }
}
