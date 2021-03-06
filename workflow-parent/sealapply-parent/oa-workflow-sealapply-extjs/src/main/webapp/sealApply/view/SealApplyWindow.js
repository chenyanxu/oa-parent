/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.sealApply.view.SealApplyWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.controller.BaseWorkFlowWindowController',
        'kalix.view.components.common.TableFormPanel',
        'kalix.view.components.common.TableFormRadioGroup',
        'kalix.view.components.common.TableFormField',
        'kalix.controller.BaseWindowController',
        'kalix.admin.user.component.UserOrgComboBox'
    ],
    alias: 'widget.sealApplyWindow',
    xtype: 'sealApplyWindow',
    controller: {
        type: 'baseWorkFlowWindowController',
        storeId: 'sealApplyStore'
    },
    width: 840,
    items: [
        {
            xtype: 'baseTableForm',
            layout: {
                type: 'table',
                columns: 6
            },
            items: [
                {
                    html: '吉林动画学院印章使用申请单',
                    colspan: 6,
                    customStyle: true,
                    bodyStyle: 'padding:10px 0px 15px 0px;font-size:24px;font-weight:bold;'
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
                    customStyle: true,
                    bodyStyle: 'padding:0px 0px 0px 0px;',
                    items: [
                        {
                            xtype: 'datefield',
                            readOnly: true,
                            value: new Date(),
                            fieldStyle: 'font-size:15px;text-align:center;background:transparent;',
                            format: 'Y年m月d日',
                            listeners: {
                                render: function (target) {
                                    if (target.bodyEl) {
                                        target.bodyEl.dom.firstChild.style.border = '0px';
                                    }
                                }
                            }
                        }
                    ]
                },
                {
                    html: '用印数',
                    required: true
                },
                {
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.usageCount}'
                            }
                        }
                    ]
                },
                {
                    html: '印章类别',
                    required: true
                },
                {
                    colspan: 5,
                    customStyle: true,
                    bodyStyle: 'padding:10px 0px 0px 20px;font-size:15px;',
                    items: [
                        {
                            xtype: 'tableFormRadioGroup',
                            columns: 5,
                            fieldName: 'sealType',
                            items: [
                                {boxLabel: '公司公章', inputValue: '0'},
                                {boxLabel: '公司合同专用章', inputValue: '1'},
                                {boxLabel: '学院公章', inputValue: '2'},
                                {boxLabel: '学院合同专用章', inputValue: '3'},
                                {boxLabel: '法人印章', inputValue: '4'}
                            ]
                        }
                    ]
                },
                {
                    html: '经办人',
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
                    html: '分公司负责人',
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
                    html: '法律顾问',
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
                    html: '总经理',
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
                    html: '印章专管员',
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
                    html: '备注'
                },
                {
                    colspan: 5,
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.remark}'
                            }
                        }
                    ]
                }]
        }
    ]
});