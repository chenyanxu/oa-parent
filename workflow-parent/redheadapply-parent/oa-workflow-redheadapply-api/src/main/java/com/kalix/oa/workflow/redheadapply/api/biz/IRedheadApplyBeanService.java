package com.kalix.oa.workflow.redheadapply.api.biz;


import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.middleware.workflow.api.biz.IWorkflowBizService;
import com.kalix.oa.workflow.redheadapply.entities.RedheadApplyBean;

/**
 * @author sunlf
 */
public interface IRedheadApplyBeanService extends IWorkflowBizService<RedheadApplyBean> {
    final String PROCESS_KEY_NAME = "redheadapply";
    JsonData getStatisticByDocType(String jsonStr);
}
