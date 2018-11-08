package com.kalix.oa.system.dict.dao;

import com.kalix.framework.core.impl.dao.GenericDao;
import com.kalix.oa.system.dict.api.dao.IOADictBeanDao;
import com.kalix.oa.system.dict.entities.OADictBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class OADictBeanDaoImpl extends GenericDao<OADictBean, String> implements IOADictBeanDao {
    @Override
    @PersistenceContext(unitName = "oa-system-dict-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
