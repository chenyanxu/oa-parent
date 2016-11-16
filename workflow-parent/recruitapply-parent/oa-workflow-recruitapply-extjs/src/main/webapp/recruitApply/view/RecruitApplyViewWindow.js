/**
 * @author chenyanxu
 */

Ext.define('kalix.workflow.recruitApply.view.RecruitApplyViewWindow', {
  extend: 'kalix.view.components.common.BaseWindow',
  requires: [
    'kalix.workflow.recruitApply.view.RecruitApplyViewForm'
  ],
  alias: 'widget.recruitApplyViewWindow',
  xtype: "recruitApplyViewWindow",
  width: 840,
  items: [
    {
      xtype: 'recruitApplyViewForm'
    }
  ]
});