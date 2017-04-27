/**
 * 应聘添加和修改表单
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.workflow.loan.view.LoanWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.controller.BaseWindowController'
    ],
    alias: 'widget.loanWindow',
    controller: {
        type: 'baseWindowController'
    },
    xtype: 'loanWindow',
    width: 800,
    //todo 在此修改表单
    items: [
        {
            items: [
                {
                    fieldLabel: '出差申请工作流ID',
                    hidden: true,
                    bind: {
                        value: '{rec.evectionId}'
                    }
                },
                {
                    fieldLabel: '交通费用',
                    xtype: 'numberfield',
                    minValue: 0,
                    bind: {
                        value: '{rec.trafficMoney}'
                    }
                },
                {
                    fieldLabel: '餐费',
                    xtype: 'numberfield',
                    minValue: 0,
                    bind: {
                        value: '{rec.foodMoney}'
                    }
                },
                {
                    fieldLabel: '住宿费',
                    xtype: 'numberfield',
                    minValue: 0,
                    bind: {
                        value: '{rec.hotelMoney}'
                    }
                },
                {
                    fieldLabel: '业务费用',
                    xtype: 'numberfield',
                    minValue: 0,
                    bind: {
                        value: '{rec.bussinessMoney}'
                    }
                }
            ]
        },
        {
            items: [
                {
                    fieldLabel: '其他费用',
                    xtype: 'numberfield',
                    minValue: 0,
                    bind: {
                        value: '{rec.otherMoney}'
                    }
                },
                {
                    fieldLabel: '备注',
                    xtype: 'textarea',
                    height: 150,
                    bind: {
                        value: '{rec.comment}'
                    }
                }
            ]
        }
    ]
});