/**
 * 面试人员数据仓库
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.app.leave.store.LeaveStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.app.leave.model.LeaveModel',
    alias: 'store.leaveStore',
    xtype: 'leaveStore',
    storeId: "leaveStore",
    proxyUrl: CONFIG.restRoot + '/camel/rest/leaves'
});