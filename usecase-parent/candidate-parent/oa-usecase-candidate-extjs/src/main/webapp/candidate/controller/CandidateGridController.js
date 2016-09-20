/**
 * 面试人员表格控制器
 *
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.usecase.candidate.controller.CandidateGridController', {
    extend: 'kalix.controller.BaseGridController',
    alias: 'controller.candidateGridController',
    mixins: {
        attachment: 'kalix.attachment.common.mixins.Attachment'
    }
});
