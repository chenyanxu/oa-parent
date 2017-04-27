/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.employApply.view.EmployApplyViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.workflow.employApply.view.EmployApplyViewForm'
    ],
    alias: 'widget.employApplyViewWindow',
    xtype: 'employApplyViewWindow',
    width: 840,
    items: [
        {
            xtype:'employApplyViewForm'
        }
    ]
});