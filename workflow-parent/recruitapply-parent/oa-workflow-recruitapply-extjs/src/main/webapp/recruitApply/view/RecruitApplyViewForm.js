/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.recruitApply.view.RecruitApplyViewForm', {
    extend: 'kalix.view.components.common.TableFormPanel',
    requires: [
        'kalix.view.components.common.TableFormField',
        'kalix.view.components.common.TableFormDateTimeField',
        'kalix.oa.oADict.component.OADictCombobox'
    ],
    alias: 'widget.recruitApplyViewForm',
    xtype: "recruitApplyViewForm",
    items: [
        {
            html: '吉林动画学院用工招聘申请表',
            colspan: 6,
            customStyle: true,
            bodyStyle: 'padding:10px 0px 15px 0px;font-size:25px;font-weight:bold;'
        },
        {
            html: '申请部门'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.orgName}'
                    }
                }
            ]
        },
        {
            html: '申请事由'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'oADictCombobox',
                    dictType: '招聘需求原因',
                    readOnly: true,
                    bind: {
                        value: '{rec.reason}'
                    }
                }
            ]
        },
        {
            html: '拟聘人数'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.recruitCount}'
                    }
                }
            ]
        },
        {
            html: '定编人数'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.allocationCount}'
                    }
                }
            ]
        },
        {
            html: '现有人数'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.existCount}'
                    }
                }
            ]
        },
        {
            html: '直接上级'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.leaderName}'
                    }
                }
            ]
        },
        {
            html: '核心职责'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.coreRecruit}'
                    }
                }
            ]
        },
        {
            html: '常规职责'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.commonRecruit}'
                    }
                }
            ]
        },
        {
            html: '待遇标准'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.treatmentLevel}'
                    }
                }
            ]
        },
        {
            html: '任职基本条件'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.baseCondition}'
                    }
                }
            ]
        },
        {
            html: '建议招聘方式'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'oADictCombobox',
                    dictType: '招聘方式',
                    readOnly: true,
                    bind: {
                        value: '{rec.recruitType}'
                    }
                }
            ]
        },
        {
            html: '申请人'
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
                    readOnly: true,
                    bind: {
                        value: '{rec.depUser}'
                    }
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
                    readOnly: true,
                    bind: {
                        value: '{rec.manpower}'
                    }
                }
            ]
        }
    ]
});