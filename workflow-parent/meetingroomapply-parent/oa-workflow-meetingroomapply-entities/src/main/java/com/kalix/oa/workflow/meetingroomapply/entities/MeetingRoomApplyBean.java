package com.kalix.oa.workflow.meetingroomapply.entities;

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
@Table(name = "oa_workflow_meetingroomapply")
public class MeetingRoomApplyBean extends WorkflowEntity {
    private Integer meetingroomId;        //会议地点id
    @Transient
    private String meetingroomName;       //会议地点
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date meetingDate;             //会议日期
    private String meetingDateStr;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date beginTime;               //会议时段，开始时间
    private String beginTimeStr;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date endTime;                 //会议时段，结束时间
    private String endTimeStr;
    private String meetingTopic;          //会议名称(议题)
    private String meetingAgenda;         //会议内容(议程)
    private String participant;           //参会人员
    private String host;                  //主持人
    private String securityPerson;        //协调人（联系人（安全责任人））
    private String securityTel;           //协调人电话（联系人电话）
    private String operatorPhone;         //申请人联系电话

    private Integer requireType;          //宣传需求（企划中心），字典【会议需求类型】
    @Transient
    private String weekOfDay;
    private Integer attendance;           //参会人数（出席人数）
    private String equipmentRequirement;  //设备要求

    private String schoolAdminUser;       //校务部行政事务办主管
    private String schoolUser;            //校务部签字

    private Boolean weekCalander;         //是否周历
    private String schoolYear;            //学年
    private String term;                  //学期
    private Integer week;                 //学周，字典【学周】

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

    public Date getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getMeetingDateStr() {
        return meetingDateStr;
    }

    public void setMeetingDateStr(String meetingDateStr) {
        this.meetingDateStr = meetingDateStr;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getBeginTimeStr() {
        return beginTimeStr;
    }

    public void setBeginTimeStr(String beginTimeStr) {
        this.beginTimeStr = beginTimeStr;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
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

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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

    public Integer getRequireType() {
        return requireType;
    }

    public void setRequireType(Integer requireType) {
        this.requireType = requireType;
    }

    public String getWeekOfDay() {
        return weekOfDay;
    }

    public void setWeekOfDay(String weekOfDay) {
        this.weekOfDay = weekOfDay;
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

    public Boolean getWeekCalander() {
        return weekCalander;
    }

    public void setWeekCalander(Boolean weekCalander) {
        this.weekCalander = weekCalander;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }
}
