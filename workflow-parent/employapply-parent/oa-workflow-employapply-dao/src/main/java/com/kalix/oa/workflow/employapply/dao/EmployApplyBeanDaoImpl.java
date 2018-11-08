package com.kalix.oa.workflow.employapply.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.employapply.api.dao.IEmployApplyBeanDao;
import com.kalix.oa.workflow.employapply.entities.EmployApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sunlf
 */
public class EmployApplyBeanDaoImpl extends GenericDao<EmployApplyBean, String> implements IEmployApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-employapply")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
