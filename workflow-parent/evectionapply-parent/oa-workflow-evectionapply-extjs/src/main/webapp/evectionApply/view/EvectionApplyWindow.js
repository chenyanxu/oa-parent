/**
 * @author zangyanming
 */

Ext.define('kalix.workflow.evectionApply.view.EvectionApplyWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.view.components.common.TableFormPanel',
        'kalix.view.components.common.TableFormField',
        'kalix.controller.BaseWindowController',
        'kalix.view.components.common.TableFormDateTimeField',
        'kalix.admin.user.component.UserOrgComboBox'
    ],
    alias: 'widget.evectionWindow',
    controller: {
        type: 'baseWindowController',
        storeId: 'evectionStore'
    },
    xtype: "evectionWindow",
    width: 900,
    //todo 在此修改表单
    items: [
        {
            xtype: 'baseTableForm',
            layout: {
                type: 'table',
                columns: 6
            },
            items: [
                {
                    html: '吉林动画学院出差申请表',
                    colspan: 6,
                    customStyle: true,
                    bodyStyle: 'padding:10px 0px 15px 0px;font-size:25px;font-weight:bold;'
                },
                {
                    html: '名称'
                },
                {
                    colspan: 5,
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.title}'
                            }
                        }
                    ]
                },
                {
                    html: '申请部门',
                    required: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'userOrgComboBox',
                            bind: {
                                value: '{rec.orgId}'
                            }
                        }
                    ]
                },
                {
                    html: '申请时间'
                },
                {
                    colspan: 2,
                    customStyle: true,
                    items: [
                        {
                            xtype: 'tableFormDateTimeField',
                            readOnly: true,
                            bind: {value: '{rec.applyDate}'}
                        }
                    ]
                },
                {
                    html: '出差原因',
                    height: 200,
                    required: true
                },
                {
                    colspan: 5,
                    height: 200,
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.reason}'
                            }
                        }
                    ]
                },
                {
                    html: '出差时段',
                    required: true
                },
                {
                    colspan: 3,
                    layout: {
                        type: 'hbox'
                    },
                    customStyle: true,
                    bodyStyle: 'padding:5px 0px 0px 0px;',
                    defaults: {
                        width: 210
                    },
                    items: [
                        {
                            xtype: 'tableFormDateTimeField',
                            bind: {
                                value: '{rec.beginDate}'
                            }
                        },
                        {
                            html: '至',
                            width: 15,
                            bodyStyle: 'font-size:15px;border:0px;padding:5px 0 0 0;'
                        },
                        {
                            xtype: 'tableFormDateTimeField',
                            bind: {
                                value: '{rec.endDate}'
                            }
                        }
                    ]
                },
                {
                    html: '申请人',
                    readOnly: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'tableFormField',
                            readOnly: true,
                            bind: {
                                value: '{rec.createBy}'
                            }
                        }
                    ]
                },
                {
                    html: '部门负责人',
                    readOnly: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'tableFormField',
                            readOnly: true
                        }
                    ]
                },
                {
                    html: '董事长',
                    readOnly: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'tableFormField',
                            readOnly: true
                        }
                    ]
                },
                {
                    html: '会计',
                    readOnly: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'tableFormField',
                            readOnly: true
                        }
                    ]
                },
                {
                    html: '出纳',
                    readOnly: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'tableFormField',
                            readOnly: true
                        }
                    ]
                }
            ]
        }
    ]
});