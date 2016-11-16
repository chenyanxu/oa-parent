# workflow-parent
  工作流工程的父工程
## carapply-parent 车辆使用申请工作流
  [carapply-parent](oa-parent/workflow-parent/carapply-parent/README.md)
  * 流程审批职位列表
    * 上级领导
    * 校务部&副部长
    * 吉林动画学院&副校长-后勤
    * 吉林动画学院&党委书记

## employapply-parent 入职审批工作流
  [employapply-parent](oa-parent/workflow-parent/employapply-parent/README.md)
  * 流程审批职位列表
    * 上级领导
    * 吉林动画学院&董事长
    * 人力资源开发与管理中心&副主任

## meetingapply-parent 会议室使用申请工作流
  [meetingapply-parent](oa-parent/workflow-parent/meetingapply-parent/README.md)
  * 流程审批职位列表
    * 行政事务办公室&主管
    * 校务部&副部长

## recruitapply-parent 招聘申请工作流
  [recruitapply-parent](oa-parent/workflow-parent/recruitapply-parent/README.md)
  * 流程审批职位列表
    * 上级领导
    * 人力资源开发与管理中心&主任

## sealapply-parent 印章使用申请工作流
  [sealapply-parent](oa-parent/workflow-parent/sealapply-parent/README.md)
  * 流程审批职位列表
    * 上级领导
    * 分公司负责人
    * 法律顾问
    * 总经理
    * 印章专管员

## 注意事项
  * 上级领导说明
  当前申请人同级别的职位下的名称为“上级领导”的职位。
  例如：用车申请流程中用户A所处机构为“行政事务办公室”，该用户提请用车流程，系统自动在“行政事务办公室”机构下
  查找职位名称为“上级领导”的全部用户作为下一步的审批人员。
  * 工作流的配置文件xml中的含义
  “name”是工作流图中的显示名称
  “activiti:candidateGroups”是角色组的名称或者是角色的名称

        <userTask id="branchSchoolLeader" name="分院领导审批" activiti:candidateGroups="分院领导" activiti:formKey="audit.form">
            <documentation>分院领导审批</documentation>
            <extensionElements>
                <activiti:formProperty id="accepted" name="判断环节" type="boolean" variable="accepted">
                </activiti:formProperty>
            </extensionElements>
        </userTask>

