package com.kalix.oa.workflow.evectionapply.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.workflow.evectionapply.api.biz.IEvectionApplyBeanService;
import com.kalix.oa.workflow.evectionapply.api.dao.IEvectionApplyBeanDao;
import com.kalix.oa.workflow.evectionapply.api.dao.ILoanBeanDao;
import com.kalix.oa.workflow.evectionapply.entities.EvectionApplyBean;
import com.kalix.oa.workflow.evectionapply.entities.LoanBean;
import com.kalix.oa.workflow.reimbursementapply.api.dao.IReimbursementApplyBeanDao;
import com.kalix.oa.workflow.reimbursementapply.entities.ReimbursementApplyBean;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @类描述： 
 * @创建人：  
 * @创建时间： 
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class EvectionApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IEvectionApplyBeanDao, EvectionApplyBean> implements IEvectionApplyBeanService {
    ILoanBeanDao loanBeanDao;
    IReimbursementApplyBeanDao reimbursementApplyBeanDao;

    public void setLoanBeanDao(ILoanBeanDao loanBeanDao) {
        this.loanBeanDao = loanBeanDao;
    }

    public void setReimbursementApplyBeanDao(IReimbursementApplyBeanDao reimbursementApplyBeanDao) {
        this.reimbursementApplyBeanDao = reimbursementApplyBeanDao;
    }

    @Override
    public String getProcessKeyName() {
        return PROCESS_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map, EvectionApplyBean bean) {
        return map;
    }

    @Override
    @Transactional
    public JsonStatus completeTask(String taskId, String accepted, String comment) {
        JsonStatus jsonStatus = super.completeTask(taskId, accepted, comment);
        //出差申请审批流程结束时，并且审批都通过时，向报销表添加记录，以便启动报销流程
        if (jsonStatus.getTag() != null && jsonStatus.getTag().startsWith("流程结束:") && accepted.equals("同意")) {
            Long evectionApplyId = Long.valueOf(jsonStatus.getTag().split(":")[1]);

            //出差人id,组织机构id
            Long createById, orgId;
            //出差人名称,题目,组织机构名称,出差原因,项目名称
            String ceateBy, title, orgName, reason, projectName;
            //借款金额
            Float borrowMoney;
            //出差申请记录
            EvectionApplyBean evectionApplyBean = this.getEntity(evectionApplyId);
            createById = evectionApplyBean.getCreateById();
            orgId = evectionApplyBean.getOrgId();
            ceateBy = evectionApplyBean.getCreateBy();
            title = "吉林动画学院出差报销申请表";
            orgName = evectionApplyBean.getOrgName();
            reason = evectionApplyBean.getReason();
            projectName = evectionApplyBean.getProjectName();

            Float bussinessMoney = 0f, foodMoney = 0f, hotelMoney = 0f, trafficMoney = 0f, otherMoney = 0f;
            //与该出差申请对应的出差借款记录
            List<LoanBean> loanBeanList = loanBeanDao.find("select ob from LoanBean ob where ob.evectionId=?1", evectionApplyId);

            LoanBean tempLoanBean;
            for (int i = 0; i < loanBeanList.size(); i++) {
                tempLoanBean = loanBeanList.get(i);
                if (tempLoanBean.getBussinessMoney() != null) {
                    bussinessMoney += tempLoanBean.getBussinessMoney();
                }
                if (tempLoanBean.getFoodMoney() != null) {
                    foodMoney += tempLoanBean.getFoodMoney();
                }
                if (tempLoanBean.getHotelMoney() != null) {
                    hotelMoney += tempLoanBean.getHotelMoney();
                }
                if (tempLoanBean.getTrafficMoney() != null) {
                    trafficMoney += tempLoanBean.getTrafficMoney();
                }
                if (tempLoanBean.getOtherMoney() != null) {
                    otherMoney += tempLoanBean.getOtherMoney();
                }
            }

            borrowMoney = bussinessMoney + foodMoney + hotelMoney + trafficMoney + otherMoney;

            ReimbursementApplyBean reimbursementApplyBean = new ReimbursementApplyBean();
            reimbursementApplyBean.setCreateById(createById);
            reimbursementApplyBean.setOrgId(orgId);
            reimbursementApplyBean.setCreateBy(ceateBy);
            reimbursementApplyBean.setTitle(title);
            reimbursementApplyBean.setOrgName(orgName);
            reimbursementApplyBean.setReason(reason);
            reimbursementApplyBean.setProjectName(projectName);
            reimbursementApplyBean.setBorrowMoney(borrowMoney);

            //向报销表添加有出差申请的报销记录
            reimbursementApplyBeanDao.save(reimbursementApplyBean);
        }

        return jsonStatus;
    }
}
