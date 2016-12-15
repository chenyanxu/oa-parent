package com.kalix.oa.workflow.meetingroomapply.dao;


import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.workflow.meetingroomapply.api.dao.IMeetingRoomApplyBeanDao;
import com.kalix.oa.workflow.meetingroomapply.entities.MeetingRoomApplyBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author sunlf
 */
public class MeetingRoomApplyBeanDaoImpl extends GenericDao<MeetingRoomApplyBean, Long> implements IMeetingRoomApplyBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-workflow-meetingroomapply")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
