/**
 * @author chenyanxu
 */
Ext.define('kalix.workflow.reimbursementApply.store.ReimbursementApplyStore', {
    extend: 'kalix.store.BaseStore',
    alias: 'store.reimbursementApplyStore',
    model: 'kalix.workflow.reimbursementApply.model.ReimbursementApplyModel',
    xtype: 'reimbursementApplyStore',
    storeId: 'reimbursementApplyStore',
    proxyUrl: CONFIG.restRoot + '/camel/rest/reimbursementapplys'
});