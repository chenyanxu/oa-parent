/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.carApply.view.CarApplyViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.workflow.carApply.view.CarApplyViewForm'
    ],
    alias: 'widget.carApplyViewWindow',
    xtype: 'carApplyViewWindow',
    width: 840,
    items: [
        {
            xtype:'carApplyViewForm'
        }
    ]
});