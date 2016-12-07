package com.kalix.oa.workflow.reimbursementapply.biz.form;

import com.kalix.middleware.workflow.biz.AbstractAuditFormHandler;

/**
 * Created by zangyanming on 2016/11/28.
 * 报销申请审批窗口
 */
public class ReimbursementApplyAuditFormImpl extends AbstractAuditFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.reimbursementApply.view.ReimbursementApplyViewForm";
    }
}
