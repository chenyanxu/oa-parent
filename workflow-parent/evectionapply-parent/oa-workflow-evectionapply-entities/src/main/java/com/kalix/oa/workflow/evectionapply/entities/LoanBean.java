package com.kalix.oa.workflow.evectionapply.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

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
@Table(name = "oa_workflow_loan")
@Inheritance(strategy = InheritanceType.JOINED)
public class LoanBean extends PersistentEntity {
    /**
     * @describe 出差申请流程ID
     */
    private Long evectionId;
    /**
     * @describe 交通费用
     */
    private Integer trafficMoney;
    /**
     * @describe 餐费
     */
    private Integer foodMoney;
    /**
     * @describe 住宿费用
     */
    private Integer hotelMoney;
    /**
     * @describe 业务费用
     */
    private Integer bussinessMoney;
    /**
     * @describe 其他费用
     */
    private Integer otherMoney;
    /**
     * @describe 备注说明
     */
    private String comment;

    public Long getEvectionId() {
        return evectionId;
    }

    public void setEvectionId(Long evectionId) {
        this.evectionId = evectionId;
    }

    public Integer getTrafficMoney() {
        return trafficMoney;
    }

    public void setTrafficMoney(Integer trafficMoney) {
        this.trafficMoney = trafficMoney;
    }

    public Integer getFoodMoney() {
        return foodMoney;
    }

    public void setFoodMoney(Integer foodMoney) {
        this.foodMoney = foodMoney;
    }

    public Integer getHotelMoney() {
        return hotelMoney;
    }

    public void setHotelMoney(Integer hotelMoney) {
        this.hotelMoney = hotelMoney;
    }

    public Integer getBussinessMoney() {
        return bussinessMoney;
    }

    public void setBussinessMoney(Integer bussinessMoney) {
        this.bussinessMoney = bussinessMoney;
    }

    public Integer getOtherMoney() {
        return otherMoney;
    }

    public void setOtherMoney(Integer otherMoney) {
        this.otherMoney = otherMoney;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
