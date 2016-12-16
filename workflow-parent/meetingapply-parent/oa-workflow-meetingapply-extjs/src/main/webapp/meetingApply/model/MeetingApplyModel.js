/**model of contract
 *  @author zangyanming
 *
 */
Ext.define('kalix.workflow.meetingApply.model.MeetingApplyModel', {
    extend: 'kalix.model.WorkflowBaseModel',
    fields: [
        {name: 'meetingroomId',validators: [{type: 'presence'}]},//会议地点
        {name: 'meetingroomName'},//会议地点
        {name: 'meetingTopic', validators: [{type: 'presence'}]},//会议议题
        {name: 'meetingAgenda', validators: [{type: 'presence'}]},//会议议程
        {name: 'meetingType'},//会议类型
        {name: 'meetingSummaryPerson'},//会议纪要人员
        {name: 'meetingSummaryPersonName'},//会议纪要人员
        {name: 'beginTime', type: 'date', dateFormat: 'Y-m-d H:i:s', validators: [{type: 'presence'}]}, //会议开始时间
        {name: 'endTime', type: 'date', dateFormat: 'Y-m-d H:i:s', validators: [{type: 'presence'}]}, //会议结束时间
        {name: 'importantAttendees', type: 'string'},//重要出席人
        {name: 'importantAttendeesName', type: 'string'},//重要出席人
        {name: 'otherAttendees', type: 'string'},//其他出席人
        {name: 'otherAttendeesName', type: 'string'},//其他出席人
        {name: 'approveDeadline'}//审批截止时间
    ]
});
