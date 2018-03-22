package com.kalix.oa.workflow.carapply.api.biz;

import com.kalix.middleware.workflow.api.biz.IWorkflowBizService;
import com.kalix.oa.workflow.carapply.entities.TeachingCarApplyBean;

/**
 * @author hqj
 */
public interface ITeachingCarApplyBeanService extends IWorkflowBizService<TeachingCarApplyBean> {
    final String PROCESS_KEY_NAME = "teachingcarapply";
}
