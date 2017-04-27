/**
 * 应聘人员查看表单
 *
 * @author
 * @version 1.0.0
 */

Ext.define('kalix.workflow.loan.view.LoanViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    alias: 'widget.loanViewWindow',
    xtype: 'candidateViewWindow',
    width: 800,
    //todo 在此修改查看字段
    items: [
        {
            defaults: {readOnly: true},
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
                    bind: {
                        value: '{rec.trafficMoney}'
                    }
                },
                {
                    fieldLabel: '餐费',
                    bind: {
                        value: '{rec.foodMoney}'
                    }
                },
                {
                    fieldLabel: '住宿费',
                    xtype: 'numberfield',
                    bind: {
                        value: '{rec.hotelMoney}'
                    }
                },
                {
                    fieldLabel: '业务费用',
                    bind: {
                        value: '{rec.bussinessMoney}'
                    }
                }
            ]
        },
        {
            defaults: {readOnly: true},
            items: [
                {
                    fieldLabel: '其他费用',
                    bind: {
                        value: '{rec.otherMoney}'
                    }
                },
                {
                    fieldLabel: '备注',
                    xtype: 'textarea',
                    height: 100,
                    bind: {
                        value: '{rec.comment}'
                    }
                }
            ]
        }
    ]
});