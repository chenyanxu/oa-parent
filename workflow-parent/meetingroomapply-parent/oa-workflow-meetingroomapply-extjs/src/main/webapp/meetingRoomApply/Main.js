/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.meetingRoomApply.Main', {
    extend: 'kalix.container.BaseContainer',
    requires: [
        'kalix.workflow.meetingRoomApply.view.MeetingRoomApplyGrid',
        'kalix.workflow.meetingRoomApply.view.MeetingRoomApplySearchForm'
    ],
    storeId: 'meetingRoomApplyStore',
    items: [
         {
            title: '会议室使用申请查询',
            xtype: 'meetingRoomApplySearchForm'
        },
        {
            xtype: 'meetingRoomApplyGrid',
            title: '会议室使用申请列表'
        }
    ]
});
