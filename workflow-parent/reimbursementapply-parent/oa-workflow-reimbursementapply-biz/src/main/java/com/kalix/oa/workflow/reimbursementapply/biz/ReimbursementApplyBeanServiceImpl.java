package com.kalix.oa.workflow.reimbursementapply.biz;

import com.kalix.admin.core.api.biz.IUserBeanService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.util.BeanUtil;
import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.workflow.reimbursementapply.api.biz.IReimbursementApplyBeanService;
import com.kalix.oa.workflow.reimbursementapply.api.dao.IReimbursementApplyBeanDao;
import com.kalix.oa.workflow.reimbursementapply.entities.ReimbursementApplyBean;

import java.util.List;
import java.util.Map;

/**
 * @author chenyanxu
 */
public class ReimbursementApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IReimbursementApplyBeanDao, ReimbursementApplyBean> implements IReimbursementApplyBeanService {
    private IUserBeanService userBeanService;

    public void setUserBeanService(IUserBeanService userBeanService) {
        this.userBeanService = userBeanService;
    }

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort){
        JsonData jsonData = super.getAllEntityByQuery(page, limit, jsonStr, sort);
        List beanList = jsonData.getData();
        //翻译任务负责人
        List ids = BeanUtil.getBeanFieldValueList(beanList, "bussinessPeopleId");
        List values = this.userBeanService.getFieldValuesByIds(ids.toArray(), "name");
        BeanUtil.setBeanListFieldValues(beanList, "bussinessPeopleName", values);

        jsonData.setData(beanList);

        return jsonData;
    }

    @Override
    protected String getNativeQueryStr() {
        return "select a.id," +
                "a.createby," +
                "a.title," +
                "a.begindate," +
                "a.orgname," +
                "a.enddate," +
                "a.reason," +
                "b.reimbursementdate," +
                "b.reimbursementno," +
                "b.projectname," +
                "b.manageruser," +
                "b.depuser as depuserback," +
                "b.financeuser," +
                "b.accountantuser as accountantuserback," +
                "b.cashieruser as cashieruserback," +
                "b.payeeuser," +
                "b.borrowmoney," +
                "b.backmoney," +
                //"b.title," +
                "b.orgid," +
                //"b.orgname," +
                "b.processinstanceid," +
                "b.currentnode," +
                "b.status," +
                "b.auditresult," +
                "b.businessno," +
                "b.creationdate" +
                " from oa_workflow_evectionapply a " +
                " left join oa_workflow_reimbursementapply b " +
                " on a.id = b.evectionapplyid" +
                " where a.auditresult = '审批通过' " +
                "";
    }

    @Override
    public String getProcessKeyName() {
        return PROCESS_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map,ReimbursementApplyBean bean) {
        return map;
    }
}
