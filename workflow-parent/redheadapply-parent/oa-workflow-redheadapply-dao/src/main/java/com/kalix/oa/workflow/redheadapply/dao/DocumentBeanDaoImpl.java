package com.kalix.oa.workflow.redheadapply.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.redheadapply.api.dao.IDocumentBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.DocumentBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sunlf
 */
public class DocumentBeanDaoImpl extends GenericDao<DocumentBean, Long> implements IDocumentBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-redheadapply-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
