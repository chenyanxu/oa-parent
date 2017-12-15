package com.kalix.oa.workflow.redheadapply.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.redheadapply.api.dao.IRedheadApplyBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.RedheadApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sunlf
 */
public class RedheadApplyBeanDaoImpl extends GenericDao<RedheadApplyBean, Long> implements IRedheadApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-redheadapply-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
