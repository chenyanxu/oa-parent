/**
 * 面试添加和修改表单
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.usecase.interview.view.InterviewWindow', {
        extend: 'kalix.view.components.common.BaseWindow',
        requires: [
            'kalix.usecase.interview.viewModel.InterviewViewModel',
            'kalix.controller.BaseWindowController',
            'kalix.usecase.candidate.store.CandidateStore',
            'kalix.usecase.interview.store.InterviewStore'
        ],
        alias: 'widget.interviewWindow',
        xtype: "interviewWindow",
        viewModel: 'interviewViewModel',
        controller: {
            type: 'baseWindowController',
            storeId: 'interviewStore'
        },
        whichInterview: 'first',
        width: 400,
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
                xtype: 'baseForm',
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
                    {
                        fieldLabel: '应聘者姓名',
                        editable: false,
                        hidden: true
                    },
                    {
                        fieldLabel: '初试时间',
                        allowBlank: false,
                        xtype: 'datefield',
                        format: 'Y-m-d',
                        bind: {
                            value: '{rec.dateFirst}'
                        }
                    },
                    {
                        fieldLabel: '初试面试官',
                        allowBlank: false,
                        bind: {
                            value: '{rec.interviewerFirst}'
                        }
                    },
                    {
                        fieldLabel: '初试面试内容',
                        allowBlank: false,
                        xtype: 'textarea',
                        bind: {
                            value: '{rec.interviewContentFirst}'
                        }
                    },
                    {
                        fieldLabel: '初试是否通过',
                        allowBlank: false,
                        xtype: 'combobox',
                        editable: false,
                        valueField: 'passFirst',
                        displayField: 'name',
                        store: {
                            data: [
                                {'name': '是', 'passFirst': true},
                                {'name': '否', 'passFirst': false}
                            ]
                        },
                        bind: {
                            value: '{rec.passFirst}'
                        }
                    },
                    {
                        fieldLabel: '复试时间',
                        xtype: 'datefield',
                        format: 'Y-m-d',
                        allowBlank: false,
                        bind: {
                            value: '{rec.dateSecond}'
                        }
                    },
                    {
                        fieldLabel: '复试面试官',
                        allowBlank: false,
                        bind: {
                            value: '{rec.interviewerSecond}'
                        }
                    },
                    {
                        fieldLabel: '复试面试内容',
                        allowBlank: false,
                        xtype: 'textarea',
                        bind: {
                            value: '{rec.interviewContentSecond}'
                        }
                    },
                    {
                        fieldLabel: '复试是否通过',
                        allowBlank: false,
                        xtype: 'combobox',
                        editable: false,
                        valueField: 'passSecond',
                        displayField: 'name',
                        store: {
                            data: [
                                {'name': '是', 'passSecond': true},
                                {'name': '否', 'passSecond': false}
                            ]
                        },
                        bind: {
                            value: '{rec.passSecond}'
                        }
                    }
                ]
            }
        ]
    }
);