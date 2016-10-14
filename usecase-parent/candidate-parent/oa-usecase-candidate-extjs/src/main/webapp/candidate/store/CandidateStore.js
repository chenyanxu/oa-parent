/**
 * 面试人员数据仓库
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.usecase.candidate.store.CandidateStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.usecase.candidate.model.CandidateModel',
    alias: 'store.candidateStore',
    xtype: 'candidateStore',
    storeId: "candidateStore",
    autoLoad: true,
    proxyUrl: CONFIG.restRoot + '/camel/rest/candidates'
});