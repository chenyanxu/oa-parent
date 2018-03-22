package com.kalix.oa.workflow.carapply.biz.form;

import com.kalix.middleware.workflow.biz.AbstractAuditFormHandler;

/**
 * Created by hqj on 2018/3/22.
 * 教学用车申请审批窗口
 */
public class TeachingCarApplyAuditFormImpl extends AbstractAuditFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.teachingCarApply.view.TeachingCarApplyViewForm";
    }
}
