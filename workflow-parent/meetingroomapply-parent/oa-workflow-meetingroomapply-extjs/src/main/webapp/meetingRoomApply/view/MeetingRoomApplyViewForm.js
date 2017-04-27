/**
 * @author zangyanming
 */

Ext.define('kalix.workflow.meetingRoomApply.view.MeetingRoomApplyViewForm', {
    extend: 'kalix.view.components.common.TableFormPanel',
    requires: [
        'kalix.view.components.common.TableFormField',
        'kalix.view.components.common.TableFormRadioGroup',
        'kalix.view.components.common.TableFormDateTimeField',
        'kalix.oa.oADict.component.OADictCombobox',
        'kalix.system.meetingroom.component.MeetingroomComboBox'
    ],
    alias: 'widget.meetingRoomApplyViewForm',
    xtype: 'meetingRoomApplyViewForm',
    layout: {
        type: 'table',
        columns: 6
    },
    constructor: function () {
        if (arguments.length == 1 && arguments[0].layout == 'form') {
            arguments[0].layout =
            {
                type: 'table',
                columns: 6
            }
        }
        this.callParent(arguments);
    },
    items: [
        {
            html: '吉林动画学院会议室使用申请表',
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
                    readOnly: true,
                    bind: {
                        value: '{rec.title}'
                    }
                }
            ]
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
            html: '会议地点'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'meetingroomComboBox',
                    readOnly: true,
                    bind: {
                        value: '{rec.meetingroomId}'
                    }
                }
            ]
        },
        {
            html: '会议主题'
        },
        {
            colspan: 5,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.meetingTopic}'
                    }
                }
            ]
        },
        {
            html: '宣传需求（企划中心）'
        },
        {
            colspan: 5,
            customStyle: true,
            bodyStyle: 'padding:0px 0px 0px 0px;font-size:15px;',
            items: [
                {
                    colspan: 5,
                    readOnly: true,
                    customStyle: true,
                    bodyStyle: 'padding:10px 0px 0px 20px;font-size:15px;',
                    items: [
                        {
                            xtype: 'oADictCombobox',
                            readOnly: true,
                            dictType: '会议需求类型',
                            name: 'requireType',
                            fieldStyle: 'font-size:15px;background:transparent;',
                            bind: {
                                value: '{rec.requireType}'
                            },
                            listeners: {
                                render: function (target) {
                                    if (target.bodyEl) {
                                        target.bodyEl.dom.firstChild.style.border = '0px';
                                    }
                                }
                            }
                        }
                    ]
                }
            ]
        },
        {
            html: '主持人'
        },
        {
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.host}'
                    }
                }
            ]
        },
        {
            html: '使用时间'
        },
        {
            colspan: 3,
            layout: {
                type: 'hbox'
            },
            customStyle: true,
            bodyStyle: 'padding:5px 0px 0px 0px;',
            defaults: {
                //width: 200,
                readOnly: true
            },
            items: [
                {
                    xtype: 'tableFormDateTimeField',
                    format:'Y年m月d日',
                    width:155,
                    bind: {
                        value: '{rec.meetingDate}'
                    }
                },
                {
                    xtype: 'tableFormField',
                    bind: {
                        value: '{rec.weekOfDay}'
                    }
                },
                {
                    xtype: 'tableFormDateTimeField',
                    format:'H时i分',
                    width:100,
                    bind: {
                        value: '{rec.beginTime}'
                    }
                },
                {
                    html: '至',
                    //width: 15,
                    bodyStyle: 'font-size:15px;border:0px;padding:5px 0 0 0;'
                },
                {
                    xtype: 'tableFormDateTimeField',
                    format:'H时i分',
                    width:100,
                    bind: {
                        value: '{rec.endTime}'
                    }
                }
            ]
        },
        {
            html: '参会人员'
        },
        {
            colspan: 5,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.participant}'
                    }
                }
            ]
        },
        {
            html: '出席人数'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.attendance}'
                    }
                }
            ]
        },
        {
            html: '设备要求'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.equipmentRequirement}'
                    }
                }
            ]
        },
        {
            html: '联系人（安全责任人）'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.securityPerson}'
                    }
                }
            ]
        },
        {
            html: '手机号码'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.securityTel}'
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
            html: '联系电话'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.operatorPhone}'
                    }
                }
            ]
        },
        {
            html: '校务部行政事务办主管'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.schoolAdminUser}'
                    }
                }
            ]
        },
        {
            html: '校务部副部长'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.schoolUser}'
                    }
                }
            ]
        }
    ]
});