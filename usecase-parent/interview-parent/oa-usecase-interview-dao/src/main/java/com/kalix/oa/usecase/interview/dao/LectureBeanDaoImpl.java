package com.kalix.oa.usecase.interview.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.usecase.interview.api.dao.ILectureBeanDao;
import com.kalix.oa.usecase.interview.entities.LectureBean;

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
public class LectureBeanDaoImpl extends GenericDao<LectureBean, String> implements ILectureBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-usecase-interview")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
