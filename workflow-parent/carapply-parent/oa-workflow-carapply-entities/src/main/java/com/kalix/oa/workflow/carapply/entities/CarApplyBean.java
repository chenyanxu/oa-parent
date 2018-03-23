package com.kalix.oa.workflow.carapply.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.middleware.workflow.api.model.WorkflowEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Date;

/**
 * @类描述：用车申请管理
 * @创建人： sunlf
 * @创建时间：2016/2/24
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "oa_workflow_carapply")
@Inheritance(strategy = InheritanceType.JOINED)
public class CarApplyBean extends WorkflowEntity {
    private String reason;            //用车事由
    private Integer usageCount;       //乘车人数
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date beginDate;           //用车时段,开始时间
    @JsonFormat(shape= JsonFormat.Shape.STRING ,pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endDate;             //用车时段，结束时间
    private String address;           //用车起始地点
    private Boolean city = true;      //是否市内用车
    private String operatorPhone;     //申请人联系电话
    private String depUser;           //申请部门负责人签字
    private String depManageUser;     //申请部门主管领导签批
    private String schoolUser;        //校务部签字
    private String schoolManageUser;  //校务部主管领导审批（市外）
    private String carNo;             //车牌号
    private String entourage;         //部门陪同人员
    private String entouragePhone;    //陪同人员电话
    private Double startKM;           //起车公里数
    private Double endKM;             //收车公里数

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

    public Boolean getCity() {
        return city;
    }

    public void setCity(Boolean city) {
        this.city = city;
    }

    public String getOperatorPhone() {
        return operatorPhone;
    }

    public void setOperatorPhone(String operatorPhone) {
        this.operatorPhone = operatorPhone;
    }

    public String getDepUser() {
        return depUser;
    }

    public void setDepUser(String depUser) {
        this.depUser = depUser;
    }

    public String getDepManageUser() {
        return depManageUser;
    }

    public void setDepManageUser(String depManageUser) {
        this.depManageUser = depManageUser;
    }

    public String getSchoolUser() {
        return schoolUser;
    }

    public void setSchoolUser(String schoolUser) {
        this.schoolUser = schoolUser;
    }

    public String getSchoolManageUser() {
        return schoolManageUser;
    }

    public void setSchoolManageUser(String schoolManageUser) {
        this.schoolManageUser = schoolManageUser;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getEntourage() {
        return entourage;
    }

    public void setEntourage(String entourage) {
        this.entourage = entourage;
    }

    public String getEntouragePhone() {
        return entouragePhone;
    }

    public void setEntouragePhone(String entouragePhone) {
        this.entouragePhone = entouragePhone;
    }

    public Double getStartKM() {
        return startKM;
    }

    public void setStartKM(Double startKM) {
        this.startKM = startKM;
    }

    public Double getEndKM() {
        return endKM;
    }

    public void setEndKM(Double endKM) {
        this.endKM = endKM;
    }
}
