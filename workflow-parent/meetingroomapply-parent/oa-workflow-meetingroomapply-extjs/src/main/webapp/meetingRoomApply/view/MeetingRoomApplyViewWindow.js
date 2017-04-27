/**
 * @author zangyanming
 */

Ext.define('kalix.workflow.meetingRoomApply.view.MeetingRoomApplyViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.workflow.meetingRoomApply.view.MeetingRoomApplyViewForm'
    ],
    alias: 'widget.meetingRoomApplyViewWindow',
    xtype: 'meetingRoomApplyViewWindow',
    width: 840,
    items: [
        {
            xtype:'meetingRoomApplyViewForm'
        }
    ]
});