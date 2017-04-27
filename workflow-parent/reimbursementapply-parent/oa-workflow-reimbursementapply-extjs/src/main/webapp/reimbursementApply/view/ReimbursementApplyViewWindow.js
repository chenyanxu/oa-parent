/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.reimbursementApply.view.ReimbursementApplyViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.workflow.reimbursementApply.view.ReimbursementApplyViewForm'
    ],
    alias: 'widget.reimbursementApplyViewWindow',
    xtype: 'reimbursementApplyViewWindow',
    width: 900,
    items: [
        {
            xtype:'reimbursementApplyViewForm'
        }
    ]
});