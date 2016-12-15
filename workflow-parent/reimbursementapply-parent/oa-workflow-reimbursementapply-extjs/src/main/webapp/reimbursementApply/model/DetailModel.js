/**model of loan
 *  @author zangyanming
 *
 */
Ext.define('kalix.workflow.reimbursementApply.model.DetailModel', {
    extend: 'kalix.model.BaseModel',

    //todo 在此修改模型定义
    fields: [
        {
            name: 'reimbursementApplyId',
            type: 'int'
        },
        {
            name: 'startMonth',
            type: 'int'
        },
        {
            name: 'startDay',
            type: 'int'
        },
        {
            name: 'startTime'
        },
        {
            name: 'startPlace'
        },
        {
            name: 'arriveMonth',
            type: 'int'
        },
        {
            name: 'arriveDay',
            type: 'int'
        },
        {
            name: 'arriveTime'
        },
        {
            name: 'arrivePlace'
        },
        {
            name: 'personNumber',
            type: 'int'
        },
        {
            name: 'trafficTool'
        },
        {
            name: 'trafficMoney',
            type: 'float'
        },
        {
            name: 'dayNumber',
            type: 'int'
        },
        {
            name: 'subsidyStandard',
            type: 'float'
        },
        {
            name: 'subsidyMoney',
            type: 'float'
        },
        {
            name: 'hotelMoney',
            type: 'float'
        },
        {
            name: 'cityTrafficMoney',
            type: 'float'
        },
        {
            name: 'otherMoneyOne',
            type: 'float'
        },
        {
            name: 'otherMoneyTwo',
            type: 'float'
        },
        {
            name: 'otherMoneyThree',
            type: 'float'
        },
        {
            name: 'totalMoney',
            type: 'float'
        }
    ]
});
