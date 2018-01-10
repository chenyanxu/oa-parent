package com.kalix.oa.workflow.redheadapply.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.oa.workflow.redheadapply.api.biz.IDocumentBeanService;
import com.kalix.oa.workflow.redheadapply.api.dao.IDocumentBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.DocumentBean;


/**
 * @author sunlf
 */
public class DocumentBeanServiceImpl extends ShiroGenericBizServiceImpl<IDocumentBeanDao, DocumentBean> implements IDocumentBeanService {

    @Override
    public DocumentBean getMinEntity(Integer docType, String year, String status) {
        return this.dao.getMinEntity(docType, year, status);
    }

    @Override
    public DocumentBean getEntityByBusinessNo(String businessNo) {
        return this.dao.getEntityByBusinessNo(businessNo);
    }

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        return dao.getAllRelations(page, limit, jsonStr, sort);
    }
}
