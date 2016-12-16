/**model of contract
 *  @author chenyanxu
 *
 */
Ext.define('kalix.workflow.sealApply.model.SealApplyModel', {
    extend: 'kalix.model.WorkflowBaseModel',
    constructor: function () {
        this.callParent(arguments);

        if (this.get('id') == 0) {
            this.set('title', '吉林动画学院印章使用申请单');

            this.modified = {};
            this.dirty = false;
        }
    },
    fields: [
        {name: 'usageCount',validators: [{type: 'presence'}]},
        {name: 'sealType', defaultValue: '0', type: 'string'},
        {name: 'departmentHead'},
        {name: 'filialeHead'},
        {name: 'counsel'},
        {name: 'generalManager'},
        {name: 'sealAdministrator'},
        {name: 'remark'},
        {name: 'status'},
        {name: 'currentNode'}
    ]
});
