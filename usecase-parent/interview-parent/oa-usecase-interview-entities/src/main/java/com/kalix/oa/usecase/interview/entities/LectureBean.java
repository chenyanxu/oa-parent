package com.kalix.oa.usecase.interview.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by zangyanming on 2016/6/22.
 */

@Entity
@Table(name = "oa_lecture")
public class LectureBean extends PersistentEntity {
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
    private Boolean pass;// 是否通过
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
