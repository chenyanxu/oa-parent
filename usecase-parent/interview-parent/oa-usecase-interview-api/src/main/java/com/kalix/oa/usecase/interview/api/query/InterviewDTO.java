package com.kalix.oa.usecase.interview.api.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.web.model.BaseDTO;

import java.util.Date;

/**
 * Created by zangyanming on 2016/06/21.
 */
public class InterviewDTO extends BaseDTO {
    private Integer personCategory;//人员类别
    private Long orgId;//部门代码
    private String orgName;//部门名称
    private String xm;//姓名
    private Integer sex;//性别
    private Integer age;//年龄
    private String tel;//联系电话
    private String position;//应聘岗位

    private Long candidateId;//应聘id
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dateFirst;//初试时间
    private String interviewerFirst;//初试面试官
    private String interviewContentFirst;//初试面试内容
    private Boolean passFirst;// 初试是否通过

    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dateSecond;//复试时间
    private String interviewerSecond;//复试面试官
    private String interviewContentSecond;//复试面试内容
    private Boolean passSecond;// 复试是否通过

    public Integer getPersonCategory() {
        return personCategory;
    }

    public void setPersonCategory(Integer personCategory) {
        this.personCategory = personCategory;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
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
}