/**
 * 面试人员表格控制器
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.usecase.interview.controller.InterviewGridController', {
    extend: 'kalix.controller.BaseGridController',
    alias: 'controller.interviewGridController',
    onClick: function (grid, rowIndex, colIndex) {
        var selModel = grid.getStore().getData().items[rowIndex];

        if(selModel.id == 0){
            var viewModel = this.getViewModel();
            var view = Ext.create(this.cfgForm);
            var vm = view.lookupViewModel();

            vm.set('rec', Ext.create(this.cfgModel));
            vm.set('rec.data.candidateId',selModel.data.candidateId);
            vm.set('iconCls', 'iconfont icon-add');
            vm.set('title', viewModel.get('add_title'));
            view.show();
        }else{
            this.onEdit(grid,rowIndex,colIndex);
        }
    },

    onInterviewOne:function(){
        var grid = this.getView();
        var viewModel = this.getViewModel();
        var view = Ext.create(this.cfgForm,{whichInterview:'first'});
        view.items.items[0].items.items[5].hidden = true;
        view.items.items[0].items.items[6].hidden = true;
        view.items.items[0].items.items[7].hidden = true;
        view.items.items[0].items.items[8].hidden = true;


        var vm = view.lookupViewModel();

        vm.set('rec', Ext.create(this.cfgModel));
        vm.set('iconCls', vm.get('addIconCls'));
        vm.set('title', vm.get('addTitle'));
        vm.set('store',this.getView().store);

        this.viewModelExtraInit(vm);
        view.show();
    },

    onInterviewTwo:function(){
        var viewModel = this.getViewModel();
        var view = Ext.create(this.cfgForm,{whichInterview:'second'});
        view.items.items[0].items.items[1].hidden = true;
        view.items.items[0].items.items[2].hidden = true;
        view.items.items[0].items.items[3].hidden = true;
        view.items.items[0].items.items[4].hidden = true;

        //var selModel = grid.getStore().getData().items[rowIndex];
        var selModel = Ext.create(this.cfgModel);
        selModel.set('whichInterview','review');
        var vm = view.lookupViewModel();
        vm.set('rec', selModel);
        vm.set('iconCls', vm.get('editIconCls'));
        vm.set('title',vm.get('editTitle'));
        vm.set('store',this.getView().store);

        this.viewModelExtraInit(vm);
        view.show();
    }
});
