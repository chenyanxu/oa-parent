package com.kalix.oa.workflow.redheadapply.biz.form;


import com.kalix.middleware.workflow.biz.AbstractBizDataFormHandler;

/**
 * @author sunlf
 * 红头文件申请业务数据表单
 */
public class RedHeadApplyBizDataFormImpl extends AbstractBizDataFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.redheadapply.view.RedheadApplyViewForm";
    }
}
