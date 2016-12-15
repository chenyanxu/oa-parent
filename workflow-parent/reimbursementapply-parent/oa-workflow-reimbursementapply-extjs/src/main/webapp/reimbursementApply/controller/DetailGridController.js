Ext.define('kalix.workflow.reimbursementApply.controller.DetailGridController', {
  extend: 'Ext.app.ViewController',
  alias: 'controller.detailGridController',
  addExpense: function () {
    if(this.getView().lookupViewModel().get('rec').get('id')==0){
      alert('先保存基本信息');
      return;
    }

    var store = this.getView().getStore();

    for(var rIndex=0;rIndex<store.data.length;++rIndex){
      if(store.data.getAt(rIndex).dirty || store.data.getAt(rIndex).get('id')==0){
        alert('有记录未提交');
        return;
      }
    }

    var model=new Ext.create('kalix.workflow.reimbursementApply.model.DetailModel');

    store.add(model);
  },
  deleteExpense: function () {
    this.getView().getStore().remove(this.getView().getSelection());
  }
});
