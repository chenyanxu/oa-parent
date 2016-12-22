package com.kalix.oa.workflow.reimbursementapply.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.workflow.reimbursementapply.api.biz.IReimbursementApplyBeanService;
import com.kalix.oa.workflow.reimbursementapply.api.dao.IReimbursementApplyBeanDao;
import com.kalix.oa.workflow.reimbursementapply.entities.ReimbursementApplyBean;

import java.util.Map;

/**
 * @author chenyanxu
 */
public class ReimbursementApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IReimbursementApplyBeanDao, ReimbursementApplyBean> implements IReimbursementApplyBeanService {
    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort){
        return super.getAllEntityByQuery(page, limit, jsonStr, sort);
//        JsonData jsonData = new JsonData();
//        List<ReimbursementApplyDTO> dtoList = dao.findByNativeSql(getNativeQueryStr(),ReimbursementApplyDTO.class,null);
//
//        jsonData.setTotalCount((long)dtoList.size());
//        jsonData.setData(dtoList);
//        return jsonData;
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
