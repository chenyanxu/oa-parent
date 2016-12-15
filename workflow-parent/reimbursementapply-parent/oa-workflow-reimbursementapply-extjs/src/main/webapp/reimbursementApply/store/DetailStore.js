/**
 * @author chenyanxu
 */
Ext.define('kalix.workflow.reimbursementApply.store.DetailStore', {
    extend: 'kalix.store.BaseStore',
    alias: 'store.detailStore',
    model: 'kalix.workflow.reimbursementApply.model.DetailModel',
    xtype: 'detailStore',
    storeId: 'detailStore',
    proxyUrl: CONFIG.restRoot + '/camel/rest/details',
    autoLoad: false
});