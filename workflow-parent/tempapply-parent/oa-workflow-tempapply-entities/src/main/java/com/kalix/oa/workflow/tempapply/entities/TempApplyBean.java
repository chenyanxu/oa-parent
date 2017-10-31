package com.kalix.oa.workflow.tempapply.entities;

import com.kalix.middleware.workflow.api.model.WorkflowEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author chenyanxu
 *         临时申请业务类
 */
@Entity
@Table(name = "oa_workflow_tempapply")
public class TempApplyBean extends WorkflowEntity {
    // 申请事由
    private String content;
    // 审批领导职务
    private String targetDuty;
    //审批领导签字
    private String dutyUser;
    //上级领导签字
    private String depUser;

    public String getDepUser() {
        return depUser;
    }

    public void setDepUser(String depUser) {
        this.depUser = depUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTargetDuty() {
        return targetDuty;
    }

    public void setTargetDuty(String targetDuty) {
        this.targetDuty = targetDuty;
    }

    public String getDutyUser() {
        return dutyUser;
    }

    public void setDutyUser(String dutyUser) {
        this.dutyUser = dutyUser;
    }
}
