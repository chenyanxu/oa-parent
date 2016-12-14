package com.kalix.oa.workflow.meetingroomapply.api.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.middleware.workflow.api.biz.IWorkflowBizService;
import com.kalix.oa.workflow.meetingroomapply.entities.MeetingRoomApplyBean;

import java.util.Date;

/**
 * @author sunlf
 */
public interface IMeetingRoomApplyBeanService extends IWorkflowBizService<MeetingRoomApplyBean> {
    final String PROCESS_KEY_NAME="meetingapply";

    JsonStatus checkDateTime(String jsonStr);

    //会议室预约情况
    JsonData reservation(Date date);

    JsonData reservation(long roomId, Date date);
}
