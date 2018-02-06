package com.kalix.oa.workflow.redheadapply.entities;

        import com.kalix.middleware.workflow.api.model.WorkflowEntity;

        import javax.persistence.*;

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
    private String docCategory; // 文件分类，对内或对外
    private Integer docType; //发文类型，多种类型，数据字典中配置
    //    private String title; //文题，使用父类的title字段
    private Boolean editDocType = true; //是否允许修改发文类型字段，默认t允许修改
    private String docUrl;//发文地址，需要在审批通过后填写
    @Column(length = 10000)
    private String docContent;//文档内容
    private String docStatus; //文档状态，需要状态机统一进行控制
    //    private String docNumber; //发文编号，使用父类的businessNo字段
//    private String editor; //拟稿人 使用父类的createBy字段
//    private String editorDept; //拟稿部门  使用父类的orgName字段
    private Boolean needHeader; //是否需要校领导审批
    private String needManagerUser; //需要审批的校领导名单
    private String depUser;//部门领导签字
    private String schoolUser;//校务部签字
    private String managerUser;//校领导签字
    private String chairmanUser;//董事长审核

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public Boolean getEditDocType() {
        return editDocType;
    }

    public void setEditDocType(Boolean editDocType) {
        this.editDocType = editDocType;
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

    public Boolean getNeedHeader() {
        return needHeader;
    }

    public void setNeedHeader(Boolean needHeader) {
        this.needHeader = needHeader;
    }

    public String getNeedManagerUser() {
        return needManagerUser;
    }

    public void setNeedManagerUser(String needManagerUser) {
        this.needManagerUser = needManagerUser;
    }
}
