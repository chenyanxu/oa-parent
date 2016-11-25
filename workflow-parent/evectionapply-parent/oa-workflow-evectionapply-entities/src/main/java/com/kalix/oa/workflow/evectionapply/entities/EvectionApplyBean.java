package com.kalix.oa.workflow.evectionapply.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.middleware.workflow.api.model.WorkflowEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Date;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
//todo 修改模型定义
@Entity
@Table(name = "oa_workflow_evectionapply")
@Inheritance(strategy = InheritanceType.JOINED)
public class EvectionApplyBean extends WorkflowEntity {
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
    private String depUser;
    /**
     * @describe 董事长
     */
    private String chairmanUser;
    /**
     * @describe 会计
     */
    private String accountantUser;
    /**
     * @describe 出纳
     */
    private String cashierUser;

    public Date getBeginDate() {
        return this.beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDepUser() {
        return this.depUser;
    }

    public void setDepUser(String depUser) {
        this.depUser = depUser;
    }

    public String getChairmanUser() {
        return this.chairmanUser;
    }

    public void setChairmanUser(String chairmanUser) {
        this.chairmanUser = chairmanUser;
    }

    public String getAccountantUser() {
        return this.accountantUser;
    }

    public void setAccountantUser(String accountantUser) {
        this.accountantUser = accountantUser;
    }

    public String getCashierUser() {
        return this.cashierUser;
    }

    public void setCashierUser(String cashierUser) {
        this.cashierUser = cashierUser;
    }


}
