/**
 * @author zangyanming
 */

Ext.define('kalix.workflow.evectionApply.view.EvectionApplyViewForm', {
    extend: 'kalix.view.components.common.TableFormPanel',
    requires: [
        'kalix.view.components.common.TableFormField',
        'kalix.view.components.common.TableFormDateTimeField'
    ],
    alias: 'widget.evectionApplyViewForm',
    xtype: 'evectionApplyViewForm',
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
            html: '吉林动画学院出差申请表',
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
        }, {
            html: '项目名称'
        },
        {
            colspan: 5,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.projectName}'
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
            html: '申请时间'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormDateTimeField',
                    readOnly: true,
                    bind: {
                        value: '{rec.creationDate}'
                    }
                }
            ]
        },
        {
            html: '出差原因',
            height: 200
        },
        {
            colspan: 5,
            height: 200,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.reason}'
                    }
                }
            ]
        },
        {
            html: '出差时段'
        },
        {
            colspan: 3,
            layout: {
                type: 'hbox'
            },
            customStyle: true,
            bodyStyle: 'padding:5px 0px 0px 0px;',
            defaults: {
                width: 200,
                readOnly: true
            },
            items: [
                {
                    xtype: 'tableFormDateTimeField',
                    bind: {
                        value: '{rec.beginDate}'
                    }
                },
                {
                    html: '至',
                    width: 15,
                    bodyStyle: 'font-size:15px;border:0px;padding:5px 0 0 0;',
                },
                {
                    xtype: 'tableFormDateTimeField',
                    bind: {
                        value: '{rec.endDate}'
                    }
                }
            ]
        },
        {
            html: '申请人',
            readOnly: true
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
            html: '董事长',
            readOnly: true
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.chairmanUser}'
                    }
                }
            ]
        },
        {
            html: '会计',
            readOnly: true
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.accountantUser}'
                    }
                }
            ]
        },
        {
            html: '出纳',
            readOnly: true
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.cashierUser}'
                    }
                }
            ]
        }
    ]
});