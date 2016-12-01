/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.evectionApply.view.EvectionApplyGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.workflow.evectionApply.controller.EvectionApplyGridController',
        'kalix.workflow.evectionApply.store.EvectionApplyStore',
        'kalix.oa.oADict.component.OADictGridColumn'
    ],
    alias: 'widget.evectionGrid',
    xtype: 'evectionGridPanel',
    iconCls: 'iconfont icon-evection',
    controller: {
        type: 'evectionApplyGridController',
        cfgForm: 'kalix.workflow.evectionApply.view.EvectionApplyWindow',
        cfgViewForm: 'kalix.workflow.evectionApply.view.EvectionApplyViewWindow',
        cfgModel: 'kalix.workflow.evectionApply.model.EvectionApplyModel'
    },
    store: {
        type: 'evectionStore'
    },

    //todo 在此修改grid显示列
    columns: [
        {
            xtype: "rownumberer",
            text: "行号",
            width: 50,
            flex: 0,
            align: 'center',
            renderer: this.update
        },
        {
            text: '编号',
            dataIndex: 'id',
            hidden: true
        },
        {
            text: '经办人',
            dataIndex: 'createBy'
        },
        {
            text: '出差开始时间',
            dataIndex: 'beginDate',
            xtype: 'datecolumn',
            format: 'Y-m-d', formatText:'格式为YYYY-mm-dd',renderer: null
        },
        {
            text: '出差结束时间',
            dataIndex: 'endDate',
            xtype: 'datecolumn',
            format: 'Y-m-d', formatText:'格式为YYYY-mm-dd',renderer: null
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
                    //出差申请工作流启动后就不能够借款了
                    getClass: function (v, meta, record) {
                        if (record.data.status) {
                            return "kalix_hidden";
                        }
                        return "iconfont icon-workflow-loan-column";
                    },
                    //iconCls: 'iconfont icon-workflow-loan-column',
                    permission: 'attachment',
                    tooltip: '借款',
                    handler: 'onLoan'
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
                iconCls: 'iconfont icon-add',
                permission: 'add',
                handler: 'onAdd'
            }
        ]
    }
});
