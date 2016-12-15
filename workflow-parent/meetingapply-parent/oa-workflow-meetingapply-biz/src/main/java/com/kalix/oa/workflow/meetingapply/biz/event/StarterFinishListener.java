package com.kalix.oa.workflow.meetingapply.biz.event;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * 启动人监听器，用于处理当前启动人
 * 该类直接在流程定义文件中实例化
 */
public class StarterFinishListener implements TaskListener {

    public StarterFinishListener() {

    }

    @Override
    public void notify(DelegateTask delegateTask) {
        //get starter user name
        /*List<Execution> executions = delegateTask.getExecution().getEngineServices().getRuntimeService().createExecutionQuery()
                .signalEventSubscriptionName("decide")
                .list();*/
        //发送信号
        delegateTask.getExecution().getEngineServices().getRuntimeService().signalEventReceived("decide");
//        delegateTask.setVariable("isAttend", true);
    }
}
