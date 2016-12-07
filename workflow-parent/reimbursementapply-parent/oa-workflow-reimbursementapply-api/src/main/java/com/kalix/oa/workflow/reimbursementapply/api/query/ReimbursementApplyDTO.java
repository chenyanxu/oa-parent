package com.kalix.oa.workflow.reimbursementapply.api.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.web.model.BaseDTO;
import com.kalix.middleware.workflow.api.model.WorkflowStaus;

import java.util.Date;

/**
 * Created by zangyanming on 2016/06/21.
 */
public class ReimbursementApplyDTO extends BaseDTO {
    /**
     * @describe 出差开始时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginDate;
    /**
     * @describe 出差结束时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endDate;
    /**
     * @describe 出差原因
     */
    private String reason;
    /**
     * @describe 部门领导
     */
    private String depUserBorrow;
    /**
     * @describe 董事长
     */
    private String chairmanUser;
    /**
     * @describe 会计
     */
    private String accountantUserBorrow;
    /**
     * @describe 出纳
     */
    private String cashierUserBorrow;

    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date reimbursementDate;//报销日期
    private String reimbursementNo;//编号
    private Long bussinessPeopleId;//出差人
    private String projectName;//项目名称
    private String managerUser;//领导批示
    private String depUserBack;//部门领导
    private String financeUser;//财务主管
    private String accountantUserBack;//会计
    private String cashierUserBack;//出纳
    private String payeeUser;//领款人
    private Integer borrowMoney;//预借金额
    private Integer backMoney;//补退金额

    private String title;//
    private Long orgId;
    private String orgName;
    private String processInstanceId;//流程实例id
    private String currentNode;//当前环节
    private Short status;
    private String auditResult="流程尚未启动";//审批最终结果
    private String businessNo = ""; //业务编号

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDepUserBorrow() {
        return depUserBorrow;
    }

    public void setDepUserBorrow(String depUserBorrow) {
        this.depUserBorrow = depUserBorrow;
    }

    public String getChairmanUser() {
        return chairmanUser;
    }

    public void setChairmanUser(String chairmanUser) {
        this.chairmanUser = chairmanUser;
    }

    public String getAccountantUserBorrow() {
        return accountantUserBorrow;
    }

    public void setAccountantUserBorrow(String accountantUserBorrow) {
        this.accountantUserBorrow = accountantUserBorrow;
    }

    public String getCashierUserBorrow() {
        return cashierUserBorrow;
    }

    public void setCashierUserBorrow(String cashierUserBorrow) {
        this.cashierUserBorrow = cashierUserBorrow;
    }

    public Date getReimbursementDate() {
        return reimbursementDate;
    }

    public void setReimbursementDate(Date reimbursementDate) {
        this.reimbursementDate = reimbursementDate;
    }

    public String getReimbursementNo() {
        return reimbursementNo;
    }

    public void setReimbursementNo(String reimbursementNo) {
        this.reimbursementNo = reimbursementNo;
    }

    public Long getBussinessPeopleId() {
        return bussinessPeopleId;
    }

    public void setBussinessPeopleId(Long bussinessPeopleId) {
        this.bussinessPeopleId = bussinessPeopleId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getManagerUser() {
        return managerUser;
    }

    public void setManagerUser(String managerUser) {
        this.managerUser = managerUser;
    }

    public String getDepUserBack() {
        return depUserBack;
    }

    public void setDepUserBack(String depUserBack) {
        this.depUserBack = depUserBack;
    }

    public String getFinanceUser() {
        return financeUser;
    }

    public void setFinanceUser(String financeUser) {
        this.financeUser = financeUser;
    }

    public String getAccountantUserBack() {
        return accountantUserBack;
    }

    public void setAccountantUserBack(String accountantUserBack) {
        this.accountantUserBack = accountantUserBack;
    }

    public String getCashierUserBack() {
        return cashierUserBack;
    }

    public void setCashierUserBack(String cashierUserBack) {
        this.cashierUserBack = cashierUserBack;
    }

    public String getPayeeUser() {
        return payeeUser;
    }

    public void setPayeeUser(String payeeUser) {
        this.payeeUser = payeeUser;
    }

    public Integer getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(Integer borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public Integer getBackMoney() {
        return backMoney;
    }

    public void setBackMoney(Integer backMoney) {
        this.backMoney = backMoney;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}