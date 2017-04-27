/**
 * 面试人员表格
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.leave.view.LeaveGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.app.leave.controller.LeaveGridController',
        'kalix.app.leave.store.LeaveStore'
    ],
    alias: 'widget.leaveGrid',
    xtype: 'leaveGridPanel',
    controller: {
        type: 'leaveGridController',
        storeId: 'leaveStore',
        cfgForm: 'kalix.app.leave.view.LeaveWindow',
        cfgViewForm: 'kalix.app.leave.view.LeaveViewWindow',
        cfgModel: 'kalix.app.leave.model.LeaveModel'
    },
    store: {
        type: 'leaveStore'
    },

    //todo 在此修改grid显示列
    columns: {
        defaults: {flex: 1,renderer: 'addTooltip'},
        items: [
            {
                xtype: 'rownumberer',
                text: '行号',
                width: 50,
                align: 'center',
                flex:0,
                renderer:this.update
            },
            {
                text: '编号',
                dataIndex: 'id',
                hidden: true
            },
            {
                text: '职位名称',
                dataIndex: 'name'
            },
            {
                text: '所在部门',
                dataIndex: 'department'
            }, {
                text: '职位描述',
                dataIndex: 'comment'
            },
            {
                xtype: 'securityGridColumnCommon',
                verifyItems: [
                    {
                        iconCls:'iconfont icon-view-column',
                        permission: 'admin:constructModule:leaveMenu:view',
                        tooltip: '查看',
                        handler: 'onView'
                    },
                    {
                        iconCls:'iconfont icon-edit-column',
                        permission: 'admin:constructModule:leaveMenu:edit',
                        tooltip: '编辑',
                        handler: 'onEdit'
                    }, {
                        iconCls:'iconfont icon-delete',
                        permission: 'admin:constructModule:leaveMenu:delete',
                        tooltip: '删除',
                        handler: 'onDelete'
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
                permission: 'admin:constructModule:leaveMenu:add',
                bind: {icon: '{add_image_path}'},
                handler: 'onAdd'
            }
        ]
    }
});
