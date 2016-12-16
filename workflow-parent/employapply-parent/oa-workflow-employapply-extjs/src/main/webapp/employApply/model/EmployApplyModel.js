/**model of contract
 *  @author chenyanxu
 *
 */
Ext.define('kalix.workflow.employApply.model.EmployApplyModel', {
    extend: 'kalix.model.WorkflowBaseModel',
    constructor: function () {
        this.callParent(arguments);

        if (this.get('id') == 0) {
            this.set('title','吉林动画学院入职申请表');

            this.modified = {};
            this.dirty = false;
        }
    },
    fields: [
        {name: 'candidateId'}, //应聘者ID
        {name: 'branchSchoolLeader'}, //分院领导审批
        {name: 'schoolLeader'}, //校领导审批
        {name: 'manpower'}//人力资源部长签字
    ]
});
