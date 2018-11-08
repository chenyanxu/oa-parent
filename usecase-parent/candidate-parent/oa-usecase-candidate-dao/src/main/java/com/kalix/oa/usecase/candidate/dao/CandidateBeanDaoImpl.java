package com.kalix.oa.usecase.candidate.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.usecase.candidate.api.dao.ICandidateBeanDao;
import com.kalix.oa.usecase.candidate.entities.CandidateBean;

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
public class CandidateBeanDaoImpl extends GenericDao<CandidateBean, String> implements ICandidateBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-usecase-candidate")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
