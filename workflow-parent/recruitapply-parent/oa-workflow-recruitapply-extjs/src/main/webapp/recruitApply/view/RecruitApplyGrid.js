/**
 * @author chenyanxu
 */
Ext.define('kalix.workflow.recruitApply.view.RecruitApplyGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.workflow.recruitApply.controller.RecruitApplyGridController',
        'kalix.workflow.recruitApply.store.RecruitApplyStore',
        'kalix.oa.oADict.component.OADictGridColumn'
    ],
    alias: 'widget.recruitApplyGrid',
    xtype: 'recruitApplyGrid',
    iconCls: 'iconfont icon-public-car',
    controller: {
        type: 'recruitApplyGridController',
        cfgForm: 'kalix.workflow.recruitApply.view.RecruitApplyWindow',
        cfgViewForm: 'kalix.workflow.recruitApply.view.RecruitApplyViewWindow',
        cfgModel: 'kalix.workflow.recruitApply.model.RecruitApplyModel'
    },
    store: {
        type: 'recruitApplyStore'
    },
    columns: [
        {
            xtype: "rownumberer"
        },
        {
            text: '编号',
            dataIndex: 'id'
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
            text: '用工原因',
            xtype: 'oADictGridColumn',
            dictType: '招聘需求原因',
            dataIndex: 'reason'
        },
        {
            text: '职位名称',
            dataIndex: 'positionName'
        },
        {
            text: '拟聘人数',
            dataIndex: 'recruitCount'
        },
        {
            text: '待遇标准',
            dataIndex: 'treatmentLevel'
        },
        {
            text: '核心职责',
            dataIndex: 'coreRecruit'
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
            items: [
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
