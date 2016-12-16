package com.kalix.oa.workflow.meetingapply.biz.form;

import com.kalix.middleware.workflow.biz.AbstractAuditFormHandler;

/**
 * Created by sunlf on 2016/2/25.
 * 参加会议审批窗口 attend.form
 */
public class MeetingApplyAuditAttendFormImpl extends AbstractAuditFormHandler {

    @Override
    public String getFormClass() {
        return "kalix.workflow.meetingApply.view.MeetingApplyViewForm";
    }


    @Override
    public String getButtonValue() {
        return "参加,不参加";
    }

    @Override
    public String getFormKey() {
        return "attend.form";
    }
}
