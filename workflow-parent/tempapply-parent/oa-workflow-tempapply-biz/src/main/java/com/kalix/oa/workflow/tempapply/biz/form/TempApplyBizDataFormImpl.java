package com.kalix.oa.workflow.tempapply.biz.form;


import com.kalix.middleware.workflow.biz.AbstractBizDataFormHandler;

/**
 * @author chenyanxu
 *         用车申请业务数据表单
 */
public class TempApplyBizDataFormImpl extends AbstractBizDataFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.sealApply.view.TempApplyViewForm";
    }
}
