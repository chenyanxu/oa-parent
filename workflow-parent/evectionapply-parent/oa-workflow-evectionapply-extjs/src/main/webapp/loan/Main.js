/**
 * 借款管理首页
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.workflow.loan.Main', {
    extend: 'Ext.window.Window',
    requires: [
        'kalix.workflow.loan.view.LoanGrid'
    ],
    title: '借款管理列表',
    layout: 'fit',
    iconCls: 'iconfont icon-workflow-loan',
    items: [
        {
            xtype: 'loanGridPanel',
            id: 'loanGridPanel'
        }
    ]
});
