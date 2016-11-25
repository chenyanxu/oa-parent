package com.kalix.oa.workflow.evectionapply.biz;

import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.workflow.evectionapply.api.biz.IEvectionApplyBeanService;
import com.kalix.oa.workflow.evectionapply.api.dao.IEvectionApplyBeanDao;
import com.kalix.oa.workflow.evectionapply.entities.EvectionApplyBean;

import java.util.Map;

/**
 * @类描述： 
 * @创建人：  
 * @创建时间： 
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class EvectionApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IEvectionApplyBeanDao, EvectionApplyBean> implements IEvectionApplyBeanService {
    @Override
    public String getProcessKeyName() {
        return PROCESS_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map, EvectionApplyBean bean) {
        //map.put("city", bean.isCity());
        return map;
    }
}
