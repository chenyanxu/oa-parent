package com.kalix.oa.usecase.candidate.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by zangyanming on 2016/6/21.
 */

@Entity
@Table(name = "oa_candidate")
public class CandidateBean extends PersistentEntity {
    private Integer personCategory;//人员类别
    private Long orgId;//部门代码
    private String orgName;//部门名称
    private String xm;//姓名
    private Integer sex;//性别
    private Integer age;//年龄
    private String tel;//联系电话
    private String graduateSchool;//毕业学校
    private String major;//专业
    private String education;//最后学历
    private String residence;//户口所在地
    private String position;//应聘岗位
    private String salary;//期望工资
    private String experience;//从业经验
    private String comment;//备注

    private Long employApplyWorkflowId;//入职申请流程id

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

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getEmployApplyWorkflowId() {
        return employApplyWorkflowId;
    }

    public void setEmployApplyWorkflowId(Long employApplyWorkflowId) {
        this.employApplyWorkflowId = employApplyWorkflowId;
    }
}
