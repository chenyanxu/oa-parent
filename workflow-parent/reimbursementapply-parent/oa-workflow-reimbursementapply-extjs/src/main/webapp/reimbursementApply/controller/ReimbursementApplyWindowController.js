/**
 * @author chenyanxu
 */
Ext.define('kalix.workflow.reimbursementApply.controller.ReimbursementApplyWindowController', {
    extend: 'kalix.controller.BaseWorkFlowWindowController',
    alias: 'controller.reimbursementApplyWindowController',
    onSave: function () {
        var viewModel = this.getViewModel();
        var model = viewModel.get('rec');
        var view = this.getView();
        var store = viewModel.get('store');

        store.proxy.extraParams = {};

        if (model.isValid()) {
            if (!model.dirty) {
                Ext.Msg.alert(CONFIG.ALTER_TITLE_INFO, '未修改数据');
                return;
            }

            //model.modified = model.data;

            //if (0 == model.id) {
            //    store.add(model);
            //}

            model.save({
                success: function () {
                    console.log(1);
                },
                callback: function () {
                    console.log(2);
                    if (model.get('tag')) {
                        model.set('id', Number(model.get('tag')));
                        model.dirty = false;
                        model.load(
                            {
                                success: function () {
                                    console.log(3);
                                    viewModel.set('rec', model);
                                },
                                scope: this
                            }
                        );
                    }
                },
                scope: {viewModel: viewModel, model: model}
            });

            //store.sync(
            //    {
            //        success: function () {
            //            //view.close();
            //            model.dirty = false;
            //        },
            //        callback: function (batch) {
            //            store.currentPage = 1;
            //            store.load();
            //
            //            var res = Ext.JSON.decode(batch.operations[0].getResponse().responseText);
            //
            //            if (batch.operations[0].success) {
            //                kalix.Notify.success(res.msg, CONFIG.ALTER_TITLE_SUCCESS);
            //
            //                if(res.tag){
            //                    //this.set('id',res.tag);
            //                    //model.dirty = false;
            //                }
            //            }
            //            else {
            //                Ext.Msg.alert(CONFIG.ALTER_TITLE_FAILURE, res);
            //            }
            //        },
            //        scope:model
            //    }
            //);
        } else {
            var orgId = model.get('orgId');
            var orgId = model.get('orgId');
            var orgId = model.get('orgId');
            var orgId = model.get('orgId');
        }
    }
});