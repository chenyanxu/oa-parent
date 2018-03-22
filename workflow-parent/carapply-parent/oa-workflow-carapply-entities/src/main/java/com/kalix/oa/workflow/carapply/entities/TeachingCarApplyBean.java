package com.kalix.oa.workflow.carapply.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.middleware.workflow.api.model.WorkflowEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Date;

/**
 * @类描述：教学用车申请管理
 * @创建人： hqj
 * @创建时间：2018/3/22
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "oa_workflow_teachingcarapply")
@Inheritance(strategy = InheritanceType.JOINED)
public class TeachingCarApplyBean extends WorkflowEntity {
    private String reason;            //用车事由
    private Integer usageCount;       //乘车人数
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginDate;           //用车时段,开始时间
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endDate;             //用车时段，结束时间
    private String address;           //用车起始地点
    private boolean city = true;      //是否市内用车
    private String operatorPhone;     //申请人联系电话
    private String depManageUser;     //申请部门主管领导签批
    private String teachingUser;      //教务部签批
    private String manageCenterUser;  //平台建设与管理中心签批
    private String learningUser;      //学工部签批
    private String schoolUser;        //校务部签字
    private String schoolLeader;      //校领导审批

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(Integer usageCount) {
        this.usageCount = usageCount;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCity() {
        return city;
    }

    public void setCity(boolean city) {
        this.city = city;
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    public String getDepManageUser() {
        return depManageUser;
    }

    public void setDepManageUser(String depManageUser) {
        this.depManageUser = depManageUser;
    }

    public String getTeachingUser() {
        return teachingUser;
    }

    public void setTeachingUser(String teachingUser) {
        this.teachingUser = teachingUser;
    }

    public String getManageCenterUser() {
        return manageCenterUser;
    }

    public void setManageCenterUser(String manageCenterUser) {
        this.manageCenterUser = manageCenterUser;
    }

    public String getLearningUser() {
        return learningUser;
    }

    public void setLearningUser(String learningUser) {
        this.learningUser = learningUser;
    }

    public String getSchoolUser() {
        return schoolUser;
    }

    public void setSchoolUser(String schoolUser) {
        this.schoolUser = schoolUser;
    }

    public String getSchoolLeader() {
        return schoolLeader;
    }

    public void setSchoolLeader(String schoolLeader) {
        this.schoolLeader = schoolLeader;
    }
}
