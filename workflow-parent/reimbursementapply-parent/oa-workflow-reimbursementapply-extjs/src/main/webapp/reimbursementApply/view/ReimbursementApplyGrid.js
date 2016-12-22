/**
 * @author chenyanxu
 */
Ext.define('kalix.workflow.reimbursementApply.view.ReimbursementApplyGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.workflow.reimbursementApply.controller.ReimbursementApplyGridController',
        'kalix.workflow.reimbursementApply.store.ReimbursementApplyStore',
        'kalix.oa.oADict.component.OADictGridColumn'
    ],
    alias: 'widget.reimbursementApplyGrid',
    xtype: 'reimbursementApplyGrid',
    iconCls: 'iconfont icon-public-reimbursement',
    controller: {
        type: 'reimbursementApplyGridController',
        cfgForm: 'kalix.workflow.reimbursementApply.view.ReimbursementApplyWindow',
        cfgViewForm: 'kalix.workflow.reimbursementApply.view.ReimbursementApplyViewWindow',
        cfgModel: 'kalix.workflow.reimbursementApply.model.ReimbursementApplyModel'
    },
    store: {
        type: 'reimbursementApplyStore'
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
            dataIndex: 'title'
        },
        {
            text: '出差人',
            dataIndex: 'createBy'
        },
        {
            text: '部门',
            dataIndex: 'orgName'
        },
        {
            text: '出差事由',
            dataIndex: 'reason'
        },
        {
            text: '项目名称',
            dataIndex: 'projectName'
        },
        {
            text: '领款人',
            dataIndex: 'payeeUser'
        },
        {
            text: '报销日期',
            dataIndex: 'reimbursementDate',
            xtype: 'datecolumn',
            format: 'Y年m月d日',
            renderer: null
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
                    permission: 'reimbursementApply',
                    tooltip: '报销申请',
                    handler: 'onReimbursement',
                    getClass: function (v, meta, record) {
                        if (record.data.status == null) {
                            return "iconfont icon-workflow-reimbursement-column";
                        }
                        if (0 != record.data.status) {
                            return "kalix_hidden";
                        }
                        return "iconfont icon-workflow-reimbursement-column";
                    }
                },
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
                        if (record.data.status || record.data.status == null) {
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
    ],
    tbar: {
        xtype: 'securityToolbar',
        verifyItems: [
            {
                text: '添加',
                xtype: 'button',
                permission: 'add',
                iconCls: 'iconfont icon-add',
                handler: 'onAdd'
            }
        ]
    }
});
