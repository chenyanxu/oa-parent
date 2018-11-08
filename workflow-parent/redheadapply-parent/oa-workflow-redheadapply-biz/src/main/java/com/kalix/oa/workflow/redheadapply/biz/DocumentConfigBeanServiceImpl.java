package com.kalix.oa.workflow.redheadapply.biz;

import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.oa.workflow.redheadapply.api.biz.IDocumentConfigBeanService;
import com.kalix.oa.workflow.redheadapply.api.dao.IDocumentConfigBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.DocumentConfigBean;

/**
 * @author sunlf
 */
public class DocumentConfigBeanServiceImpl extends ShiroGenericBizServiceImpl<IDocumentConfigBeanDao, DocumentConfigBean> implements IDocumentConfigBeanService {

    @Override
    public DocumentConfigBean getEntity(Integer docType, String year) {
        return this.dao.getEntity(docType, year);
    }

    @Override
    public Integer updateNumber(String id, Integer number) {
        return this.dao.updateNumber(id, number);
    }
}
