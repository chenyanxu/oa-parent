/**
 * 项目选择下拉comboBox
 * @author zangyanming
 */
Ext.define('kalix.usecase.candidate.component.CandidateComboBox', {
    extend: 'kalix.view.components.common.BaseComboBox',
    requires: [
        'kalix.usecase.candidate.store.CandidateStore'
    ],
    alias: 'widget.candidateComboBox',
    xtype: 'candidateComboBox',
    valueField: 'id',
    displayField: 'xm',
    queryParam: '%xm%',
    modelField:'candidateId',
    store: {
        type: 'candidateStore'
    }
});
