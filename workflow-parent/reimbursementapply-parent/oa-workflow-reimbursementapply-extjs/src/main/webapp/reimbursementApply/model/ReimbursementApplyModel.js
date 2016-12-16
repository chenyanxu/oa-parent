/**model of contract
 *  @author chenyanxu
 *
 */
Ext.define('kalix.workflow.reimbursementApply.model.ReimbursementApplyModel', {
  extend: 'kalix.model.WorkflowBaseModel',
  constructor: function () {
    this.callParent(arguments);

    if (this.get('id') == 0) {
      this.set('title', '差旅费用报销单');

      this.modified = {};
      this.dirty = false;
    }
  },
  fields: [
    {name: 'reimbursementDate', type: 'date', dateFormat: 'Y-m-d H:i:s', validators: [{type: 'presence'}]}, //报销日期
    {name: 'reimbursementNo'}, //编号
    {name: 'bussinessPeopleId', type: 'int'},//出差人
    {name: 'reason', validators: [{type: 'presence'}]}, //出差事由
    {name: 'projectName', validators: [{type: 'presence'}]},//项目名称
    {name: 'managerUser', validators: [{type: 'presence'}]},//领导批示
    {name: 'depUser'}, //部门领导
    {name: 'financeUser'}, //财务主管
    {name: 'accountantUser'}, //会计
    {name: 'cashierUser'},//出纳
    {name: 'payeeUser'},//领款人
    {name: 'borrowMoney'},//预借金额
    {name: 'backMoney'}//补退金额
  ]
});
