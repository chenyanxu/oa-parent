package com.kalix.oa.workflow.recruitapply.dao;


import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.recruitapply.api.dao.IRecruitApplyBeanDao;
import com.kalix.oa.workflow.recruitapply.entities.RecruitApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by zangyanming on 2016/6/15.
 */
public class RecruitApplyBeanDaoImpl extends GenericDao<RecruitApplyBean, String> implements IRecruitApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-recruitapply")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
