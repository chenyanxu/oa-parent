/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.meetingApply.store.MeetingApplyStore', {
    extend: 'kalix.store.BaseStore',
    alias: 'store.meetingApplyStore',
    model: 'kalix.workflow.meetingApply.model.MeetingApplyModel',
    xtype: 'meetingApplyStore',
    storeId: 'meetingApplyStore',
    proxyUrl: CONFIG.restRoot + '/camel/rest/meetingapplys'
});