/**model of loan
 *  @author zangyanming
 *
 */
Ext.define('kalix.workflow.loan.model.LoanModel', {
    extend: 'kalix.model.BaseModel',

    //todo 在此修改模型定义
    fields: [
        {
            name: 'evectionId',
            type: 'int'
        },
        {
            name: 'trafficMoney',
            type: 'int',
            defalutValue: 0
        },
        {
            name: 'foodMoney',
            type: 'int',
            defalutValue: 0
        },
        {
            name: 'hotelMoney',
            type: 'int',
            defalutValue: 0
        },
        {
            name: 'bussinessMoney',
            type: 'int',
            defalutValue: 0
        },
        {
            name: 'otherMoney',
            type: 'int',
            defalutValue: 0
        },
        {
            name: 'comment',
            type: 'string'
        }
    ]
});
