/**
 * 审计查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.workflow.employApply.view.EmployApplySearchForm', {
  extend: 'kalix.view.components.common.BaseSearchForm',
  alias: 'widget.employApplySearchForm',
  xtype: 'employApplySearchForm',
  storeId: 'employApplyStore',
  items: [
    {
      xtype: 'textfield',
      fieldLabel: '经办人',
      labelAlign: 'right',
      labelWidth: 60,
      width: 200,
      name: 'createBy'
    }
  ]
});
