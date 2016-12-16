/**model of contract
 *  @author chenyanxu
 *
 */
Ext.define('kalix.workflow.recruitApply.model.RecruitApplyModel', {
    extend: 'kalix.model.WorkflowBaseModel',
    constructor: function () {
        this.callParent(arguments);

        if (this.get('id') == 0) {
            this.set('title','吉林动画学院用工招聘申请表');

            this.modified = {};
            this.dirty = false;
        }
    },
    fields: [
        {name: 'personType'},//人员类型
        {name: 'reason',validators: [{type: 'presence'}]},//需求原因申请事由
        {name: 'positionName'}, //职位名称
        {name: 'recruitCount',validators: [{type: 'presence'}]}, //拟聘人数
        {name: 'allocationCount',validators: [{type: 'presence'}]}, //定编人数
        {name: 'existCount', validators: [{type: 'presence'}]}, //现有人数
        {name: 'leaderName'}, //直接上级
        {name: 'treatmentLevel',validators: [{type: 'presence'}]}, //待遇标准
        {name: 'coreRecruit',validators: [{type: 'presence'}]}, //核心职责
        {name: 'commonRecruit',validators: [{type: 'presence'}]}, //常规职责
        {name: 'baseCondition',validators: [{type: 'presence'}]}, //任职基本素质条件
        {name: 'recruitType',validators: [{type: 'presence'}]}, //建议招聘方式
        {name: 'depUser'}, //申请部门负责人签字
        {name: 'manpower'} //人力资源部长签字
    ]
});