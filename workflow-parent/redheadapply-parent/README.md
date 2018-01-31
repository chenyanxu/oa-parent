# redheadapply-parent

## 红头文件申请工作流
  * api：后台的service和dao的接口
  * biz：后台service接口的实现
  * dao：后台dao接口的实现
  * entities：javaBean实体类
  * extjs：前台增删改查界面的展示
  * rest：前台到后台的rest服务配置以及工作流定义文件
  * web：前台菜单的实现

## 流程说明
    * 使用状态机服务控制业务状态
    * 定制业务编号
    * 允许重新修改业务数据
## 注意事项

* 本流程使用了流程变量，根据条件，跳过usertask
* 使用了多实例UserTask，用于会签的实现
```batch
<multiInstanceLoopCharacteristics isSequential="false" activiti:collection="assigneeList"
                                              activiti:elementVariable="assignee">
                <completionCondition>${nrOfCompletedInstances==nrOfInstances||accepted=='不同意' }</completionCondition>
            </multiInstanceLoopCharacteristics>
```

> 会签条件，所有实例全部通过流程才向下流转
> 当有一个审批人不同意时候，其他流程实例结束，流程流转
