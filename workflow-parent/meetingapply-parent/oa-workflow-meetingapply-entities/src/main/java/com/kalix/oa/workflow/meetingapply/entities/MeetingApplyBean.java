package com.kalix.oa.workflow.meetingapply.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.middleware.workflow.api.model.WorkflowEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author zangyanming
 *         会议申请业务类
 */
@Entity
@Table(name = "oa_workflow_meetingapply")
public class MeetingApplyBean extends WorkflowEntity {
    //会议地点
    private Integer meetingroomId;
    //会议地点
    @Transient
    private String meetingroomName;
    //会议议题
    private String meetingTopic;
    //会议议程
    private String meetingAgenda;
    //会议类型
    private Long meetingType;
    //会议纪要人员
    private String meetingSummaryPerson;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    private Date beginTime;//会议开始时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;//会议结束时间
    //重要出席人
    private String importantAttendees;
    //其他出席人
    private String otherAttendees;
    //审批截止时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date approveDeadline;

    public Integer getMeetingroomId() {
        return meetingroomId;
    }

    public void setMeetingroomId(Integer meetingroomId) {
        this.meetingroomId = meetingroomId;
    }

    public String getMeetingroomName() {
        return meetingroomName;
    }

    public void setMeetingroomName(String meetingroomName) {
        this.meetingroomName = meetingroomName;
    }

    public String getMeetingTopic() {
        return meetingTopic;
    }

    public void setMeetingTopic(String meetingTopic) {
        this.meetingTopic = meetingTopic;
    }

    public String getMeetingAgenda() {
        return meetingAgenda;
    }

    public void setMeetingAgenda(String meetingAgenda) {
        this.meetingAgenda = meetingAgenda;
    }

    public Long getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(Long meetingType) {
        this.meetingType = meetingType;
    }

    public String getMeetingSummaryPerson() {
        return meetingSummaryPerson;
    }

    public void setMeetingSummaryPerson(String meetingSummaryPerson) {
        this.meetingSummaryPerson = meetingSummaryPerson;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getImportantAttendees() {
        return importantAttendees;
    }

    public void setImportantAttendees(String importantAttendees) {
        this.importantAttendees = importantAttendees;
    }

    public String getOtherAttendees() {
        return otherAttendees;
    }

    public void setOtherAttendees(String otherAttendees) {
        this.otherAttendees = otherAttendees;
    }

    public Date getApproveDeadline() {
        return approveDeadline;
    }

    public void setApproveDeadline(Date approveDeadline) {
        this.approveDeadline = approveDeadline;
    }
}
