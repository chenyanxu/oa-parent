/**
 * 试讲人员查询表单
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.usecase.lecture.view.LectureSearchForm', {
    extend: 'kalix.view.components.common.BaseSearchForm',
    alias: 'widget.lectureSearchForm',
    requires:[
        'kalix.usecase.candidate.component.CandidateComboBox'
    ],
    xtype: 'lectureSearchForm',
    items: [
        {
            xtype: 'candidateComboBox',
            fieldLabel: '应聘者姓名',
            allowBlank: true,
            name:'candidateId'
        }
    ]
});
