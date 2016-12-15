package com.kalix.oa.workflow.meetingapply.biz.form;


import com.kalix.middleware.workflow.biz.AbstractBizDataFormHandler;

/**
 * @author chenyanxu
 *         会议使用申请业务数据表单
 */
public class MeetingApplyBizDataFormImpl extends AbstractBizDataFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.meetingApply.view.MeetingApplyViewForm";
    }
}
