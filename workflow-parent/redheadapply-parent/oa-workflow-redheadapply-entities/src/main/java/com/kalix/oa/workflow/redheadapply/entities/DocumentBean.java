package com.kalix.oa.workflow.redheadapply.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @类描述：红头文件文号管理(文号使用历史log)
 * @创建人： sunlf
 * @创建时间：2016/2/24
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "oa_workflow_document")
@Inheritance(strategy = InheritanceType.JOINED)
public class DocumentBean extends PersistentEntity {
    private Integer docType;   //发文类型，多种类型，数据字典中配置[文号类型]
    private String year;       //年份
    private Integer number;    //可用编号
    @Column(unique = true)
    private String businessNo; //文号
    private String status;     //文号状态，需要状态机统一进行控制
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date docDate;      //发文时间
    private String docDept;    //发文部门
    private String printer;    //打印人
    private String checker;    //校对
    private Integer page;      //页数
    private Integer copy;      //份数
    private String other;      //抄送
    private Long redheadId;    //红头文件id

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getDocDept() {
        return docDept;
    }

    public void setDocDept(String docDept) {
        this.docDept = docDept;
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCopy() {
        return copy;
    }

    public void setCopy(Integer copy) {
        this.copy = copy;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Long getRedheadId() {
        return redheadId;
    }

    public void setRedheadId(Long redheadId) {
        this.redheadId = redheadId;
    }
}
