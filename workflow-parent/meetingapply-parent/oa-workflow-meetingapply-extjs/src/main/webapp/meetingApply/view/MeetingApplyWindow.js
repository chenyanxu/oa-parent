/**
 * @author zangyanming
 */

Ext.define('kalix.workflow.meetingApply.view.MeetingApplyWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.workflow.meetingApply.controller.MeetingApplyWindowController',
        'kalix.workflow.meetingApply.view.MeetingApplyViewForm',
        'kalix.view.components.common.TableFormPanel',
        'kalix.view.components.common.TableFormField',
        'kalix.view.components.common.TableFormRadioGroup',
        'kalix.controller.BaseWindowController',
        'kalix.view.components.common.TableFormDateTimeField',
        'kalix.system.meetingroom.component.MeetingroomComboBox',
        'kalix.admin.user.component.UserOrgComboBox',
        'kalix.admin.user.component.UserTagField',
        'kalix.view.components.common.TableFormDateTimeField'
    ],
    alias: 'widget.meetingApplyWindow',
    xtype: "meetingApplyWindow",
    controller: {
        type: 'meetingApplyWindowController',
        storeId: 'meetingApplyStore'
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
                    html: '吉林动画学院会议使用申请表',
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
                    html: '会议地点',
                    required: true
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'meetingroomComboBox',
                            bind: {
                                value: '{rec.meetingroomId}'
                            }
                        }
                    ]
                },
                {
                    html: '会议议题',
                    required: true
                },
                {
                    colspan: 5,
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.meetingTopic}'
                            }
                        }
                    ]
                },
                {
                    html: '会议议程',
                    required: true
                },
                {
                    colspan: 5,
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.meetingAgenda}'
                            }
                        }
                    ]
                },
                {
                    html: '开始时间'
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'tableFormDateTimeField',
                            bind: {
                                value: '{rec.beginTime}'
                            }
                        }
                    ]
                },
                {
                    html: '结束时间'
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'tableFormDateTimeField',
                            bind: {
                                value: '{rec.endTime}'
                            }
                        }
                    ]
                },
                {
                    html: '会议类型'
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'meetingroomComboBox',
                            bind: {
                                value: '{rec.meetingType}'
                            }
                        }
                    ]
                },
                {
                    html: '会议纪要人员'
                },
                {
                    colspan: 2,
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.meetingSummaryPerson}'
                            }
                        }
                    ]
                },
                {
                    html: '重要出席人'
                },
                {
                    colspan: 5,
                    items: [
                        {
                            xtype: 'userTagField',
                            valueField: 'id',
                            displayField: 'name',
                            bind: {
                                value: '{rec.importantAttendees}'
                            }
                        }
                    ]
                },
                {
                    html: '其他出席人'
                },
                {
                    colspan: 5,
                    items: [
                        {
                            xtype: 'userTagField',
                            valueField: 'id',
                            displayField: 'name',
                            bind: {
                                value: '{rec.otherAttendees}'
                            }
                        }
                    ]
                },
                {
                    html: '会议申请人'
                },
                {
                    colspan: 5,
                    items: [
                        {
                            xtype: 'tableFormField',
                            bind: {
                                value: '{rec.createBy}'
                            }
                        }
                    ]
                }
            ]
        }
    ]
});