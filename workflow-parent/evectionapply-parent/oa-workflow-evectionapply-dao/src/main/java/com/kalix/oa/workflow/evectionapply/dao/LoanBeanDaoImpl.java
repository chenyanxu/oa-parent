package com.kalix.oa.workflow.evectionapply.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.evectionapply.api.dao.ILoanBeanDao;
import com.kalix.oa.workflow.evectionapply.entities.LoanBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class LoanBeanDaoImpl extends GenericDao<LoanBean, String> implements ILoanBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-evectionapply-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
    //todo add custom query

}
