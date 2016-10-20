/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.recruitApply.view.RecruitApplyWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.controller.BaseWorkFlowWindowController',
        'kalix.view.components.common.TableFormDateTimeField',
        'kalix.view.components.common.TableFormPanel',
        'kalix.view.components.common.TableFormField',
        'kalix.admin.user.component.UserOrgComboBox',
        'kalix.oa.oADict.component.OADictCombobox'
    ],
    alias: 'widget.recruitApplyWindow',
    xtype: "recruitApplyWindow",
    controller: {
        type: 'baseWorkFlowWindowController',
        storeId: 'recruitApplyStore'
    },
    width: 900,
    items: [
        {
            xtype: 'baseTableForm',
            layout: {
                type: 'table',
                columns: 6
            },
            items: [
                {
                    html: '吉林动画学院用工招聘申请表',
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
                    html: '申请事由',
                    required: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'oADictCombobox',
                            dictType: '招聘需求原因',
                            bind: {
                                value: '{rec.reason}'
                            }
                        }
                    ]
                },
                {
                    html: '拟聘人数',
                    required: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.recruitCount}'
                            }
                        }
                    ]
                },
                {
                    html: '定编人数',
                    required: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.allocationCount}'
                            }
                        }
                    ]
                },
                {
                    html: '现有人数',
                    required: true
                },
                {
                    colspan: 5,
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.existCount}'
                            }
                        }
                    ]
                },
                //{
                //    html: '直接上级',
                //    required: true
                //},
                //{
                //    colspan: 2,
                //    items: [
                //        {
                //            xtype: 'tableFormField',
                //            bind: {
                //                value: '{rec.leaderName}'
                //            }
                //        }
                //    ]
                //},
                {
                    html: '核心职责',
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
                                value: '{rec.coreRecruit}'
                            }
                        }
                    ]
                },
                {
                    html: '常规职责',
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
                                value: '{rec.commonRecruit}'
                            }
                        }
                    ]
                },
                {
                    html: '任职基本条件',
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
                                value: '{rec.baseCondition}'
                            }
                        }
                    ]
                },
                {
                    html: '待遇标准',
                    required: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.treatmentLevel}'
                            }
                        }
                    ]
                },
                {
                    html: '建议招聘方式',
                    required: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'oADictCombobox',
                            dictType: '招聘方式',
                            bind: {
                                value: '{rec.recruitType}'
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
                    html: '人力资源处长',
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