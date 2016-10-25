package com.kalix.oa.workflow.employapply.api.query;

import com.kalix.framework.core.api.web.model.BaseDTO;

import java.util.Date;

/**
 * Created by zangyanming on 2016/06/21.
 */
public class EmployApplyDTO extends BaseDTO {
    private String personCategory;//人员类别
    private Long orgId;//部门
    private String orgName;//部门
    private String xm;//姓名
    private String sex;//性别
    private Integer age;//年龄
    private String tel;//联系电话
    private String position;//应聘岗位
    private Long employApplyWorkflowId;//入职申请

    private String processInstanceId;//流程实例id
    private String currentNode;//当前环节
    private Short status;//工作流状态
    private String auditResult="无审批结果";//审批最终结果

    private String businessNo;
    private String branchSchoolLeader;//分院领导审批
    private String schoolLeader;//校领导审批
    private String manpower;// 人力资源部长签字

    public String getPersonCategory() {
        return personCategory;
    }

    public void setPersonCategory(String personCategory) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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
}