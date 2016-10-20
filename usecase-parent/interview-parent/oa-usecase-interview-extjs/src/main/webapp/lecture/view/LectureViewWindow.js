/**
 * 试讲人员查看表单
 *
 * @author
 * @version 1.0.0
 */

Ext.define('kalix.usecase.lecture.view.LectureViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    alias: 'widget.lectureViewWindow',
    xtype: "lectureViewWindow",
    width: 800,
    //todo 在此修改查看字段
    items: [
        {
            defaults: {readOnly: false},
            //xtype: 'baseForm',
            items: [
                {
                    //readOnly:true,
                    xtype: 'candidateComboBox',
                    fieldLabel: '试讲姓名',
                    name:'candidateId',
                    allowBlank: false,
                    bind: {
                        value: '{rec.candidateId}'
                    }
                },
                //{
                //    fieldLabel: '应聘人',
                //    allowBlank: false,
                //    bind: {
                //        value: '{rec.candidateId}'
                //    }
                //},
                {
                    fieldLabel: '试讲题目',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.subject}',
                        value: '{rec.subject}'
                    }
                },
                {
                    fieldLabel: '授课内容',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.content}',
                        value: '{rec.content}'
                    }
                },
                {
                    fieldLabel: '教学论点分数',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.argumentScore}',
                        value: '{rec.argumentScore}'
                    }
                },
                {
                    fieldLabel: '板书或课件分数',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.coursewareScore}',
                        value: '{rec.coursewareScore}'
                    }
                },
                {
                    fieldLabel: '语言表达分数',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.expressionScore}',
                        value: '{rec.expressionScore}'
                    }
                },
                {
                    fieldLabel: '教态分数',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.attitudeScore}',
                        value: '{rec.attitudeScore}'
                    }
                },
                {
                    fieldLabel: '教学效果分数',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.effectScore}',
                        value: '{rec.effectScore}'
                    }
                }
            ]
        },
        {
            defaults: {readOnly: true},
            items:[
                {
                    fieldLabel: '问题及回答',
                    xtype: 'textarea',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.qa}',
                        value: '{rec.qa}'
                    }
                },
                {
                    fieldLabel: '评语',
                    xtype: 'textarea',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.comment}',
                        value: '{rec.comment}'
                    }
                },
                {
                    fieldLabel: '聘用意见',
                    xtype: 'textarea',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.suggestion}',
                        value: '{rec.suggestion}'
                    }
                },
                {
                    fieldLabel: '听课人',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.participant}',
                        value: '{rec.participant}'
                    }
                },
                {
                    fieldLabel: '是否通过',
                    allowBlank: false,
                    xtype: 'combobox',
                    editable: false,
                    valueField: 'pass',
                    displayField: 'name',
                    store: {
                        data: [
                            {'name': '是', 'pass': true},
                            {'name': '否', 'pass': false}
                        ]
                    },
                    bind: {
                        activeError: '{validation.pass}',
                        value: '{rec.pass}'
                    }
                }
            ]
        }
    ]
});