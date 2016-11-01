/**
 * 面试人员查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.usecase.interview.view.InterviewSearchForm', {
    extend: 'kalix.view.components.common.BaseSearchForm',
    alias: 'widget.interviewSearchForm',
    requires:[
        'kalix.usecase.candidate.component.CandidateComboBox'
    ],
    xtype: 'interviewSearchForm',
    items: [
        {
            xtype: 'candidateComboBox',
            fieldLabel: '应聘者姓名',
            allowBlank: true,
            name:'%candidateId%'
        }
    ]
});
