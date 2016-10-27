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
            name: 'personCategory',
            validators: [{type: 'presence'}]
        },
        {
            name: 'orgId', //组织机构Id
            validators: [{type: 'presence'}]
        },
        {
            name: 'orgName' //组织机构名称
        },
        {
            name: 'xm',
            validators: [{type: 'presence'}]
        },
        {
            name: 'sex',
            validators: [{type: 'presence'}]
        },
        {
            name: 'age',
            type: 'int',
            defaultValue: 20,
            validators: [{type: 'presence'},{type: 'range',min:18,max:70}]
        },
        {
            name: 'graduateSchool',
            validators: [{type: 'presence'}]
        },
        {
            name: 'major',
            validators: [{type: 'presence'}]
        },
        {
            name: 'education',
            validators: [{type: 'presence'}]
        },
        {
            name: 'residence',
            validators: [{type: 'presence'}]
        },
        {
            name: 'position',
            validators: [{type: 'presence'}]
        },
        {
            name: 'salary',
            validators: [{type: 'presence'}]
        },
        {
            name: 'experience',
            validators: [{type: 'presence'}]
        },
        {
            name: 'comment'
        },
        {
            name: 'tel',
            validators: [{type: 'presence'}]
        }
    ]
});