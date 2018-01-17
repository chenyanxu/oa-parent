package com.kalix.oa.workflow.redheadapply.api.biz;


import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.oa.workflow.redheadapply.entities.DocumentBean;

/**
 * @author sunlf
 */
public interface IDocumentBeanService extends IBizService<DocumentBean> {
    /**
     * 查询发文信息-最小可使用文号
     *
     * @param docType 发文类型【文号类型】
     * @param year    年份
     * @param status  文号状态
     * @return
     */
    DocumentBean getMinEntity(Integer docType, String year, String status);

    /**
     * 查询发文信息-通过文号进行查询
     *
     * @param businessNo 文号
     * @return
     */
    DocumentBean getEntityByBusinessNo(String businessNo);

    /**
     * 废除文号
     *
     * @param id 文号实体id
     * @return
     */
    JsonStatus abolishBusinessNo(Long id);

    /**
     * 发文
     *
     * @param id     文号实体id
     * @param entity 文号实体
     * @return
     */
    JsonStatus publishRedhead(Long id, DocumentBean entity);
}
