/**
 * @author chenyanxu
 */
Ext.define('kalix.workflow.sealApply.view.SealApplyGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.workflow.sealApply.controller.SealApplyGridController',
        'kalix.workflow.sealApply.store.SealApplyStore',
        'kalix.oa.oADict.component.OADictGridColumn'
    ],
    alias: 'widget.sealApplyGrid',
    xtype: 'sealApplyGrid',
    controller: {
        type: 'sealApplyGridController',
        cfgForm: 'kalix.workflow.sealApply.view.SealApplyWindow',
        cfgViewForm: 'kalix.workflow.sealApply.view.SealApplyViewWindow',
        cfgModel: 'kalix.workflow.sealApply.model.SealApplyModel'
    },
    store: {
        type: 'sealApplyStore'
    },
    columns: [
        {
            xtype: 'rownumberer'
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
            text: '申请部门',
            dataIndex: 'orgName'
        },

        {
            text: '申请时间',
            dataIndex: 'creationDate'
        },
        {
            text: '用印数',
            dataIndex: 'usageCount'
        },
        {
            text: '印章类别',
            xtype: 'oADictGridColumn',
            dictType: '印章类型',
            dataIndex: 'sealType'
            //renderer: null
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
            }
            //,
            //renderer: null
        },
        {
            flex: 1.5,
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
                            return 'kalix_hidden';
                        }
                        return 'iconfont icon-edit-column';
                    }
                },
                {
                    //icon: 'resources/images/workflow.png',
                    permission: 'progress',
                    tooltip: '查看当前流程',
                    handler: 'onViewCurrentProcess',
                    getClass: function (v, meta, record) {
                        if (1 != record.data.status) {
                            return 'kalix_hidden';
                        }
                        return 'iconfont icon-workflow-view-column';
                    }
                },
                {
                    permission: 'delete',
                    tooltip: '删除',
                    handler: 'onDelete',
                    getClass: function (v, meta, record) {
                        if (0 != record.data.status) {
                            return 'kalix_hidden';
                        } else {
                            return 'iconfont icon-delete';
                        }
                    }
                },
                {
                    getClass: function (v, meta, record) {
                        if (record.data.status) {
                            return 'kalix_hidden';
                        }
                        return 'iconfont icon-start';
                    },
                    getTip: function (value, metadata, record, row, col, store) {
                        if (record.data.status) {
                            return '停止';
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
    //},
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
