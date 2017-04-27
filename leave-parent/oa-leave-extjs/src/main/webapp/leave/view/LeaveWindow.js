/**
 * 职位添加和修改表单
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.leave.view.LeaveWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
    requires: [
        'kalix.app.leave.viewModel.LeaveViewModel',
        'kalix.controller.BaseWindowController'
    ],
    alias: 'widget.leaveWindow',
    viewModel: 'leaveViewModel',
    controller: {
        type: 'baseWindowController',
        storeId: 'leaveStore'
    },
    xtype: 'leaveWindow',
    width: 400,
    //todo 在此修改表单
    items: [{
        xtype: 'baseForm',
        items: [{
            fieldLabel: '职位名称',
            allowBlank: false,
            bind: {
                activeError: '{validation.name}',
                value: '{rec.name}'
            }
        },
        {
            fieldLabel: '所在部门',
            allowBlank: false,
            bind: {
                activeError: '{validation.title}',
                value: '{rec.department}'
            }
        }, {
            fieldLabel: '职位描述',
            allowBlank: false,
            xtype: 'textarea',
            bind: {
                activeError: '{validation.content}',
                value: '{rec.comment}'
            }
        }]
    }]
});