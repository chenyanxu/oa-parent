/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.meetingRoomApply.controller.MeetingRoomApplyGridController', {
    extend: 'kalix.controller.BaseGridController',
    requires: ['kalix.workflow.components.ActivitiProcessImageWindow'],
    alias: 'controller.meetingRoomApplyGridController',
    mixins: {
        attachment: 'kalix.attachment.common.mixins.Attachment',
        workflow:'kalix.workflow.common.mixins.Workflow'
    }
});