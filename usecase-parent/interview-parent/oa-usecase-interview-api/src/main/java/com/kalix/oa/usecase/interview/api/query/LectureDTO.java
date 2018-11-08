package com.kalix.oa.usecase.interview.api.query;

import com.kalix.framework.core.api.web.model.BaseDTO;

/**
 * Created by zangyanming on 2016/06/21.
 */
public class LectureDTO extends BaseDTO {
    private Integer personCategory;//人员类别
    private String orgId;//部门代码
    private String orgName;//部门名称
    private String xm;//姓名
    private Integer sex;//性别
    private Integer age;//年龄
    private String tel;//联系电话
    private String position;//应聘岗位

    private String candidateId;//应聘id
    private String subject;//试讲题目
    private String content;//授课内容
    private Float argumentScore;//教学论点分数
    private Float coursewareScore;//板书或课件分数
    private Float expressionScore;//语言表达分数
    private Float attitudeScore;//教态分数
    private Float effectScore;//教学效果分数
    private String qa;//所提问题及回答情况
    private String comment;//评语
    private String suggestion;//聘用意见
    private String participant;//听课人
    private Boolean pass; //是否通过

    public Integer getPersonCategory() {
        return personCategory;
    }

    public void setPersonCategory(Integer personCategory) {
        this.personCategory = personCategory;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
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

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Float getArgumentScore() {
        return argumentScore;
    }

    public void setArgumentScore(Float argumentScore) {
        this.argumentScore = argumentScore;
    }

    public Float getCoursewareScore() {
        return coursewareScore;
    }

    public void setCoursewareScore(Float coursewareScore) {
        this.coursewareScore = coursewareScore;
    }

    public Float getExpressionScore() {
        return expressionScore;
    }

    public void setExpressionScore(Float expressionScore) {
        this.expressionScore = expressionScore;
    }

    public Float getAttitudeScore() {
        return attitudeScore;
    }

    public void setAttitudeScore(Float attitudeScore) {
        this.attitudeScore = attitudeScore;
    }

    public Float getEffectScore() {
        return effectScore;
    }

    public void setEffectScore(Float effectScore) {
        this.effectScore = effectScore;
    }

    public String getQa() {
        return qa;
    }

    public void setQa(String qa) {
        this.qa = qa;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public Boolean getPass() {
        return pass;
    }

    public void setPass(Boolean pass) {
        this.pass = pass;
    }
}