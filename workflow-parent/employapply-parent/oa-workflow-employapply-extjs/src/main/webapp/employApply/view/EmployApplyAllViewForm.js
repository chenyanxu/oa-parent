/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.employApply.view.EmployApplyAllViewForm', {
    extend: 'Ext.tab.Panel',
    requires: [
        'kalix.workflow.employApply.view.EmployApplyViewForm',
        'kalix.oa.oADict.component.OADictCombobox',
        'kalix.attachment.view.AttachmentGrid'
    ],
    alias: 'widget.employApplyAllViewForm',
    xtype: "employApplyAllViewForm",
    width: 893,
    height: 400,
    margin: '2 2 0 2',
    deferredRender: false,
    //items: [
        //{
        //    listeners: {
        //        beforetabchange: function (tabPanel, newCard, oldCard, eOpts) {
        //            var workflowId = this.items.items[0].items.items[0].items.items[0].lastValue;
        //            workflowId = tabPanel.items.items[0].items.items[0].items.items[0].lastValue;
        //            var jsonStr;
        //            var model;
        //
        //            if (newCard.title == '入职人员基本信息') {
        //                jsonStr = {
        //                    'employApplyWorkflowId': workflowId
        //                };
        //                jsonStr = Ext.JSON.encode(jsonStr);
        //                Ext.Ajax.request({
        //                    async: false,
        //                    url: CONFIG.restRoot + '/camel/rest/candidates',
        //                    method: 'GET',
        //                    paramsAsJson: true,
        //                    params: {
        //                        'jsonStr': jsonStr,
        //                        'page': 1,
        //                        'limit': 10
        //                    },
        //                    callback: function (options, success, response) {
        //                        model = Ext.JSON.decode(response.responseText);
        //                    }
        //                });
        //                if (model.data.length > 0) {
        //                    tabPanel.lookupViewModel().set('rec', model.data[0]);
        //                }
        //            }
        //            if (newCard.title == '面试信息') {
        //                var candidateId = 0;
        //                jsonStr = {
        //                    'employApplyWorkflowId': workflowId
        //                };
        //                jsonStr = Ext.JSON.encode(jsonStr);
        //                Ext.Ajax.request({
        //                    async: false,
        //                    url: CONFIG.restRoot + '/camel/rest/candidates',
        //                    method: 'GET',
        //                    paramsAsJson: true,
        //                    params: {
        //                        'jsonStr': jsonStr,
        //                        'page': 1,
        //                        'limit': 10
        //                    },
        //                    callback: function (options, success, response) {
        //                        model = Ext.JSON.decode(response.responseText);
        //                        if (model.data.length > 0) {
        //                            candidateId = model.data[0].id;
        //                        }
        //                    }
        //                });
        //
        //                jsonStr = {
        //                    'candidateId': candidateId
        //                };
        //
        //                jsonStr = Ext.JSON.encode(jsonStr);
        //                Ext.Ajax.request({
        //                    async: false,
        //                    url: CONFIG.restRoot + '/camel/rest/interviews',
        //                    method: 'GET',
        //                    paramsAsJson: true,
        //                    params: {
        //                        'jsonStr': jsonStr,
        //                        'page': 1,
        //                        'limit': 10
        //                    },
        //                    callback: function (options, success, response) {
        //                        model = Ext.JSON.decode(response.responseText);
        //                        if (model.data.length > 0) {
        //                            tabPanel.lookupViewModel().set('rec', model.data[0]);
        //                        }
        //                    }
        //                });
        //            }
        //
        //            if (newCard.title == '试讲信息') {
        //                var candidateId = 0;
        //                jsonStr = {
        //                    'employApplyWorkflowId': workflowId
        //                };
        //                jsonStr = Ext.JSON.encode(jsonStr);
        //                Ext.Ajax.request({
        //                    async: false,
        //                    url: CONFIG.restRoot + '/camel/rest/candidates',
        //                    method: 'GET',
        //                    paramsAsJson: true,
        //                    params: {
        //                        'jsonStr': jsonStr,
        //                        'page': 1,
        //                        'limit': 10
        //                    },
        //                    callback: function (options, success, response) {
        //                        model = Ext.JSON.decode(response.responseText);
        //                        if (model.data.length > 0) {
        //                            candidateId = model.data[0].id;
        //                        }
        //                    }
        //                });
        //
        //                jsonStr = {
        //                    'candidateId': candidateId
        //                };
        //
        //                jsonStr = Ext.JSON.encode(jsonStr);
        //                Ext.Ajax.request({
        //                    async: false,
        //                    url: CONFIG.restRoot + '/camel/rest/lectures',
        //                    method: 'GET',
        //                    paramsAsJson: true,
        //                    params: {
        //                        'jsonStr': jsonStr,
        //                        'page': 1,
        //                        'limit': 10
        //                    },
        //                    callback: function (options, success, response) {
        //                        if (model.data.length > 0) {
        //                            model = Ext.JSON.decode(response.responseText);
        //                            tabPanel.lookupViewModel().set('rec', model.data[0]);
        //                        }
        //                    }
        //                });
        //            }
        //
        //            if (newCard.title == '附件信息') {
        //                var store = this.items.getAt(4).store;
        //                var mainId = tabPanel.items.items[0].items.items[0].items.items[0].lastValue;
        //
        //                store.proxy.extraParams = {jsonStr: '{mainId:' + mainId + '}'};
        //                store.load();
        //            }
        //        }
        //    },
            //xtype: 'tabpanel',
            items: [
                {
                    "title": '审批信息',
                    xtype: 'panel',
                    layout: {
                        type: 'vbox',
                        align: 'center'
                    },
                    border: false,
                    width: '100%',
                    items: [
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: 'ID',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 110,
                                    width: 435,
                                    margin: 5,
                                    hidden: true,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec.id}'
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '标题',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec.title}'
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '申请人',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec.createBy}'
                                    }
                                },
                                {
                                    fieldLabel: '分院领导审批',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec.branchSchoolLeader}'
                                    }
                                }

                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '校领导审批',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec.schoolLeader}'
                                    }
                                },
                                {
                                    fieldLabel: '人力资源部长签字',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec.manpower}'
                                    }
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": '入职人员基本信息',
                    xtype: 'panel',
                    layout: {
                        type: 'vbox',
                        align: 'center'
                    },
                    border: false,
                    width: '100%',
                    items: [
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '人员类别',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    xtype: 'oADictCombobox',
                                    dictType: '招聘人员类别',
                                    bind: {
                                        value: '{rec1.personCategory}'
                                    }
                                },
                                {
                                    fieldLabel: '所在部门',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.orgName}'
                                    }
                                }

                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '姓名',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.xm}'
                                    }
                                },
                                {
                                    fieldLabel: '性别',
                                    xtype: 'oADictCombobox',
                                    dictType: '性别',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.sex}'
                                    }
                                }

                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '年龄',
                                    xtype: 'numberfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.age}'
                                    }
                                },
                                {
                                    fieldLabel: '联系电话',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.tel}'
                                    }
                                }

                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '毕业学校',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.graduateSchool}'
                                    }
                                },
                                {
                                    fieldLabel: '专业',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.major}'
                                    }
                                }

                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '最后学历',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.education}'
                                    }
                                },
                                {
                                    fieldLabel: '户口所在地',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.residence}'
                                    }
                                }

                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '应聘岗位',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.position}'
                                    }
                                },
                                {
                                    fieldLabel: '期望工资',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.salary}'
                                    }
                                }

                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '从业经验',
                                    xtype: 'textarea',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.experience}'
                                    }
                                },
                                {
                                    fieldLabel: '备注',
                                    xtype: 'textarea',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec1.comment}'
                                    }
                                }

                            ]
                        }
                    ]
                },
                {
                    "title": '面试信息',
                    xtype: 'panel',
                    layout: {
                        type: 'vbox',
                        align: 'center'
                    },
                    border: false,
                    width: '100%',
                    items: [
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '初试时间',
                                    xtype: 'datefield',
                                    format: 'Y-m-d', formatText:'格式为YYYY-mm-dd',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec2.dateFirst}'
                                    }
                                },
                                {
                                    fieldLabel: '复试时间',
                                    xtype: 'datefield',
                                    format: 'Y-m-d', formatText:'格式为YYYY-mm-dd',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec2.dateSecond}'
                                    }
                                }

                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '初试面试官',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec2.interviewerFirst}'
                                    }
                                },
                                {
                                    fieldLabel: '复试面试官',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec2.interviewerSecond}'
                                    }
                                }

                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '初试面试内容',
                                    xtype: 'textarea',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec2.interviewContentFirst}'
                                    }
                                },
                                {
                                    fieldLabel: '复试面试内容',
                                    xtype: 'textarea',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec2.interviewContentSecond}'
                                    }
                                }

                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '初试是否通过',
                                    xtype: 'combobox',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    valueField: 'passFirst',
                                    displayField: 'name',
                                    store: {
                                        data: [
                                            {'name': '是', 'passFirst': true},
                                            {'name': '否', 'passFirst': false}
                                        ]
                                    },
                                    bind: {
                                        value: '{rec2.passFirst}'
                                    }
                                },
                                {
                                    fieldLabel: '复试是否通过',
                                    xtype: 'combobox',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 435,
                                    margin: 5,
                                    readOnly: true,
                                    valueField: 'passSecond',
                                    displayField: 'name',
                                    store: {
                                        data: [
                                            {'name': '是', 'passSecond': true},
                                            {'name': '否', 'passSecond': false}
                                        ]
                                    },
                                    bind: {
                                        value: '{rec2.passSecond}'
                                    }
                                }
                            ]
                        }
                    ]
                },
                {
                    "title": '试讲信息',
                    xtype: 'panel',
                    layout: {
                        type: 'vbox',
                        align: 'center'
                    },
                    border: false,
                    width: '100%',
                    items: [
                        {
                            xtype: 'panel',
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '试讲题目',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 880,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec3.subject}'
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox',
                                align: 'center'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '授课内容',
                                    xtype: 'textarea',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 287,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec3.content}'
                                    }
                                },
                                {
                                    fieldLabel: '问题及回答',
                                    xtype: 'textarea',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 287,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec3.qa}'
                                    }
                                },
                                {
                                    fieldLabel: '评语',
                                    xtype: 'textarea',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 287,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec3.comment}'
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '教学论点分数',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 287,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec3.argumentScore}'
                                    }
                                },
                                {
                                    fieldLabel: '板书或课件分数',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 287,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec3.coursewareScore}'
                                    }
                                },
                                {
                                    fieldLabel: '语言表达分数',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 286,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec3.expressionScore}'
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '教态分数',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 287,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec3.attitudeScore}'
                                    }
                                },
                                {
                                    fieldLabel: '教学效果分数',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 287,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec3.effectScore}'
                                    }
                                },
                                {
                                    fieldLabel: '是否通过',
                                    xtype: 'combobox',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 286,
                                    margin: 5,
                                    readOnly: true,
                                    valueField: 'pass',
                                    displayField: 'name',
                                    store: {
                                        data: [
                                            {'name': '是', 'pass': true},
                                            {'name': '否', 'pass': false}
                                        ]
                                    },
                                    bind: {
                                        value: '{rec3.pass}'
                                    }
                                }
                            ]
                        },
                        {
                            xtype: 'panel',
                            layout: {
                                type: 'hbox'
                            },
                            width: '100%',
                            border: false,
                            items: [
                                {
                                    fieldLabel: '聘用意见',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 287,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec3.suggestion}'
                                    }
                                },
                                {
                                    fieldLabel: '听课人',
                                    xtype: 'textfield',
                                    labelAlign: 'right',
                                    labelWidth: 120,
                                    width: 286,
                                    margin: 5,
                                    readOnly: true,
                                    bind: {
                                        value: '{rec3.participant}'
                                    }
                                }
                            ]
                        }
                    ]
                },
                {
                    title: '附件信息',
                    xtype:'attachmentGrid',
                    tbar:null
                }
            //]
        //}
    ],
    listeners: {
        afterrender: function (target, eOpts) {
            var workflowId = target.lookupViewModel().data.rec.id;
            var jsonStr;
            var model;
            //基本信息
            jsonStr = {
                'employApplyWorkflowId': workflowId
            };
            jsonStr = Ext.JSON.encode(jsonStr);
            Ext.Ajax.request({
                async: false,
                url: CONFIG.restRoot + '/camel/rest/candidates',
                method: 'GET',
                paramsAsJson: true,
                params: {
                    'jsonStr': jsonStr,
                    'page': 1,
                    'limit': 10
                },
                callback: function (options, success, response) {
                    model = Ext.JSON.decode(response.responseText);
                }
            });
            if (model.data.length > 0) {
                target.lookupViewModel().set('rec1', model.data[0]);
            }

            //面试
            jsonStr = {
                'candidateId': target.lookupViewModel().data.rec1.id
            };

            jsonStr = Ext.JSON.encode(jsonStr);
            Ext.Ajax.request({
                async: false,
                url: CONFIG.restRoot + '/camel/rest/interviews',
                method: 'GET',
                paramsAsJson: true,
                params: {
                    'jsonStr': jsonStr,
                    'page': 1,
                    'limit': 10
                },
                callback: function (options, success, response) {
                    model = Ext.JSON.decode(response.responseText);
                    if (model.data.length > 0) {
                        target.lookupViewModel().set('rec2', model.data[0]);
                    }
                }
            });

            //试讲
            jsonStr = {
                'candidateId': target.lookupViewModel().data.rec1.id
            };

            jsonStr = Ext.JSON.encode(jsonStr);
            Ext.Ajax.request({
                async: false,
                url: CONFIG.restRoot + '/camel/rest/lectures',
                method: 'GET',
                paramsAsJson: true,
                params: {
                    'jsonStr': jsonStr,
                    'page': 1,
                    'limit': 10
                },
                callback: function (options, success, response) {
                    if (model.data.length > 0) {
                        model = Ext.JSON.decode(response.responseText);
                        target.lookupViewModel().set('rec3', model.data[0]);
                    }
                }
            });
            //附件
            var store = this.items.getAt(4).store;
            var mainId = target.lookupViewModel().data.rec1.id;

            store.proxy.extraParams = {jsonStr: '{mainId:' + mainId + '}'};
            store.load();
        }
    }
});