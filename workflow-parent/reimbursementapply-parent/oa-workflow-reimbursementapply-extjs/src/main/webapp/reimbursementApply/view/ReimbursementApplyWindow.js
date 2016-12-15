/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.reimbursementApply.view.ReimbursementApplyWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.controller.BaseWorkFlowWindowController',
        'kalix.workflow.reimbursementApply.controller.DetailGridController',
        'kalix.view.components.common.TableFormPanel',
        'kalix.view.components.common.TableFormField',
        'kalix.controller.BaseWindowController',
        'kalix.view.components.common.TableFormDateTimeField',
        'kalix.admin.user.component.UserOrgComboBox',
        'kalix.workflow.reimbursementApply.store.DetailStore'
    ],
    alias: 'widget.reimbursementApplyWindow',
    xtype: "reimbursementApplyWindow",
    controller: {
        type: 'baseWorkFlowWindowController',
        storeId: 'reimbursementApplyStore'
    },
    width: 900,
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    defaults: {
        border: 0,
        bodyStyle: 'text-align:center;'
    },
    items: [
        {
            height: 40,
            html: '<div style="' +
            'padding-top: 10px;' +
            'font-size: 25px;' +
            'text-decoration: underline;' +
            '">差旅费用报销单</div>'
        },
        {
            margin: '5 0 0 0',
            layout: {
                type: 'table',
                columns: 6,
                tableAttrs: {
                    style: {
                        width: '100%'
                    },
                    border: 1
                },
                tdAttrs:{
                    align:'center'
                }
            },
            defaults: {
                border: 0,
                margin: 0
            },
            items: [
                {
                    html: '部门'
                },
                {
                    xtype: 'userOrgComboBox',
                    bind: {
                        value: '{rec.orgId}'
                    }
                },
                {
                    html: '报销日期'
                },
                {
                    xtype: 'textfield',
                    value: '2016年12月30日'
                },
                {
                    html: '编号'
                },
                {
                    html:'00112233'
                },
                {
                    html: '出差人'
                },
                {
                    xtype: 'textfield',
                    value:'张某'
                },
                {
                    html: '出差事由'
                },
                {
                    html:'现场开发'
                },
                {
                    html: '项目名称'
                },
                {
                    html:'校园信息化系统'
                },
                {
                    colspan: 6,
                    xtype: 'grid',
                    id:'custom_expense_grid',
                    height: 285,
                    columnLines: true,
                    autoLoad:false,
                    controller:'detailGridController',
                    listeners:{
                        edit:function(editor, e){
                            console.log(1324);
                        },
                        beforeedit:function( editor, context, eOpts ){
                            console.log('beforeedit');

                            for(var rIndex=0;rIndex<editor.grid.store.data.length;++rIndex){
                                if(editor.grid.store.data.getAt(rIndex)!=context.record){
                                    if(editor.grid.store.data.getAt(rIndex).dirty || editor.grid.store.data.getAt(rIndex).get('id')==0){
                                        alert('有记录未提交');
                                        return false;
                                    }
                                }
                            }
                        }
                    },
                    plugins: [
                        Ext.create('Ext.grid.plugin.RowEditing', {
                            clicksToEdit: 2,
                            autoCancel: false
                        })
                    ],

                    features: [
                        {
                            ftype: 'summary',
                            dock: 'bottom'
                        }
                    ],
                    textAlign: 'center',
                    store: 'detailStore',
                    columns: [
                        {
                            header: '出发',
                            menuDisabled: true,
                            columns: [
                                {
                                    text: '月',
                                    menuDisabled: true,
                                    width: 40,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'startMonth',
                                    summaryRenderer: function (value, summaryData, dataIndex) {
                                        return '<div style="text-decoration: underline;color:blue;cursor:pointer;" onclick="Ext.getCmp(\'custom_expense_grid\').controller.addExpense()">添加</div>';
                                    }
                                },
                                {
                                    text: '日',
                                    menuDisabled: true,
                                    width: 40,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'startDay',
                                    summaryRenderer: function (value, summaryData, dataIndex) {
                                        var fun=function (args) {
                                            console.log('xx1111');
                                        };

                                        return '<div style="text-decoration: underline;color:blue;cursor:pointer" onclick="Ext.getCmp(\'custom_expense_grid\').controller.deleteExpense()">删除</div>';
                                    }
                                },
                                {
                                    text: '时',
                                    menuDisabled: true,
                                    width: 40,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'startTime'
                                },
                                {
                                    text: '地点',
                                    menuDisabled: true,
                                    width: 70,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'startPlace',
                                    summaryRenderer: function (value, summaryData, dataIndex) {
                                        return '合计：';
                                    }
                                }
                            ]
                        },
                        {
                            header: '到达',
                            menuDisabled: true,
                            sortable: false,
                            columns: [
                                {
                                    text: '月',
                                    menuDisabled: true,
                                    width: 40,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'arriveMonth'
                                },
                                {
                                    text: '日',
                                    menuDisabled: true,
                                    width: 40,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'arriveDay'
                                },
                                {
                                    text: '时',
                                    menuDisabled: true,
                                    width: 40,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'arriveTime'
                                },
                                {
                                    text: '地点',
                                    menuDisabled: true,
                                    width: 70,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'arrivePlace'
                                }
                            ]
                        },
                        {
                            text: '人<br>数',
                            menuDisabled: true,
                            width: 40,
                            sortable: false,
                            editor: {
                                allowBlank: false
                            },
                            dataIndex: 'personNumber'
                        },
                        {
                            header: '交通',
                            menuDisabled: true,
                            sortable: false,
                            columns: [
                                {
                                    text: '工具',
                                    menuDisabled: true,
                                    width: 70,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'trafficTool'
                                },
                                {
                                    text: '金额',
                                    menuDisabled: true,
                                    width: 60,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false,
                                        xtype: 'numberfield'
                                    },
                                    dataIndex: 'trafficMoney',
                                    summaryType: 'sum'
                                }
                            ]
                        },
                        {
                            text: '天<br>数',
                            menuDisabled: true,
                            width: 40,
                            sortable: false,
                            editor: {
                                allowBlank: false
                            },
                            dataIndex: 'dayNumber',
                            summaryType: 'sum'
                        },
                        {
                            header: '出差补助',
                            menuDisabled: true,
                            columns: [
                                {
                                    text: '补助<br>标准',
                                    menuDisabled: true,
                                    width: 60,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'subsidyStandard'
                                },
                                {
                                    text: '金额',
                                    menuDisabled: true,
                                    width: 60,
                                    sortable: false,
                                    dataIndex: 'subsidyMoney',
                                    summaryType: 'sum'
                                }
                            ]
                        },
                        {
                            header: '其他费用金额',
                            menuDisabled: true,
                            columns: [
                                {
                                    text: '住宿',
                                    menuDisabled: true,
                                    width: 60,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'hotelMoney',
                                    summaryType: 'sum'
                                },
                                {
                                    text: '市内<br>交通',
                                    menuDisabled: true,
                                    width: 60,
                                    sortable: false,
                                    editor: {
                                        allowBlank: false
                                    },
                                    dataIndex: 'cityTrafficMoney',
                                    summaryType: 'sum'
                                }
                            ]
                        },
                        {
                            text: '合计',
                            menuDisabled: true,
                            width: 64,
                            sortable: false,
                            dataIndex: 'totalMoney',
                            summaryType: 'sum'
                        }
                    ]
                },
                {
                    rowspan: 2,
                    html: '报销<br>总额'
                },
                {
                    rowspan: 2,
                    colspan: 3
                },
                {
                    html: '预留金额￥'
                },
                {
                    xtype: 'textfield',
                    bind:{
                        value:'rec.borrowMoney'
                    }
                },
                {
                    html: '退/补金额￥'
                },
                {
                    xtype: 'textfield',
                    bind:{
                        value:'rec.backMoney'
                    }
                }
            ]
        },
        {
            margin: '5 0 0 0',
            layout: {
                type: 'table',
                columns: 6,
                tableAttrs: {
                    style: {
                        width: '100%'
                    },
                    border: 1
                },
                tdAttrs:{
                    align:'center'
                }
            },
            defaults: {
                border: 0,
                margin: 0
            },
            items: [
                {
                    html: '附单据张数合计（对应上方的项目）',
                    width:320
                }, {
                    html: '城际交通：',
                    width:120
                },
                {
                    xtype: 'numberfield',
                    width:75
                },
                {
                    html: '其他：',
                    width:75
                },
                {
                    xtype: 'numberfield',
                    width:75
                }, {
                    xtype: 'numberfield',
                    width:75
                }
            ]
        }
    ]
});