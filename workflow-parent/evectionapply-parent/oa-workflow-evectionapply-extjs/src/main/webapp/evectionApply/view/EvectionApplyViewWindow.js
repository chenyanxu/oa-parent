/**
 * @author zangyanming
 */

Ext.define('kalix.workflow.evectionApply.view.EvectionApplyViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.workflow.evectionApply.view.EvectionApplyViewForm'
    ],
    alias: 'widget.evectionViewWindow',
    xtype: "evectionViewWindow",
    width: 840,
    //todo 在此修改查看字段
    items: [
        {
            xtype: 'evectionApplyViewForm'
        }
    ]
});