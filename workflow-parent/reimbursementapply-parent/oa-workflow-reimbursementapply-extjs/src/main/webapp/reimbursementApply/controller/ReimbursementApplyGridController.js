/**
 * @author chenyanxu
 */
Ext.define('kalix.workflow.reimbursementApply.controller.ReimbursementApplyGridController', {
    extend: 'kalix.controller.BaseGridController',
    requires: ['kalix.workflow.components.ActivitiProcessImageWindow'],
    alias: 'controller.reimbursementApplyGridController',
    mixins: {
        attachment: 'kalix.attachment.common.mixins.Attachment',
        workflow:'kalix.workflow.common.mixins.Workflow'
    },
    onReimbursement: function(grid, rowIndex, colIndex){
        var view = Ext.create(this.cfgForm);
        var vm = view.lookupViewModel();
        var selModel = grid.getStore().getData().items[rowIndex];

        vm.set('rec', selModel);
        vm.set('iconCls', vm.get('addIconCls'));
        vm.set('title', vm.get('addTitle'));
        vm.set('store', this.getView().store);
        vm.get('rec').vm = vm;

        this.viewModelExtraInit(vm);

        view.show();
    }
});