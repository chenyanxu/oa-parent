package com.kalix.oa.usecase.interview.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by zangyanming on 2016/6/21.
 */

@Entity
@Table(name = "oa_interview")
public class InterviewBean extends PersistentEntity {
    private String candidateId;//应聘id
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dateFirst;//初试时间
    private String interviewerFirst;//初试面试官
    private String interviewContentFirst;//初试面试内容
    private Boolean passFirst;// 初试是否通过

    @Transient
    private String whichInterview;

    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dateSecond;//复试时间
    private String interviewerSecond;//复试面试官
    private String interviewContentSecond;//复试面试内容
    private Boolean passSecond;// 复试是否通过

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public Date getDateFirst() {
        return dateFirst;
    }

    public void setDateFirst(Date dateFirst) {
        this.dateFirst = dateFirst;
    }

    public String getInterviewerFirst() {
        return interviewerFirst;
    }

    public void setInterviewerFirst(String interviewerFirst) {
        this.interviewerFirst = interviewerFirst;
    }

    public String getInterviewContentFirst() {
        return interviewContentFirst;
    }

    public void setInterviewContentFirst(String interviewContentFirst) {
        this.interviewContentFirst = interviewContentFirst;
    }

    public Boolean getPassFirst() {
        return passFirst;
    }

    public void setPassFirst(Boolean passFirst) {
        this.passFirst = passFirst;
    }

    public Date getDateSecond() {
        return dateSecond;
    }

    public void setDateSecond(Date dateSecond) {
        this.dateSecond = dateSecond;
    }

    public String getInterviewerSecond() {
        return interviewerSecond;
    }

    public void setInterviewerSecond(String interviewerSecond) {
        this.interviewerSecond = interviewerSecond;
    }

    public String getInterviewContentSecond() {
        return interviewContentSecond;
    }

    public void setInterviewContentSecond(String interviewContentSecond) {
        this.interviewContentSecond = interviewContentSecond;
    }

    public Boolean getPassSecond() {
        return passSecond;
    }

    public void setPassSecond(Boolean passSecond) {
        this.passSecond = passSecond;
    }

    public String getWhichInterview() {
        return whichInterview;
    }

    public void setWhichInterview(String whichInterview) {
        this.whichInterview = whichInterview;
    }
}
