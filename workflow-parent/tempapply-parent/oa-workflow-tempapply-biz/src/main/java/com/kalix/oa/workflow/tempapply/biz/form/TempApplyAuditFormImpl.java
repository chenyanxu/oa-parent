package com.kalix.oa.workflow.tempapply.biz.form;

import com.kalix.middleware.workflow.biz.AbstractAuditFormHandler;

/**
 * Created by sunlf on 2016/2/25.
 * 印章申请审批页面实现类
 */
public class TempApplyAuditFormImpl extends AbstractAuditFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.sealApply.view.TempApplyViewForm";
    }
}

