package com.kalix.oa.workflow.redheadapply.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.middleware.workflow.api.model.WorkflowEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.util.Date;

/**
 * @类描述：红头文件申请管理
 * @创建人： sunlf
 * @创建时间：2016/2/24
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
@Entity
@Table(name = "oa_workflow_redheadapply")
@Inheritance(strategy = InheritanceType.JOINED)
public class RedheadApplyBean extends WorkflowEntity {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date docDate;//发文时间
    private String docDept; //发文部门
    private String docCategory; // 文件分类，对内或对外
    private Integer docType; //发文类型，多种类型，数据字典中配置
    //    private String title; //文题，使用父类的title字段
    private String docUrl;//发文地址，需要在审批通过后填写
    private String docContent;//文档内容
    private String docStatus; //文档状态，需要状态机统一进行控制
    //    private String docNumber; //发文编号，使用父类的businessNo字段
//    private String editor; //拟稿人 使用父类的createBy字段
//    private String editorDept; //拟稿部门  使用父类的orgName字段
    private String printer; //打印人
    private String checker; //校对
    private Integer page; //页数
    private Integer number; //份数
    private String other; //抄送
    private String depUser;//部门领导签字
    private String schoolUser;//校务部签字
    private String managerUser;//校领导签字
    private String chairmanUser;//董事长审核

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

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public String getDocContent() {
        return docContent;
    }

    public void setDocContent(String docContent) {
        this.docContent = docContent;
    }

    public String getDocStatus() {
        return docStatus;
    }

    public void setDocStatus(String docStatus) {
        this.docStatus = docStatus;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getDepUser() {
        return depUser;
    }

    public void setDepUser(String depUser) {
        this.depUser = depUser;
    }

    public String getSchoolUser() {
        return schoolUser;
    }

    public void setSchoolUser(String schoolUser) {
        this.schoolUser = schoolUser;
    }

    public String getManagerUser() {
        return managerUser;
    }

    public void setManagerUser(String managerUser) {
        this.managerUser = managerUser;
    }

    public String getChairmanUser() {
        return chairmanUser;
    }

    public void setChairmanUser(String chairmanUser) {
        this.chairmanUser = chairmanUser;
    }

    public String getDocCategory() {
        return docCategory;
    }

    public void setDocCategory(String docCategory) {
        this.docCategory = docCategory;
    }
}


