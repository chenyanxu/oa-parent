package com.kalix.oa.workflow.meetingroomapply.biz.form;

import com.kalix.middleware.workflow.biz.AbstractAuditFormHandler;

/**
 * Created by sunlf on 2016/2/25.
 * 会议室使用申请审批窗口
 */
public class MeetingRoomApplyAuditFormImpl extends AbstractAuditFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.meetingRoomApply.view.MeetingRoomApplyViewForm";
    }
}
