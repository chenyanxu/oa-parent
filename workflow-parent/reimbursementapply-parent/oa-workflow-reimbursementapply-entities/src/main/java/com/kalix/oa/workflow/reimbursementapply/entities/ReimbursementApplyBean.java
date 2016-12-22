package com.kalix.oa.workflow.reimbursementapply.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.middleware.workflow.api.model.WorkflowEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Date;

/**
 * @类描述：报销申请管理
 * @创建人： zangyanming
 * @创建时间：2016/11/28
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "oa_workflow_reimbursementapply")
@Inheritance(strategy = InheritanceType.JOINED)
public class ReimbursementApplyBean extends WorkflowEntity {

    private Long evectionApplyId;
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date reimbursementDate;//报销日期
    private String reimbursementNo;//编号
    private Long bussinessPeopleId;//出差人
    private String reason;//出差事由
    private String projectName;//项目名称
    private String managerUser;//领导批示
    private String chairmanUser;//董事长
    private String depUser;//部门领导
    private String financeUser;//财务主管
    private String accountantUser;//会计
    private String cashierUser;//出纳
    private String payeeUser;//领款人
    private Float borrowMoney;//预借金额
    private Float backMoney;//补退金额

    public Long getEvectionApplyId() {
        return evectionApplyId;
    }

    public void setEvectionApplyId(Long evectionApplyId) {
        this.evectionApplyId = evectionApplyId;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getDepUser() {
        return depUser;
    }

    public void setDepUser(String depUser) {
        this.depUser = depUser;
    }

    public String getChairmanUser() {
        return chairmanUser;
    }

    public void setChairmanUser(String chairmanUser) {
        this.chairmanUser = chairmanUser;
    }

    public String getFinanceUser() {
        return financeUser;
    }

    public void setFinanceUser(String financeUser) {
        this.financeUser = financeUser;
    }

    public String getAccountantUser() {
        return accountantUser;
    }

    public void setAccountantUser(String accountantUser) {
        this.accountantUser = accountantUser;
    }

    public String getCashierUser() {
        return cashierUser;
    }

    public void setCashierUser(String cashierUser) {
        this.cashierUser = cashierUser;
    }

    public String getPayeeUser() {
        return payeeUser;
    }

    public void setPayeeUser(String payeeUser) {
        this.payeeUser = payeeUser;
    }

    public Float getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(Float borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public Float getBackMoney() {
        return backMoney;
    }

    public void setBackMoney(Float backMoney) {
        this.backMoney = backMoney;
    }
}
