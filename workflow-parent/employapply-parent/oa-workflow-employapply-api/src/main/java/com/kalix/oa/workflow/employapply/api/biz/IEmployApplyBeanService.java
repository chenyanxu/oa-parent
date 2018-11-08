package com.kalix.oa.workflow.employapply.api.biz;


import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.middleware.workflow.api.biz.IWorkflowBizService;
import com.kalix.oa.workflow.employapply.api.query.EmployApplyDTO;
import com.kalix.oa.workflow.employapply.entities.EmployApplyBean;

/**
 * @author sunlf
 */
public interface IEmployApplyBeanService extends IWorkflowBizService<EmployApplyBean> {
      final String PROCESS_KEY_NAME="employapply";
      JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr);

      EmployApplyDTO getDTOModel(String id);
}
