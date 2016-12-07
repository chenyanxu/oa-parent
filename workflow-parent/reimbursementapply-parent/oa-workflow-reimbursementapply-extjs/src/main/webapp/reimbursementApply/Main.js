/**
 * @author chenyanxu
 */
Ext.define('kalix.workflow.reimbursementApply.Main', {
  extend: 'kalix.container.BaseContainer',
  requires: [
    'kalix.workflow.reimbursementApply.view.ReimbursementApplyGrid',
    'kalix.workflow.reimbursementApply.view.ReimbursementApplySearchForm'
  ],
  storeId: 'reimbursementApplyStore',
  items: [
    {
      title: '报销申请查询',
      xtype: 'reimbursementApplySearchForm'
    },
    {
      xtype: 'reimbursementApplyGrid',
      title: '报销申请列表'
    }
  ]
});
