/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.sealApply.view.SealApplyViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.workflow.sealApply.view.SealApplyViewForm'
    ],
    alias: 'widget.sealApplyViewWindow',
    xtype: "sealApplyViewWindow",
    width: 840,
    items: [
        Ext.create('kalix.workflow.sealApply.view.SealApplyViewForm')
    ]
});