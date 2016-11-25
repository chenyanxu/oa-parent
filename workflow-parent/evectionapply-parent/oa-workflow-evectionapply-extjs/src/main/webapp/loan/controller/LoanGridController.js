/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.loan.controller.LoanGridController', {
    extend: 'kalix.controller.BaseGridController',
    alias: 'controller.loanGridController',
    mixins: {
        attachment: 'kalix.attachment.common.mixins.Attachment'
    },
    /**
     * 打开添加操作.
     */
    onAdd: function (target) {
        var evectionId = this.getView().lookupViewModel().get('evectionId');
        var view = Ext.create(this.cfgForm);
        var vm = view.lookupViewModel();

        vm.set('rec', Ext.create(this.cfgModel));
        vm.set('iconCls', vm.get('addIconCls'));
        vm.set('title', vm.get('addTitle'));
        vm.set('store',this.getView().store);

        vm.get('rec').set('evectionId',evectionId);
        vm.get('rec').dirty = false;
        vm.get('rec').modified = {};
        vm.get('rec').vm=vm;

        this.viewModelExtraInit(vm);

        view.show();
    }
});
