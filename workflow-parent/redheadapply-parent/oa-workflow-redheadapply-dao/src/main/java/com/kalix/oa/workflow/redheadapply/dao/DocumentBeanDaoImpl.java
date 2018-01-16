package com.kalix.oa.workflow.redheadapply.dao;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.dao.CommonMethod;
import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.redheadapply.api.dao.IDocumentBeanDao;
import com.kalix.oa.workflow.redheadapply.dto.model.DocumentDTO;
import com.kalix.oa.workflow.redheadapply.entities.DocumentBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author sunlf
 */
public class DocumentBeanDaoImpl extends GenericDao<DocumentBean, Long> implements IDocumentBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-redheadapply-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }

    @Override
    public DocumentBean getMinEntity(Integer docType, String year, String status) {
        DocumentBean documentBean = null;
        //String sql = "select Min(d.number) number, d.businessNo from " + this.getTableName() + " d where d.docType = ?1 and d.status = ?2";
        String hql = "select d from DocumentBean d where d.docType = ?1 and d.year = ?2 and d.status = ?3 order by d.number";
        List<DocumentBean> lists = this.find(hql, docType, year, status);
        if (lists != null && lists.size() > 0) {
            documentBean = lists.get(0);
        }
        return documentBean;
    }

    @Override
    public DocumentBean getEntityByBusinessNo(String businessNo) {
        DocumentBean documentBean = null;
        String hql = "select d from DocumentBean d where d.businessNo = ?1";
        List<DocumentBean> lists = this.find(hql, businessNo);
        if (lists != null && lists.size() > 0) {
            documentBean = lists.get(0);
        }
        return documentBean;
    }

    @Override
    public JsonData getAllRelations(Integer page, Integer limit, String jsonStr, String sort) {
        String sql = "select t.* from " +
                " (select a.id, a.docType, a.year, a.number, a.businessNo, a.status, a.redheadId, " +
                " a.creationDate, a.updateDate, b.docDate, b.docDept, b.title, b.docUrl, b.docContent, b.docStatus " +
                " from " + super.getTableName() + " a " +
                " left join oa_workflow_redheadapply b on b.id = a.redheadId) t ";
        sql += CommonMethod.createWhereCondition(jsonStr, sort);
        JsonData jsonData = this.findByNativeSql(sql, page, limit, DocumentDTO.class);
        return jsonData;
    }
}
