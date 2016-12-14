package com.kalix.oa.workflow.meetingroomapply.biz.form;


import com.kalix.middleware.workflow.biz.AbstractBizDataFormHandler;

/**
 * @author chenyanxu
 *         会议室使用申请业务数据表单
 */
public class MeetingRoomApplyBizDataFormImpl extends AbstractBizDataFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.meetingRoomApply.view.MeetingRoomApplyViewForm";
    }
}
