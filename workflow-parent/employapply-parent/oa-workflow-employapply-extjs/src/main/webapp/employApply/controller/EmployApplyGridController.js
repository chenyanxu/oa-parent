/**
 * @author chenyanxu
 */
Ext.define('kalix.workflow.employApply.controller.EmployApplyGridController', {
    extend: 'kalix.controller.BaseGridController',
    requires: ['kalix.workflow.components.ActivitiProcessImageWindow'],
    alias: 'controller.employApplyGridController',
    mixins: {
        attachment: 'kalix.attachment.common.mixins.Attachment',
        workflow:'kalix.workflow.common.mixins.Workflow'
    }
});