package com.kalix.oa.workflow.redheadapply.api.biz;


import com.kalix.middleware.workflow.api.biz.IWorkflowBizService;
import com.kalix.oa.workflow.redheadapply.entities.RedheadApplyBean;

/**
 * @author sunlf
 */
public interface IRedheadApplyBeanService extends IWorkflowBizService<RedheadApplyBean> {
    final String PROCESS_KEY_NAME = "redheadapply";
}
