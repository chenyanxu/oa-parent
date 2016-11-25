package com.kalix.oa.workflow.evectionapply.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.oa.workflow.evectionapply.api.biz.ILoanBeanService;
import com.kalix.oa.workflow.evectionapply.api.dao.ILoanBeanDao;
import com.kalix.oa.workflow.evectionapply.entities.LoanBean;

/**
 * @类描述： 
 * @创建人：  
 * @创建时间： 
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class LoanBeanServiceImpl extends ShiroGenericBizServiceImpl<ILoanBeanDao, LoanBean> implements ILoanBeanService {
    private JsonStatus jsonStatus = new JsonStatus();
    public LoanBeanServiceImpl() {
        super.init(LoanBean.class.getName());
    }
}
