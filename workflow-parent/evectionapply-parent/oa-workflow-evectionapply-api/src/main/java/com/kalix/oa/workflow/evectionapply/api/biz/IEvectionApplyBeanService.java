package com.kalix.oa.workflow.evectionapply.api.biz;

import com.kalix.middleware.workflow.api.biz.IWorkflowBizService;
import com.kalix.oa.workflow.evectionapply.entities.EvectionApplyBean;

/**
 * @类描述：应用服务接口.
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public interface IEvectionApplyBeanService extends IWorkflowBizService<EvectionApplyBean> {
    final String PROCESS_KEY_NAME="evectionapply";
}
