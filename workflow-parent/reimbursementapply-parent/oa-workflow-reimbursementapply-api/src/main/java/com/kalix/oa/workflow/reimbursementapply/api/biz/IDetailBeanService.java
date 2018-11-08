package com.kalix.oa.workflow.reimbursementapply.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.oa.workflow.reimbursementapply.entities.DetailBean;

/**
 * @类描述：应用服务接口.
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public interface IDetailBeanService extends IBizService<DetailBean> {
    //在此添加新的业务方法
    JsonData getDetailByReimbursementId(String reimbursementApplyId);
}
