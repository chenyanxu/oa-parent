/**model of evection
 *  @author zangyanming
 *
 */
Ext.define('kalix.workflow.evectionApply.model.EvectionApplyModel', {
    extend: 'kalix.model.WorkflowBaseModel',
    constructor: function () {
        this.callParent(arguments);

        if (this.get('id') == 0) {
            this.set('title','吉林动画学院出差申请表');

            this.modified = {};
            this.dirty = false;
        }
    },
    //todo 在此修改模型定义
    fields: [
        {
            name: 'beginDate',
            type: 'date',
            dateFormat: 'Y-m-d H:i:s', validators: [{type: 'presence'}]
        },
        {
            name: 'endDate',
            type: 'date',
            dateFormat: 'Y-m-d H:i:s', validators: [{type: 'presence'}]
        },
        {
            name: 'reason',
            type: 'string',
            validators: [{type: 'presence'}]
        }, {
            name: 'projectName',
            type: 'string',
            validators: [{type: 'presence'}]
        },
        {
            name: 'depUser',
            type: 'string'
        },
        {
            name: 'chairmanUser',
            type: 'string'
        },
        {
            name: 'accountantUser',
            type: 'string'
        },
        {
            name: 'cashierUser',
            type: 'string'
        }
    ]
});
