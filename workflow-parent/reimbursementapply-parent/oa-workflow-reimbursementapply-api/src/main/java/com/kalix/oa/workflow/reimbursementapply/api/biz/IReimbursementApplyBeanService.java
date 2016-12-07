package com.kalix.oa.workflow.reimbursementapply.api.biz;


import com.kalix.middleware.workflow.api.biz.IWorkflowBizService;
import com.kalix.oa.workflow.reimbursementapply.entities.ReimbursementApplyBean;

/**
 * @author zangyanming
 */
public interface IReimbursementApplyBeanService extends IWorkflowBizService<ReimbursementApplyBean> {
      final String PROCESS_KEY_NAME="reimbursementapply";
}
