/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.meetingRoomApply.store.MeetingRoomApplyStore', {
    extend: 'kalix.store.BaseStore',
    alias: 'store.meetingRoomApplyStore',
    model: 'kalix.workflow.meetingRoomApply.model.MeetingRoomApplyModel',
    xtype: 'meetingRoomApplyStore',
    storeId: 'meetingRoomApplyStore',
    proxyUrl: CONFIG.restRoot + '/camel/rest/meetingroomapplys'
});