/**
 * 审计查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.workflow.meetingApply.view.MeetingApplySearchForm', {
    extend: 'kalix.view.components.common.BaseSearchForm',
    alias: 'widget.meetingApplySearchForm',
    xtype: 'meetingApplySearchForm',
    storeId: 'meetingApplyStore',
    items: [
        {
            xtype: 'textfield',
            fieldLabel: '申请部门',
            labelAlign: 'right',
            labelWidth: 60,
            width: 200,
            name: '%orgName%'
        }, {
            xtype: 'textfield',
            fieldLabel: '经办人',
            labelAlign: 'right',
            labelWidth: 60,
            width: 200,
            name: '%createBy%'
        }
    ]
});
