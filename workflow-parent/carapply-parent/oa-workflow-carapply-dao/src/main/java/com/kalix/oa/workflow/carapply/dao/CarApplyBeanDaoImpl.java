package com.kalix.oa.workflow.carapply.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.carapply.api.dao.ICarApplyBeanDao;
import com.kalix.oa.workflow.carapply.entities.CarApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sunlf
 */
public class CarApplyBeanDaoImpl extends GenericDao<CarApplyBean, String> implements ICarApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-carapply-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
