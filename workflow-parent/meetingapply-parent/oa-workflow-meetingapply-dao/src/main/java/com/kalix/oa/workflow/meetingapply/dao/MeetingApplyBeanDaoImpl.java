package com.kalix.oa.workflow.meetingapply.dao;


import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.meetingapply.api.dao.IMeetingApplyBeanDao;
import com.kalix.oa.workflow.meetingapply.entities.MeetingApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sunlf
 */
public class MeetingApplyBeanDaoImpl extends GenericDao<MeetingApplyBean, Long> implements IMeetingApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-meetingapply")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
