/**model of contract
 *  @author zangyanming
 *
 */
Ext.define('kalix.workflow.meetingApply.model.MeetingApplyModel', {
    extend: 'kalix.model.WorkflowBaseModel',
    fields: [
        {name: 'meetingroomId',validators: [{type: 'presence'}]},//会议地点
        {name: 'meetingroomName'},//会议地点
        {name: 'meetingTopic',validators: [{type: 'presence'}]},//会议名称
        {name: 'requireType'},//宣传需求（企划中心）
        {name: 'host',validators: [{type: 'presence'}]},//主持人
        {name: 'meetingDate'},//会议申请时间
        {name: 'beginTime',validators: [{type: 'presence'}]}, //会议时段,开始时间
        {name: 'endTime',validators: [{type: 'presence'}]}, //会议时段，结束时间
        {name: 'weekOfDate'}, //星期几
        {name: 'participant'},//参会人员
        {name: 'attendance'},//出席人数
        {name: 'equipmentRequirement'}, //设备要求
        {name: 'securityPerson'}, //联系人（安全责任人）
        {name: 'securityTel'}, //联系人电话
        {name: 'operatorPhone'} //申请人电话
    ]
});
