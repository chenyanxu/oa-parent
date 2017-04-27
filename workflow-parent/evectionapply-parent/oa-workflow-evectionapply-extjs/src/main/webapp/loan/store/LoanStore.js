/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.loan.store.LoanStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.workflow.loan.model.LoanModel',
    alias: 'store.loanStore',
    xtype: 'loanStore',
    storeId: 'loanStore',
    proxyUrl: CONFIG.restRoot + '/camel/rest/loans'
});