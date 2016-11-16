/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.meetingApply.controller.MeetingApplyGridController', {
    extend: 'kalix.controller.BaseGridController',
    requires: ['kalix.workflow.components.ActivitiProcessImageWindow'],
    alias: 'controller.meetingApplyGridController',
    mixins: {
        attachment: 'kalix.attachment.common.mixins.Attachment',
        workflow:'kalix.workflow.common.mixins.Workflow'
    }
});