package com.kalix.oa.workflow.evectionapply.biz.form;


import com.kalix.middleware.workflow.biz.AbstractBizDataFormHandler;

/**
 * @author zangyanming
 *         用车申请业务数据表单
 */
public class EvectionApplyBizDataFormImpl extends AbstractBizDataFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.evectionApply.view.EvectionApplyViewForm";
    }
}
