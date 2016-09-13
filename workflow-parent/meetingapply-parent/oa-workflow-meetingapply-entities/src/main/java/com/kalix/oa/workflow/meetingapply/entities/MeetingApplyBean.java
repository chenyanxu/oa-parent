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
@Table(name = "oa_workflow_meeting")
public class MeetingApplyBean extends WorkflowEntity {
    //会议地点
    private Integer meetingroomId;
    //会议地点
    @Transient
    private String meetingroomName;
    //会议名称
    private String meetingTopic;
    //宣传需求（企划中心）
    private Integer requireType;
    //主持人
    private String host;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date meetingDate;//会议日期
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginTime;//会议时段,开始时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;//会议时段，结束时间
    @Transient
    private String weekOfDay;
    //参会人员
    private String participant;
    //出席人数
    private Integer attendance;
    //设备要求
    private String equipmentRequirement;
    //联系人（安全责任人）
    private String securityPerson;
    //联系人电话
    private String securityTel;
    //申请人联系电话
    private String operatorPhone;

    //校务部行政事务办主管
    private String schoolAdminUser;
    //校务部签字
    private String schoolUser;

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

    public Integer getRequireType() {
        return requireType;
    }

    public void setRequireType(Integer requireType) {
        this.requireType = requireType;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
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

    public String getWeekOfDay() {
        return weekOfDay;
    }

    public void setWeekOfDay(String weekOfDay) {
        this.weekOfDay = weekOfDay;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public String getEquipmentRequirement() {
        return equipmentRequirement;
    }

    public void setEquipmentRequirement(String equipmentRequirement) {
        this.equipmentRequirement = equipmentRequirement;
    }

    public String getSecurityPerson() {
        return securityPerson;
    }

    public void setSecurityPerson(String securityPerson) {
        this.securityPerson = securityPerson;
    }

    public String getSecurityTel() {
        return securityTel;
    }

    public void setSecurityTel(String securityTel) {
        this.securityTel = securityTel;
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    public String getSchoolAdminUser() {
        return schoolAdminUser;
    }

    public void setSchoolAdminUser(String schoolAdminUser) {
        this.schoolAdminUser = schoolAdminUser;
    }

    public String getSchoolUser() {
        return schoolUser;
    }

    public void setSchoolUser(String schoolUser) {
        this.schoolUser = schoolUser;
    }

}
