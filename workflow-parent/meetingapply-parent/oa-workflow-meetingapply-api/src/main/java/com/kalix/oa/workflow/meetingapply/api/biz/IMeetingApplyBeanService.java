package com.kalix.oa.workflow.meetingapply.api.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.middleware.workflow.api.biz.IWorkflowBizService;
import com.kalix.oa.workflow.meetingapply.entities.MeetingApplyBean;

import java.util.Date;
import java.util.Map;

/**
 * @author sunlf
 */
public interface IMeetingApplyBeanService extends IWorkflowBizService<MeetingApplyBean> {
    final String PROCESS_KEY_NAME="meetingapply";

    JsonStatus checkDateTime(String jsonStr);

    //会议室预约情况
    JsonData reservation(Date date);

    JsonData reservation(long roomId, Date date);

    void getStartMap(Map map, MeetingApplyBean bean);
}
