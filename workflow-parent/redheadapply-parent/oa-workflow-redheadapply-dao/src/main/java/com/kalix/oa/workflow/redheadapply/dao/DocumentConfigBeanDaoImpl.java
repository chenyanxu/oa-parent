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

    @Override
    public DocumentConfigBean getEntity(Integer docType, String year) {
        String hql = "select c from DocumentConfigBean c where c.docType = ?1 and c.year = ?2";
        return this.findUnique(hql, docType, year);
    }

    @Override
    public Integer updateNumber(Long id, Integer number) {
        String sql = "update " + this.getTableName() + " set number = " + number + " where id = " + id;
        return this.updateNativeQuery(sql);
    }
}
