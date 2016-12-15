/**
 * @author zangyanming
 */

Ext.define('kalix.workflow.meetingApply.view.MeetingApplyViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.workflow.meetingApply.view.MeetingApplyViewForm'
    ],
    alias: 'widget.meetingApplyViewWindow',
    xtype: "meetingApplyViewWindow",
    width: 840,
    items: [
        {
            xtype:'meetingApplyViewForm'
        }
    ]
});