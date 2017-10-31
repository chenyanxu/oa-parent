package com.kalix.oa.workflow.tempapply.dao;


import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.tempapply.api.dao.ITempApplyBeanDao;
import com.kalix.oa.workflow.tempapply.entities.TempApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author chenyanxu
 */
public class TempApplyBeanDaoImpl extends GenericDao<TempApplyBean, Long> implements ITempApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-tempapply")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
