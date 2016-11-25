/**model of evection
 *  @author zangyanming
 *
 */
Ext.define('kalix.workflow.evectionApply.model.EvectionApplyModel', {
    extend: 'kalix.model.WorkflowBaseModel',

    //todo 在此修改模型定义
    fields: [
        {
            name: 'beginDate',
            type: 'date',
            dateFormat: 'Y-m-d H:i:s'
        },
        {
            name: 'endDate',
            type: 'date',
            dateFormat: 'Y-m-d H:i:s'
        },
        {
            name: 'reason',
            type: 'string'
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
