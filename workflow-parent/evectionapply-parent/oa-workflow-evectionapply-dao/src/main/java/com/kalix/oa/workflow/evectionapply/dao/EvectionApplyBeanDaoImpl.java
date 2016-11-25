package com.kalix.oa.workflow.evectionapply.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.evectionapply.api.dao.IEvectionApplyBeanDao;
import com.kalix.oa.workflow.evectionapply.entities.EvectionApplyBean;

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
public class EvectionApplyBeanDaoImpl extends GenericDao<EvectionApplyBean, Long> implements IEvectionApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-evectionapply-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
    //todo add custom query

}
