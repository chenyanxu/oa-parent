package com.kalix.oa.workflow.redheadapply.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @类描述：文号配置实体
 * @创建人： sunlf
 * @创建时间：2016/2/24
 * @修改人：
 * @修改时间：
 * @修改备注：根据不同文号类型，按年份保留最新可用的编号
 */
@Entity
@Table(name = "oa_workflow_document_config")
@Inheritance(strategy = InheritanceType.JOINED)
public class DocumentConfigBean extends PersistentEntity {

    private Integer docType; //发文类型，多种类型，数据字典中配置
    private Integer number; //可用编号
    private String year;//年份

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
