/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.evectionApply.controller.EvectionApplyGridController', {
    extend: 'kalix.controller.BaseGridController',
    requires: ['kalix.workflow.components.ActivitiProcessImageWindow'],
    alias: 'controller.evectionApplyGridController',
    mixins: {
        attachment: 'kalix.attachment.common.mixins.Attachment',
        workflow: 'kalix.workflow.common.mixins.Workflow'
    },
    onLoan: function (grid, rowIndex, colIndex) {
        var selModel = grid.getStore().getData().items[rowIndex];

        var view = Ext.create('kalix.workflow.loan.Main');
        var vm = view.lookupViewModel();

        vm.set('evectionId', selModel.get('id'));

        view.show();
        grid.setSelection(vm.get('rec'));
    }
});
