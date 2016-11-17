/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.sealApply.view.SealApplyViewForm', {
    extend: 'kalix.view.components.common.TableFormPanel',
    requires: [
        'kalix.view.components.common.TableFormField',
        'Ext.ux.DateTimeField',
        'kalix.oa.oADict.component.OADictCombobox'
    ],
    alias: 'widget.sealApplyViewForm',
    xtype: "sealApplyViewForm",
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
            html: '吉林动画学院印章使用申请单',
            colspan: 6,
            customStyle: true,
            bodyStyle: 'padding:10px 0px 15px 0px;font-size:24px;font-weight:bold;'
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
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.creationDate}'
                    }
                }
            ]
        },
        {
            html: '用印数'
        },
        {
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.usageCount}'
                    }
                }
            ]
        },
        {
            html: '印章类别'
        },
        {
            colspan: 5,
            customStyle: true,
            bodyStyle: 'padding:0px 0px 0px 0px;font-size:15px;',
            items: [
                {

                    xtype: 'oADictCombobox',
                    readOnly: true,
                    dictType: '印章类型',
                    name: 'sealType',
                    fieldStyle: 'font-size:15px;background:transparent;',
                    bind: {
                        value: '{rec.sealType}'
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
        },
        {
            html: '经办人'
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
            html: '部门负责人'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.departmentHead}'
                    }
                }
            ]
        },
        {
            html: '分公司负责人'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.filialeHead}'
                    }
                }
            ]
        },
        {
            html: '法律顾问'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.counsel}'
                    }
                }
            ]
        },
        {
            html: '总经理'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.generalManager}'
                    }
                }
            ]
        },
        {
            html: '印章专管员'
        },
        {
            colspan: 2,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.sealAdministrator}'
                    }
                }
            ]
        },
        {
            html: '备注'
        },
        {
            colspan: 5,
            items: [
                {
                    xtype: 'tableFormField',
                    readOnly: true,
                    bind: {
                        value: '{rec.remark}'
                    }
                }
            ]
        }]

});