/**
 * 借款管理查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.workflow.loan.view.LoanSearchForm', {
    extend: 'kalix.view.components.common.BaseSearchForm',
    alias: 'widget.loanSearchForm',
    xtype: 'loanSearchForm',
    storeId: 'loanStore',
    items: [
        {
            xtype: 'textfield',
            fieldLabel: '经办人',
            labelAlign: 'right',
            labelWidth: 60,
            width: 200,
            name: '%createBy%'
        }
    ]
});
