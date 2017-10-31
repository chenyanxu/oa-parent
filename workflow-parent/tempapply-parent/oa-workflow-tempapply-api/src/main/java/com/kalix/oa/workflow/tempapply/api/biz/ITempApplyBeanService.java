package com.kalix.oa.workflow.tempapply.api.biz;

import com.kalix.middleware.workflow.api.biz.IWorkflowBizService;
import com.kalix.oa.workflow.tempapply.entities.TempApplyBean;

/**
 * @author chenyanxu
 */
public interface ITempApplyBeanService extends IWorkflowBizService<TempApplyBean> {
    final String PROCESS_KEY_NAME = "tempapply";
}
