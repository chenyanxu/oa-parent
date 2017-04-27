/**
 * 会议室数据仓库
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.system.meetingroom.store.MeetingroomStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.system.meetingroom.model.MeetingroomModel',
    alias: 'store.meetingroomStore',
    xtype: 'meetingroomStore',
    storeId: 'meetingroomStore',
    autoLoad:true,
    proxyUrl: CONFIG.restRoot + '/camel/rest/meetingrooms'
});