/**
 * @author chenyanxu
 */
Ext.define('kalix.workflow.employApply.view.EmployApplyGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.workflow.employApply.controller.EmployApplyGridController',
        'kalix.workflow.employApply.store.EmployApplyStore',
        'kalix.oa.oADict.component.OADictGridColumn'
    ],
    alias: 'widget.employApplyGrid',
    xtype: 'employApplyGrid',
    iconCls: 'iconfont icon-public-employ',
    controller: {
        type: 'employApplyGridController',
        cfgForm: 'kalix.workflow.employApply.view.TestEmployApplyWindow',
        cfgViewForm: 'kalix.workflow.employApply.view.EmployApplyViewWindow',
        cfgModel: 'kalix.workflow.employApply.model.EmployApplyModel'
    },
    store: {
        type: 'employApplyStore'
    },

    columns: [
        {
            xtype: "rownumberer"
        },
        {
            text: '编号',
            dataIndex: 'businessNo'
        },
        {
            text: '名称',
            dataIndex: 'title',
            hidden: true
        },
        {
            text: '人员类别',
            xtype: 'oADictGridColumn',
            dictType: '招聘人员类别',
            dataIndex: 'personCategory',
            renderer: null
        },
        {
            text: '申请部门',
            dataIndex: 'orgName'
        },
        {
            text: '姓名',
            dataIndex: 'xm'
        },
        {
            text: '性别',
            xtype: 'oADictGridColumn',
            dictType: '性别',
            dataIndex: 'sex',
            renderer: null
        },
        {
            text: '经办人',
            dataIndex: 'createBy'
        },
        {
            text: '审批结果',
            dataIndex: 'auditResult'
        },
        {
            text: '当前环节',
            dataIndex: 'currentNode'
        },
        {
            text: '工作流状态',
            xtype: 'oADictGridColumn',
            dictType: '工作流状态',
            dataIndex: 'status',
            colorConfig: {
                '结束': 'red',
                'default': 'blue'
            },
            renderer: null
        },
        {
            flex: 1.5,
            //width: 80,
            xtype: 'securityGridColumnCommon',
            verifyItems: [
                {
                    iconCls: 'iconfont icon-view-column',
                    permission: 'view',
                    tooltip: '查看',
                    handler: 'onView'
                },
                {
                    permission: 'edit',
                    tooltip: '编辑',
                    handler: 'onEdit',
                    getClass: function (v, meta, record) {
                        if (0 != record.data.status) {
                            return "kalix_hidden";
                        }
                        return "iconfont icon-edit-column";
                    }
                },
                {
                    permission: 'progress',
                    tooltip: '查看进度',
                    handler: 'onViewCurrentProcess',
                    getClass: function (v, meta, record) {
                        if (1 != record.data.status) {
                            return "kalix_hidden";
                        }
                        return "iconfont icon-current-process";
                    }
                },
                {
                    permission: 'delete',
                    tooltip: '删除',
                    handler: 'onDelete',
                    getClass: function (v, meta, record) {
                        if (0 != record.data.status) {
                            return "kalix_hidden";
                        }
                        return "iconfont icon-delete";
                    }
                },
                {
                    getClass: function (v, meta, record) {
                        if (record.data.status) {
                            return "kalix_hidden";
                        }
                        return "iconfont icon-start";
                    },
                    getTip: function (value, metadata, record, row, col, store) {
                        if (record.data.status) {
                            return "停止";
                        }
                        return '启动';
                    },
                    permission: 'control',
                    handler: 'onWorkFlowStart'
                },
                {
                    iconCls: 'iconfont icon-attachment-column',
                    permission: 'attachment',
                    tooltip: '附件管理',
                    handler: 'onAttachmentManage'
                }
            ]
        }
    ]
    //,
    //tbar: {
    //    xtype: 'securityToolbar',
    //    verifyItems: [
    //        {
    //            text: '添加',
    //            xtype: 'button',
    //            permission: '',
    //            iconCls: 'iconfont icon-add',
    //            handler: 'onAdd'
    //        }
    //    ]
    //}
});
