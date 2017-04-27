/**
 * 应聘人员查看表单
 *
 * @author
 * @version 1.0.0
 */

Ext.define('kalix.usecase.candidate.view.CandidateViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    alias: 'widget.candidateViewWindow',
    requires: [
        'kalix.oa.oADict.component.OADictCombobox'
    ],
    xtype: 'candidateViewWindow',
    width: 800,
    //todo 在此修改查看字段
    items: [
        {
            defaults: {readOnly: true},
            //xtype: 'baseForm',
            items: [
                {
                    fieldLabel: '人员类别',
                    allowBlank: false,
                    xtype: 'oADictCombobox',
                    dictType: '招聘人员类别',
                    bind: {
                        value: '{rec.personCategory}'
                    }
                },
                {
                    fieldLabel: '所在部门',
                    allowBlank: false,
                    bind: {
                        value: '{rec.orgName}'
                    }
                },
                {
                    fieldLabel: '姓名',
                    allowBlank: false,
                    bind: {
                        value: '{rec.xm}'
                    }
                },
                {
                    fieldLabel: '性别',
                    allowBlank: false,
                    xtype: 'oADictCombobox',
                    dictType: '性别',
                    bind: {
                        value: '{rec.sex}'
                    }
                },
                {
                    fieldLabel: '年龄',
                    allowBlank: false,
                    xtype: 'numberfield',
                    bind: {
                        value: '{rec.age}'
                    }
                },
                {
                    fieldLabel: '联系电话',
                    allowBlank: false,
                    bind: {
                        value: '{rec.tel}'
                    }
                },
                {
                    fieldLabel: '毕业学校',
                    allowBlank: false,
                    bind: {
                        value: '{rec.graduateSchool}'
                    }
                }
            ]
        },
        {
            defaults: {readOnly: true},
            items: [
                {
                    fieldLabel: '专业',
                    allowBlank: false,
                    bind: {
                        value: '{rec.major}'
                    }
                },
                {
                    fieldLabel: '最后学历',
                    allowBlank: false,
                    bind: {
                        value: '{rec.education}'
                    }
                },
                {
                    fieldLabel: '户口所在地',
                    allowBlank: false,
                    bind: {
                        value: '{rec.residence}'
                    }
                },
                {
                    fieldLabel: '应聘岗位',
                    allowBlank: false,
                    bind: {
                        value: '{rec.position}'
                    }
                },
                {
                    fieldLabel: '期望工资',
                    allowBlank: false,
                    bind: {
                        value: '{rec.salary}'
                    }
                },
                {
                    fieldLabel: '从业经验',
                    allowBlank: false,
                    bind: {
                        value: '{rec.experience}'
                    }
                },
                {
                    fieldLabel: '备注',
                    xtype: 'textarea',
                    bind: {
                        value: '{rec.comment}'
                    }
                }
            ]
        }
    ]
});