/**
 * 试讲添加和修改表单
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.usecase.lecture.view.LectureWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.controller.BaseWindowController',
        'kalix.usecase.candidate.store.CandidateStore'
    ],
    alias: 'widget.lectureWindow',
    controller: {
        type: 'baseWindowController'
    },
    xtype: "lectureWindow",
    whichInterview: 'lecture',
    width: 800,
    constructor: function () {
        this.callParent(arguments);
        this.items.items[0].items.items[0].store.proxy.extraParams = {
            'header.type': this.whichInterview,
            'jsonStr': '',
            'limit': 50
        };
        this.items.items[0].items.items[0].store.proxy.url = CONFIG.restRoot + '/camel/rest/candidatescheck/' + this.whichInterview;
    },
    items: [
        {
            //xtype: 'baseForm',
            items: [
                {
                    xtype: 'combobox',
                    fieldLabel: '应聘者姓名',
                    store: {
                        type: 'candidateStore',
                        //proxyUrl:'',
                        proxy: {
                            extraParams: {'jsonStr': '', 'limit': 50}
                        }
                    },
                    autoLoad: false,
                    editable: false,
                    displayField: 'xm',
                    valueField: 'candidateId',
                    queryMode: 'remote',
                    bind: {
                        value: '{rec.candidateId}'
                    },
                    listeners: {
                        select: function (combo, record, eOpts) {
                            //Ext.MessageBox.alert(CONFIG.ALTER_TITLE_ERROR, "流程已经启动!");
                        }
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
                    xtype: 'numberfield',
                    maxValue: 100,
                    minValue: 0,
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.argumentScore}',
                        value: '{rec.argumentScore}'
                    }
                },
                {
                    fieldLabel: '板书或课件分数',
                    xtype: 'numberfield',
                    maxValue: 100,
                    minValue: 0,
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.coursewareScore}',
                        value: '{rec.coursewareScore}'
                    }
                },
                {
                    fieldLabel: '语言表达分数',
                    xtype: 'numberfield',
                    maxValue: 100,
                    minValue: 0,
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.expressionScore}',
                        value: '{rec.expressionScore}'
                    }
                },
                {
                    fieldLabel: '教态分数',
                    xtype: 'numberfield',
                    maxValue: 100,
                    minValue: 0,
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.attitudeScore}',
                        value: '{rec.attitudeScore}'
                    }
                },
                {
                    fieldLabel: '教学效果分数',
                    maxValue: 100,
                    minValue: 0,
                    xtype: 'numberfield',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.effectScore}',
                        value: '{rec.effectScore}'
                    }
                }
            ]
        },
        {
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