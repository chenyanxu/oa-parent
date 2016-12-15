package com.kalix.oa.workflow.meetingapply.biz.form;

import com.kalix.middleware.workflow.biz.AbstractAuditFormHandler;

/**
 * Created by sunlf on 2016/2/25.
 * 会议使用申请审批窗口
 */
public class MeetingApplyAuditFormImpl extends AbstractAuditFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.meetingApply.view.MeetingApplyViewForm";
    }
}
