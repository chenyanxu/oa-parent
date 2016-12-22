package com.kalix.oa.workflow.reimbursementapply.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.reimbursementapply.api.dao.IDetailBeanDao;
import com.kalix.oa.workflow.reimbursementapply.entities.DetailBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @类描述：
 * @创建人：
 * @创建时间：
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class DetailBeanDaoImpl extends GenericDao<DetailBean, Long> implements IDetailBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-reimbursementapply-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
    //todo add custom query

}
