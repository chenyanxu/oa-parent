package com.kalix.oa.workflow.redheadapply.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.oa.workflow.redheadapply.entities.DocumentConfigBean;

/**
 * @author sunlf
 */
public interface IDocumentConfigBeanService extends IBizService<DocumentConfigBean> {
    /**
     * 获取文号配置实体
     * @param docType 发文类型
     * @param year 年份
     * @return
     */
    DocumentConfigBean getEntity(Integer docType, String year);

    Integer updateNumber(String id, Integer number);
}
