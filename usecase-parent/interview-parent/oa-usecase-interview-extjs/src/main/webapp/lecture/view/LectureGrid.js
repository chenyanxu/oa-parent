/**
 * 试讲人员表格
 * @author
 * @version 1.0.0
 */
Ext.define('kalix.usecase.lecture.view.LectureGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.usecase.lecture.controller.LectureGridController',
        'kalix.usecase.lecture.store.LectureStore'
    ],
    alias: 'widget.lectureGrid',
    xtype: 'lectureGridPanel',
    controller: {
        type: 'lectureGridController',
        cfgForm: 'kalix.usecase.lecture.view.LectureWindow',
        cfgViewForm: 'kalix.usecase.lecture.view.LectureViewWindow',
        cfgModel: 'kalix.usecase.lecture.model.LectureModel'
    },
    store: {
        type: 'lectureStore'
    },

    //todo 在此修改grid显示列
    columns: {
        defaults: {flex: 1, renderer: 'addTooltip'},
        items: [
            {
                xtype: 'rownumberer',
                text: '行号',
                width: 50,
                align: 'center',
                flex: 0,
                renderer: this.update
            },
            {
                text: '编号',
                dataIndex: 'id',
                hidden: true
            },
            {
                text: '应聘人',
                dataIndex: 'candidateId',
                hidden: true
            },
            {
                text: '应聘者姓名',
                dataIndex: 'xm'
            },
            {
                text: '所在部门',
                hidden:true,
                dataIndex: 'orgId'
            },

            {
                text: '试讲题目',
                dataIndex: 'subject'
            },
            {
                text: '授课内容',
                dataIndex: 'content'
            },
            {
                text: '听课人',
                dataIndex: 'participant'
            },
            {
                text: '是否聘用',
                trueText: '是',
                falseText: '否',
                xtype: 'booleancolumn',
                dataIndex: 'pass',
                renderer: null
            },
            {
                xtype: 'securityGridColumnCommon',
                items: [
                    {
                        iconCls: 'iconfont icon-view-column',
                        permission: 'view',
                        tooltip: '查看',
                        handler: 'onView'
                    },
                    {
                        iconCls: 'iconfont icon-edit-column',
                        permission: 'edit',
                        tooltip: '编辑',
                        handler: 'onEdit'
                        //getClass: function (v, meta, record) {
                        //    if (record.data.employment == true) {
                        //        return 'kalix_hidden';
                        //    }
                        //    return 'iconfont icon-edit-column';
                        //}
                    },
                    {
                        iconCls: 'iconfont icon-delete',
                        permission: 'delete',
                        tooltip: '删除',
                        handler: 'onDelete'
                    }
                ]
            }
        ]
    },
    tbar: {
        xtype: 'securityToolbar',
        verifyItems: [
            {
                text: '添加',
                xtype: 'button',
                //todo change permission
                iconCls:'iconfont icon-add',
                permission: 'add',
                handler: 'onAdd'
            }
        ]
    }
});
