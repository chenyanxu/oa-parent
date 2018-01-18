package com.kalix.oa.workflow.redheadapply.biz.listener;

import com.kalix.framework.core.util.JNDIHelper;
import com.kalix.middleware.workflow.api.util.WorkflowUtil;
import com.kalix.oa.workflow.redheadapply.api.dao.IRedheadApplyBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.RedheadApplyBean;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.runtime.ProcessInstance;

import java.io.IOException;

/**
 * Created by Administrator on 2018-01-09.
 * 文号监听器，用于控制文号的是否修改
 */
public class DocExecutionListener implements ExecutionListener {
    private RuntimeService runtimeService;
    private IRedheadApplyBeanDao redheadApplyBeanDao;

    public DocExecutionListener() {
        try {
            runtimeService = JNDIHelper.getJNDIServiceForName(RuntimeService.class.getName());
            redheadApplyBeanDao = JNDIHelper.getJNDIServiceForName(IRedheadApplyBeanDao.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void notify(DelegateExecution execution) throws Exception {
        String eventName = execution.getEventName();
        //start
        if ("start".equals(eventName)) {
            System.out.println("start=========");
        } else if ("take".equals(eventName)) {
            System.out.println("doc take event is running =========");
        }

        //通过任务对象获取流程实例
        final String processInstanceId = execution.getProcessInstanceId();
        ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

        //通过流程实例获取“业务键”
        String businessKey = pi.getBusinessKey();
        //拆分业务键，拆分成“业务对象名称”和“业务对象ID”的数组
        String beanId = WorkflowUtil.getBizId(businessKey);
        RedheadApplyBean bean = redheadApplyBeanDao.get(new Long(beanId));
        bean.setEditDocType(false);
        redheadApplyBeanDao.save(bean);

    }
}