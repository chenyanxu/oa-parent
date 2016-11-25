/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.evectionApply.controller.EvectionApplyGridController', {
    extend: 'kalix.controller.BaseGridController',
    requires: ['kalix.workflow.components.ActivitiProcessImageWindow'],
    alias: 'controller.evectionApplyGridController',
    mixins: {
        attachment: 'kalix.attachment.common.mixins.Attachment',
        workflow: 'kalix.workflow.common.mixins.Workflow'
    }
});
