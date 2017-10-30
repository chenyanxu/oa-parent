package com.kalix.oa.workflow.tempapply.biz.form;


import com.kalix.middleware.workflow.biz.AbstractEndFormHandler;

/**
 * Created by sunlf on 2015/8/4.
 * 审批页面实现类
 */
public class TempApplyEndFormImpl extends AbstractEndFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.sealApply.view.TempApplyViewForm";
    }
}
