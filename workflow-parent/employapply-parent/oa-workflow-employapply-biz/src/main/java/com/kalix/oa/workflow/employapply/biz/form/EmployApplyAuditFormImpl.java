package com.kalix.oa.workflow.employapply.biz.form;

import com.kalix.middleware.workflow.biz.AbstractAuditFormHandler;

/**
 * Created by sunlf on 2016/2/25.
 * 入职申请审批窗口
 */
public class EmployApplyAuditFormImpl extends AbstractAuditFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.employApply.view.EmployApplyAllViewForm";
    }
}
