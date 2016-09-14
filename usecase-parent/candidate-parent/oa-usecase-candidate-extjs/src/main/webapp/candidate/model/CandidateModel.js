/**
 * 面试人员模型
 *
 * @author
 * @version 1.0.0
 */


Ext.define('kalix.usecase.candidate.model.CandidateModel', {
    extend: 'kalix.model.BaseModel',
    //todo 在此修改模型定义
    fields: [
        {
            name: 'personCategory'
        },
        {
            name: 'orgId', //组织机构Id
            validators: [{type: 'presence'}]
        },
        {
            name: 'orgName' //组织机构名称
        },
        {
            name: 'xm'
        },
        {
            name: 'sex'
        },
        {
            name: 'age',
            type: 'int',
            defaultValue: 20
        },
        {
            name: 'graduateSchool'
        },
        {
            name: 'major'
        },
        {
            name: 'education'
        },
        {
            name: 'residence'
        },
        {
            name: 'position'
        },
        {
            name: 'salary'
        },
        {
            name: 'experience'
        },
        {
            name: 'comment'
        },
        {
            name: 'tel'
        }
    ]
});