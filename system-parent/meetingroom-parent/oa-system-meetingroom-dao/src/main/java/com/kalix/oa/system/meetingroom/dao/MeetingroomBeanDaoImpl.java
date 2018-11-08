package com.kalix.oa.system.meetingroom.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.system.meetingroom.api.dao.IMeetingroomBeanDao;
import com.kalix.oa.system.meetingroom.entities.MeetingroomBean;

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
public class MeetingroomBeanDaoImpl extends GenericDao<MeetingroomBean, String> implements IMeetingroomBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-system-meetingroom")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
    //todo add custom query

}
