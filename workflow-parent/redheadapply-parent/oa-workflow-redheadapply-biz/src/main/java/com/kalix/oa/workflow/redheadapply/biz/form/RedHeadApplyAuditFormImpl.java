package com.kalix.oa.workflow.redheadapply.biz.form;

import com.kalix.middleware.workflow.biz.AbstractAuditFormHandler;

/**
 * Created by sunlf on 2016/2/25.
 * 红头文件申请审批窗口
 */
public class RedHeadApplyAuditFormImpl extends AbstractAuditFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.redheadapply.view.RedHeadApplyViewForm";
    }
}
