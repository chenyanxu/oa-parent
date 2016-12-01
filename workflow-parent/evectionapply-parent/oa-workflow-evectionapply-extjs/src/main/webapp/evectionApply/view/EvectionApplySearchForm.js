/**
 * 出差管理查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.workflow.evectionApply.view.EvectionApplySearchForm', {
    extend: 'kalix.view.components.common.BaseSearchForm',
    alias: 'widget.evectionSearchForm',
    xtype: 'evectionSearchForm',
    storeId: 'evectionStore',
    items: [
        {
            xtype: 'textfield',
            fieldLabel: '申请部门',
            labelAlign: 'right',
            labelWidth: 60,
            width: 200,
            name: '%orgName%'
        }, {
            xtype: 'textfield',
            fieldLabel: '经办人',
            labelAlign: 'right',
            labelWidth: 60,
            width: 200,
            name: '%createBy%'
        },
        {
            xtype: 'datefield',
            format: 'Y-m-d',
            formatText:'格式为YYYY-mm-dd',
            fieldLabel: '出差开始时间:',
            labelAlign: 'right',
            labelWidth: 120,
            width: 260,
            name: 'beginDate:begin:gt'
        },
        {
            xtype: 'displayfield',
            hideLabel: true,
            value: '-',
            margin: '0 5 0 5'
        },
        {
            xtype: 'datefield',
            format: 'Y-m-d',
            formatText:'格式为YYYY-mm-dd',
            headLabel: true,
            labelAlign: 'right',
            width: 140,
            name: 'beginDate:end:lt'
        }
    ]
});
