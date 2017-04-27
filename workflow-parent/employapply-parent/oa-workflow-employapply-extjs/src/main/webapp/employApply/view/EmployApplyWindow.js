/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.employApply.view.EmployApplyWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.controller.BaseWorkFlowWindowController',
        'Ext.ux.DateTimeField'
    ],
    alias: 'widget.employApplyWindow',
    xtype: 'employApplyWindow',
    width: 400,
    controller: {
        type: 'baseWorkFlowWindowController',
        storeId: 'employApplyStore'
    },
    items: [
        {
            items: [
                {
                    fieldLabel: '人力资源部长签字',
                    bind: {
                        value: '{rec.manpower}'
                    }
                }
            ]
        }
    ]
});