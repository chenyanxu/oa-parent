package com.kalix.oa.workflow.reimbursementapply.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.oa.workflow.reimbursementapply.api.biz.IDetailBeanService;
import com.kalix.oa.workflow.reimbursementapply.api.dao.IDetailBeanDao;
import com.kalix.oa.workflow.reimbursementapply.entities.DetailBean;

/**
 * @类描述： 
 * @创建人：  
 * @创建时间： 
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class DetailBeanServiceImpl extends ShiroGenericBizServiceImpl<IDetailBeanDao, DetailBean> implements IDetailBeanService {
    public DetailBeanServiceImpl() {
        super.init(DetailBean.class.getName());
    }

    @Override
    public JsonData getDetailByReimbursementId(String reimbursementApplyId){
        String jsonStr;
        jsonStr = "{\"reimbursementApplyId\":"+reimbursementApplyId+"}";
        return this.getAllEntityByQuery(1,100,jsonStr);
    }
}
