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
        'kalix.view.components.common.TableFormDateTimeField'
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
            html: '吉林动画学院会议申请表',
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
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.meetingroomName}'
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
            html: '开始时间'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormDateTimeField',
                    readOnly: true,
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
                    readOnly: true,
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
                    xtype: 'oADictCombobox',
                    dictType: '会议类型',
                    readOnly: true,
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
                    readOnly: true,
                    bind: {
                        value: '{rec.meetingSummaryPersonName}'
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
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.importantAttendeesName}'
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
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.otherAttendeesName}'
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
                    readOnly: true,
                    bind: {
                        value: '{rec.createBy}'
                    }
                }
            ]
        }
    ]
});