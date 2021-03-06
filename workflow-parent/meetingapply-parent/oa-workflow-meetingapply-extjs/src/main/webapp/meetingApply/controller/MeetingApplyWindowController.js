/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.meetingApply.controller.MeetingApplyWindowController', {
    extend: 'kalix.controller.BaseWindowController',
    alias: 'controller.meetingApplyWindowController',
    onSave: function () {
        var viewModel = this.getViewModel();
        var model = viewModel.get('rec');
        //model.set('updateDate',new Date());
        if(model.data.orgId == null){
            Ext.Msg.alert(CONFIG.ALTER_TITLE_SUCCESS, '请输入申请部门');
            return;
        }
        if (model.data.meetingroomId == 0 || model.data.meetingroomId == null) {
            Ext.Msg.alert(CONFIG.ALTER_TITLE_SUCCESS, '请选择会议地点');
            return;
        }
        if(model.data.meetingTopic == null){
            Ext.Msg.alert(CONFIG.ALTER_TITLE_SUCCESS, '请输入会议议题');
            return;
        }
        if (model.data.meetingAgenda == null) {
            Ext.Msg.alert(CONFIG.ALTER_TITLE_SUCCESS, '请输入会议议程');
            return;
        }

        delete model.data['updateDate'];
        var view = this.getView();
        var selectBeginTime = model.data.beginTime;
        var selectEndTime = model.data.endTime;
        if (selectBeginTime == null || selectEndTime == null) {
            Ext.Msg.alert(CONFIG.ALTER_TITLE_SUCCESS, '请输入正确会议日期时间');
            return;
        }


        var nowDay = new Date();
        if (selectBeginTime < nowDay) {
            Ext.Msg.alert(CONFIG.ALTER_TITLE_SUCCESS, '会议开始日期时间不能小于当前日期时间');
            return;
        }
        if(selectBeginTime >= selectEndTime){
            Ext.Msg.alert(CONFIG.ALTER_TITLE_SUCCESS, '会议结束时间不能小于等于开始时间');
            return;
        }


        //var checked = false;
        //var jsonStr = Ext.JSON.encode(model.data);
        //Ext.Ajax.request({
        //    async : false,
        //    url: CONFIG.restRoot + '/camel/rest/meetingapplys/check',
        //    method: 'GET',
        //    paramsAsJson: true,
        //    params: {
        //        'jsonStr':jsonStr
        //    },
        //    callback: function (options, success, response) {
        //        var resp = Ext.JSON.decode(response.responseText);
        //
        //        if (resp.success) {
        //            if(resp.msg == '0') {
        //                checked = true;
        //            }else{
        //                checked = false;
        //            }
        //            //scope.callParent(arguments);
        //        }
        //        else{
        //            Ext.MessageBox.alert(CONFIG.ALTER_TITLE_INFO, resp.msg);
        //        }
        //    }
        //});
        //if(checked) {
        //    this.callParent(arguments);
        //}else {
        //    Ext.MessageBox.alert(CONFIG.ALTER_TITLE_INFO, '会议时间冲突');
        //}
        this.callParent(arguments);
    }
});