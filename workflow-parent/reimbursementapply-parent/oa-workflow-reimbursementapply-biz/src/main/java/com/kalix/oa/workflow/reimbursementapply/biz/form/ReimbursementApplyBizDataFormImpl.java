package com.kalix.oa.workflow.reimbursementapply.biz.form;


import com.kalix.middleware.workflow.biz.AbstractBizDataFormHandler;

/**
 * @author chenyanxu
 *         报销申请业务数据表单
 */
public class ReimbursementApplyBizDataFormImpl extends AbstractBizDataFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.reimbursementApply.view.ReimbursementApplyViewForm";
    }
}
