/**
 * 试讲人员模型
 *
 * @author
 * @version 1.0.0
 */


Ext.define('kalix.usecase.lecture.model.LectureModel', {
    extend: 'kalix.model.BaseModel',
    //todo 在此修改模型定义
    fields: [
        {
            name: 'candidateId',validators: [{type: 'presence'}]
        },
        {
            name: 'subject',validators: [{type: 'presence'}]
        },
        {
            name: 'content',validators: [{type: 'presence'}]
        },
        {
            name: 'argumentScore',type: 'int',validators: [{type: 'presence'}]
        },
        {
            name: 'coursewareScore',type: 'int', validators: [{type: 'presence'}]
        },
        {
            name: 'expressionScore',type: 'int',validators: [{type: 'presence'}]
        },
        {
            name: 'attitudeScore',type: 'int',validators: [{type: 'presence'}]
        },
        {
            name: 'effectScore',type: 'int',validators: [{type: 'presence'}]
        },
        {
            name: 'qa',validators: [{type: 'presence'}]
        },
        {
            name: 'comment',validators: [{type: 'presence'}]
        },
        {
            name: 'suggestion',validators: [{type: 'presence'}]
        },
        {
            name: 'participant',validators: [{type: 'presence'}]
        },
        {
            name: 'pass',validators: [{type: 'presence'}]
        }
    ]
});
