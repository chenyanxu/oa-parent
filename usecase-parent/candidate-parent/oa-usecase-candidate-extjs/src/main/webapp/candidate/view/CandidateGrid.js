/**
 * 应聘人员表格
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.usecase.candidate.view.CandidateGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.usecase.candidate.controller.CandidateGridController',
        'kalix.usecase.candidate.store.CandidateStore',
        'kalix.oa.oADict.component.OADictGridColumn'
    ],
    alias: 'widget.candidateGrid',
    xtype: 'candidateGridPanel',
    controller: {
        type: 'candidateGridController',
        cfgForm: 'kalix.usecase.candidate.view.CandidateWindow',
        cfgViewForm: 'kalix.usecase.candidate.view.CandidateViewWindow',
        cfgModel: 'kalix.usecase.candidate.model.CandidateModel'
    },
    store: {
        type: 'candidateStore'
    },

    //todo 在此修改grid显示列
    columns: {
        defaults: {flex: 1, renderer: 'addTooltip'},
        items: [
            {
                xtype: 'rownumberer',
                text: '行号',
                width: 50,
                align: 'center',
                flex: 0,
                renderer: this.update
            },
            {
                text: '编号',
                dataIndex: 'id',
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
                text: '所在部门',
                dataIndex: 'orgName'
            },
            {
                text: '应聘岗位',
                dataIndex: 'position'
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
                text: '年龄',
                dataIndex: 'age'
            },
            {
                text: '毕业学校',
                dataIndex: 'graduateSchool'
            },
            {
                text: '专业',
                dataIndex: 'major'
            },
            {
                text: '期望工资',
                dataIndex: 'salary'
            },
            {
                text: '联系电话',
                dataIndex: 'tel'
            },
            {
                text: '户口所在地',
                dataIndex: 'residence'
            },
            {
                xtype: 'securityGridColumnCommon',
                verifyItems: [
                    {
                        iconCls: 'iconfont icon-view-column',
                        permission: 'view',
                        tooltip: '查看',
                        handler: 'onView'
                    },
                    {
                        iconCls: 'iconfont icon-edit-column',
                        permission: 'edit',
                        tooltip: '编辑',
                        handler: 'onEdit'
                    },
                    {
                        iconCls: 'iconfont icon-delete',
                        permission: 'delete',
                        tooltip: '删除',
                        handler: 'onDelete'
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
    },
    tbar: {
        xtype: 'securityToolbar',
        verifyItems: [
            {
                text: '添加',
                xtype: 'button',
                //todo change permission
                iconCls: 'iconfont icon-add',
                permission: 'add',
                handler: 'onAdd'
            }
        ]
    }
});
