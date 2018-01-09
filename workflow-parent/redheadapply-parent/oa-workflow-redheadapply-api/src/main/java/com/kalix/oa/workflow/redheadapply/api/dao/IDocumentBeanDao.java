package com.kalix.oa.workflow.redheadapply.api.dao;


import com.kalix.framework.core.api.dao.IGenericDao;
import com.kalix.oa.workflow.redheadapply.entities.DocumentBean;

/**
 * @author sunlf
 */
public interface IDocumentBeanDao extends IGenericDao<DocumentBean, Long> {
    /**
     * 查询发文信息
     * @param docType 发文类型【文号类型】
     * @param year 年份
     * @param status 文号状态
     * @return
     */
    DocumentBean getMinEntity(Integer docType, String year, String status);

    /**
     * 查询发文信息
     * @param businessNo 文号
     * @return
     */
    DocumentBean getEntityByBusinessNo(String businessNo);
}
