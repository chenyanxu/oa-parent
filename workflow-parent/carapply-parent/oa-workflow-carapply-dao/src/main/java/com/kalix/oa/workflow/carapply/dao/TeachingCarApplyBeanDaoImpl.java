package com.kalix.oa.workflow.carapply.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.carapply.api.dao.ITeachingCarApplyBeanDao;
import com.kalix.oa.workflow.carapply.entities.TeachingCarApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author hqj
 */
public class TeachingCarApplyBeanDaoImpl extends GenericDao<TeachingCarApplyBean, Long> implements ITeachingCarApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-carapply-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
