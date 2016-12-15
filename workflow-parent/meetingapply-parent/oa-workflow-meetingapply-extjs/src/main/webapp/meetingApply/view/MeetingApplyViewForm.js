/**
 * @author zangyanming
 */

Ext.define('kalix.workflow.meetingApply.view.MeetingApplyViewForm', {
    extend: 'kalix.view.components.common.TableFormPanel',
    requires: [
        'kalix.view.components.common.TableFormField',
        'kalix.view.components.common.TableFormRadioGroup',
        'kalix.view.components.common.TableFormDateTimeField',
        'kalix.oa.oADict.component.OADictCombobox',
        'kalix.system.meetingroom.component.MeetingroomComboBox',
        'kalix.admin.user.component.UserTagField'
    ],
    alias: 'widget.meetingApplyViewForm',
    xtype: "meetingApplyViewForm",
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
            html: '会议议题'
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
            html: '会议议程'
        },
        {
            colspan: 5,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.meetingAgenda}'
                    }
                }
            ]
        },
        {
            html: '会议类型'
        },
        {
            items: [
                {
                    xtype: 'meetingroomComboBox',
                    readOnly: true,
                    bind: {
                        value: '{rec.meetingType}'
                    }
                }
            ]
        },
        {
            html: '会议申请人'
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
            html: '会议纪要人员'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.meetingSummaryPerson}'
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
                    xtype: 'datefield',
                    format: 'Y-m-d',
                    formatText:'格式为YYYY-mm-dd',
                    name: 'beginTime'
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
                    xtype: 'datefield',
                    format: 'Y-m-d',
                    formatText:'格式为YYYY-mm-dd',
                    name: 'endTime'
                }
            ]
        },
        {
            html: '重要出席人'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'userTagField',
                    valueField: 'id',
                    displayField: 'name',
                    readOnly: true,
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
            colspan: 2,
            items: [
                {
                    xtype: 'userTagField',
                    valueField: 'id',
                    displayField: 'name',
                    readOnly: true,
                    bind: {
                        value: '{rec.otherAttendees}'
                    }
                }
            ]
        }
    ]
});