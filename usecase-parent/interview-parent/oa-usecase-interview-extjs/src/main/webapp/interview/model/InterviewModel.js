/**
 * 面试人员模型
 *
 * @author
 * @version 1.0.0
 */


Ext.define('kalix.usecase.interview.model.InterviewModel', {
    extend: 'kalix.model.BaseModel',
    //todo 在此修改模型定义
    fields: [
        {
            name: 'candidateId'
        },
        {
            name: 'dateFirst',type: 'date', dateFormat: 'Y-m-d H:i:s'
        },
        {
            name: 'interviewerFirst'
        },
        {
            name: 'interviewContentFirst'
        },
        {
            name: 'passFirst'
        },
        {
            name: 'dateSecond',type: 'date', dateFormat: 'Y-m-d H:i:s'
        },
        {
            name: 'interviewerSecond'
        },
        {
            name: 'interviewContentSecond'
        },
        {
            name: 'passSecond'
        },
        {
            name: 'whichInterview'
        }
    ]
});
