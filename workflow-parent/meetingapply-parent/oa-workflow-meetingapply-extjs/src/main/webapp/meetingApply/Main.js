/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.meetingApply.Main', {
    extend: 'kalix.container.BaseContainer',
    requires: [
        'kalix.workflow.meetingApply.view.MeetingApplyGrid',
        'kalix.workflow.meetingApply.view.MeetingApplySearchForm'
    ],
    storeId: 'meetingApplyStore',
    items: [
         {
            title: '会议使用申请查询',
            xtype: 'meetingApplySearchForm'
        },
        {
            xtype: 'meetingApplyGrid',
            title: '会议使用申请列表'
        }
    ]
});
