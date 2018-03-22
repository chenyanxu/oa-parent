package com.kalix.oa.workflow.carapply.biz.form;

import com.kalix.middleware.workflow.biz.AbstractBizDataFormHandler;

/**
 * @author hqj
 *         教学用车申请业务数据表单
 */
public class TeachingCarApplyBizDataFormImpl extends AbstractBizDataFormHandler {
    @Override
    public String getFormClass() {
        return "kalix.workflow.teachingCarApply.view.TeachingCarApplyViewForm";
    }
}
