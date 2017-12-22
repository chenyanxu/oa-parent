package com.kalix.oa.workflow.redheadapply.api.biz;


import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.oa.workflow.redheadapply.entities.DocumentBean;

/**
 * @author sunlf
 */
public interface IDocumentBeanService extends IBizService<DocumentBean> {
    /**
     * 查询发文信息
     * @param docType 发文类型【文号类型】
     * @param status 文号状态
     * @return
     */
    DocumentBean getMinEntity(Integer docType, String year, String status);
}
