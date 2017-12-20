package com.kalix.oa.workflow.redheadapply.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.redheadapply.api.dao.IDocumentConfigBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.DocumentConfigBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sunlf
 */
public class DocumentConfigBeanDaoImpl extends GenericDao<DocumentConfigBean, Long> implements IDocumentConfigBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-redheadapply-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
