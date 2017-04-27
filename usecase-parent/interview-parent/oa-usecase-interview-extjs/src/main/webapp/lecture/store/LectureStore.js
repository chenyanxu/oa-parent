/**
 * 试讲人员数据仓库
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.usecase.lecture.store.LectureStore', {
    extend: 'kalix.store.BaseStore',
    model: 'kalix.usecase.lecture.model.LectureModel',
    alias: 'store.lectureStore',
    xtype: 'lectureStore',
    storeId: 'lectureStore',
    proxyUrl: CONFIG.restRoot + '/camel/rest/lectures'
});