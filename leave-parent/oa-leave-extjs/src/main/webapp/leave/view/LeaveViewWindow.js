/**
 * 面试人员查看表单
 *
 * @author
 * @version 1.0.0
 */

Ext.define('kalix.app.leave.view.LeaveViewWindow', {
    extend: 'kalix.view.components.common.BaseWindow',
        requires: [
            'kalix.app.leave.viewModel.LeaveViewModel'
        ],
        alias: 'widget.leaveViewWindow',
        viewModel: 'leaveViewModel',
    xtype: 'leaveViewWindow',
        width: 400,
    //todo 在此修改查看字段
    items: [{
            defaults: {readOnly: true},
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
                    activeError: '{validation.department}',
                    value: '{rec.department}'
                }
            },
                {
                    fieldLabel: '职位描述',
                    allowBlank: false,
                    bind: {
                        activeError: '{validation.comment}',
                        value: '{rec.comment}'
                    }
                }]
        }]
});