package com.kalix.oa.workflow.reimbursementapply.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.reimbursementapply.api.dao.IReimbursementApplyBeanDao;
import com.kalix.oa.workflow.reimbursementapply.entities.ReimbursementApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author zangyanming
 */
public class ReimbursementApplyBeanDaoImpl extends GenericDao<ReimbursementApplyBean, Long> implements IReimbursementApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-reimbursementapply-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
