package com.kalix.oa.workflow.employapply.api.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.web.model.BaseDTO;
import com.kalix.middleware.workflow.api.model.WorkflowStaus;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * Created by zangyanming on 2016/06/21.
 */
public class EmployApplyDTO extends BaseDTO {
    private Integer personCategory;//人员类别
    private Long orgId;//部门
    private String orgName;//部门
    private String xm;//姓名
    private Integer sex;//性别
    private Integer age;//年龄
    private String tel;//联系电话
    private String position;//应聘岗位
    private Long employApplyWorkflowId;//入职申请

    private String processInstanceId;//流程实例id
    private String currentNode;//当前环节
    private Short status= WorkflowStaus.INACTIVE;//工作流状态
    private String auditResult="流程尚未启动";//审批最终结果

    private String businessNo;
    private String branchSchoolLeader;//分院领导审批
    private String schoolLeader;//校领导审批
    private String manpower;// 人力资源部长签字

    private String title;     //流程名称
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applyDate;   //申请日期
    private Long candidateId; // 应聘人员id
    private String candidateName; // 应聘者姓名

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

    public Long getEmployApplyWorkflowId() {
        return employApplyWorkflowId;
    }

    public void setEmployApplyWorkflowId(Long employApplyWorkflowId) {
        this.employApplyWorkflowId = employApplyWorkflowId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(String auditResult) {
        this.auditResult = auditResult;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getBranchSchoolLeader() {
        return branchSchoolLeader;
    }

    public void setBranchSchoolLeader(String branchSchoolLeader) {
        this.branchSchoolLeader = branchSchoolLeader;
    }

    public String getSchoolLeader() {
        return schoolLeader;
    }

    public void setSchoolLeader(String schoolLeader) {
        this.schoolLeader = schoolLeader;
    }

    public String getManpower() {
        return manpower;
    }

    public void setManpower(String manpower) {
        this.manpower = manpower;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }
}