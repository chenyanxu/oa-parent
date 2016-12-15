/**
 * @author chenyanxu
 */
Ext.define('kalix.workflow.reimbursementApply.controller.ReimbursementApplyGridController', {
    extend: 'kalix.controller.BaseGridController',
    requires: ['kalix.workflow.components.ActivitiProcessImageWindow'],
    alias: 'controller.reimbursementApplyGridController',
    mixins: {
        attachment: 'kalix.attachment.common.mixins.Attachment',
        workflow:'kalix.workflow.common.mixins.Workflow'
    },
    onReimbursement: function(grid, rowIndex, colIndex){

    }
});