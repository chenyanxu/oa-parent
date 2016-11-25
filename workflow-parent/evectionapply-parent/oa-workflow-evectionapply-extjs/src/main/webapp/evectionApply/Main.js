/**
 * 出差管理首页
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.workflow.evectionApply.Main', {
    extend: 'kalix.container.BaseContainer',
    requires: [
        'kalix.workflow.evectionApply.view.EvectionApplyGrid',
        'kalix.workflow.evectionApply.view.EvectionApplySearchForm'
    ],
    items: [
        {
            title: '出差管理查询',
            xtype: 'evectionSearchForm'
        }, {
            xtype: 'evectionGridPanel',
            id: 'evectionGridPanel',
            title: '出差管理列表',
            margin: 10
        }
    ]
});
