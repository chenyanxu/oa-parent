/**
 * 面试人员数据仓库
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.usecase.interview.store.InterviewStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.usecase.interview.model.InterviewModel',
    alias: 'store.interviewStore',
    xtype: 'interviewStore',
    storeId: 'interviewStore',
    proxyUrl: CONFIG.restRoot + '/camel/rest/interviews'
});