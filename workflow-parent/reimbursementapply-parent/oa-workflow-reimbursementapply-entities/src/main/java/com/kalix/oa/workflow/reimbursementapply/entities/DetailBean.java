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
public class DetailBean extends WorkflowEntity {

    private Integer startMonth;
    private Integer startDay;
    private String startTime;
    private String startPlace;
    private Integer arriveMonth;
    private Integer arriveDay;
    private String arriveTime;
    private String arrivePlace;
    private Integer personNumber;
    private String trafficTool;
    private Float trafficMoney;
    private Integer dayNumber;
    private Float subsidyStandard;
    private Float subsidyMoney;
    private Float hotelMoney;
    private Float cityTrafficMoney;
    private Float otherMoneyOne;
    private Float otherMoneyTwo;
    private Float otherMoneyThree;
    private Float totalMoney;

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public Integer getArriveMonth() {
        return arriveMonth;
    }

    public void setArriveMonth(Integer arriveMonth) {
        this.arriveMonth = arriveMonth;
    }

    public Integer getArriveDay() {
        return arriveDay;
    }

    public void setArriveDay(Integer arriveDay) {
        this.arriveDay = arriveDay;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getArrivePlace() {
        return arrivePlace;
    }

    public void setArrivePlace(String arrivePlace) {
        this.arrivePlace = arrivePlace;
    }

    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    public String getTrafficTool() {
        return trafficTool;
    }

    public void setTrafficTool(String trafficTool) {
        this.trafficTool = trafficTool;
    }

    public Float getTrafficMoney() {
        return trafficMoney;
    }

    public void setTrafficMoney(Float trafficMoney) {
        this.trafficMoney = trafficMoney;
    }

    public Integer getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Integer dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Float getSubsidyStandard() {
        return subsidyStandard;
    }

    public void setSubsidyStandard(Float subsidyStandard) {
        this.subsidyStandard = subsidyStandard;
    }

    public Float getSubsidyMoney() {
        return subsidyMoney;
    }

    public void setSubsidyMoney(Float subsidyMoney) {
        this.subsidyMoney = subsidyMoney;
    }

    public Float getHotelMoney() {
        return hotelMoney;
    }

    public void setHotelMoney(Float hotelMoney) {
        this.hotelMoney = hotelMoney;
    }

    public Float getCityTrafficMoney() {
        return cityTrafficMoney;
    }

    public void setCityTrafficMoney(Float cityTrafficMoney) {
        this.cityTrafficMoney = cityTrafficMoney;
    }

    public Float getOtherMoneyOne() {
        return otherMoneyOne;
    }

    public void setOtherMoneyOne(Float otherMoneyOne) {
        this.otherMoneyOne = otherMoneyOne;
    }

    public Float getOtherMoneyTwo() {
        return otherMoneyTwo;
    }

    public void setOtherMoneyTwo(Float otherMoneyTwo) {
        this.otherMoneyTwo = otherMoneyTwo;
    }

    public Float getOtherMoneyThree() {
        return otherMoneyThree;
    }

    public void setOtherMoneyThree(Float otherMoneyThree) {
        this.otherMoneyThree = otherMoneyThree;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }
}
