package com.kalix.oa.workflow.sealapply.dao;


import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.sealapply.api.dao.ISealApplyBeanDao;
import com.kalix.oa.workflow.sealapply.entities.SealApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author chenyanxu
 */
public class SealApplyBeanDaoImpl extends GenericDao<SealApplyBean, String> implements ISealApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-sealapply")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
