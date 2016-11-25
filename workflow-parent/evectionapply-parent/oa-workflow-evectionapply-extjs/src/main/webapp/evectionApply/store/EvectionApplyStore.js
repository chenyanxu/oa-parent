/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.evectionApply.store.EvectionApplyStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.workflow.evectionApply.model.EvectionApplyModel',
    alias: 'store.evectionStore',
    xtype: 'evectionStore',
    storeId: "evectionStore",
    proxyUrl: CONFIG.restRoot + '/camel/rest/evectionapplys'
});