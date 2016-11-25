/**
 * @author zangyanming
 */
Ext.define('kalix.workflow.loan.view.LoanGrid', {
    extend: 'kalix.view.components.common.BaseGrid',
    requires: [
        'kalix.workflow.loan.controller.LoanGridController',
        'kalix.workflow.loan.store.LoanStore'
    ],
    alias: 'widget.loanGrid',
    xtype: 'loanGridPanel',
    autoLoad: false,
    controller: {
        type: 'loanGridController',
        cfgForm: 'kalix.workflow.loan.view.LoanWindow',
        cfgViewForm: 'kalix.workflow.loan.view.LoanViewWindow',
        cfgModel: 'kalix.workflow.loan.model.LoanModel'
    },
    store: {
        type: 'loanStore'
    },
    height: 600,
    width: 800,
    listeners: {
        render: function (target, eOpts) {
            this.store.on('beforeload',function(store){
                var jsonStr = Ext.JSON.encode({'evectionId':this.lookupViewModel().get('evectionId')});

                store.proxy.extraParams = {'jsonStr': jsonStr};
            },this);
            this.store.load();
        }
    },
    //todo 在此修改grid显示列
    columns: [
        {
            xtype: "rownumberer",
            text: "行号",
            width: 50,
            flex: 0,
            align: 'center',
            renderer: this.update
        },
        {
            text: '编号',
            dataIndex: 'id',
            hidden: true
        },
        {
            text: '出差申请工作流ID',
            dataIndex: 'evectionId',
            hidden: true
        },
        {
            text: '交通费用',
            dataIndex: 'trafficMoney'
        },
        {
            text: '餐费',
            dataIndex: 'foodMoney'
        },
        {
            text: '住宿费',
            dataIndex: 'hotelMoney'
        },
        {
            text: '业务费用',
            dataIndex: 'bussinessMoney'
        },
        {
            text: '其他费用',
            dataIndex: 'otherMoney'
        },
        {
            text: '其他费用说明',
            dataIndex: 'comment'
        },
        {
            flex: 1.5,
            xtype: 'securityGridColumnCommon',
            verifyItems: [
                {
                    iconCls: 'iconfont icon-view-column',
                    permission: 'view',
                    tooltip: '查看',
                    handler: 'onView'
                },
                {
                    permission: 'edit',
                    tooltip: '编辑',
                    handler: 'onEdit',
                    getClass: function (v, meta, record) {
                        //if (0 != record.data.status) {
                        //    return "kalix_hidden";
                        //}
                        return "iconfont icon-edit-column";
                    }
                },
                {
                    permission: 'delete',
                    tooltip: '删除',
                    handler: 'onDelete',
                    getClass: function (v, meta, record) {
                        //if (0 != record.data.status) {
                        //    return "kalix_hidden";
                        //}
                        return "iconfont icon-delete";
                    }
                },
                {
                    iconCls: 'iconfont icon-attachment-column',
                    permission: 'attachment',
                    tooltip: '附件管理',
                    handler: 'onAttachmentManage'
                }
            ]
        }
    ],
    tbar: {
        xtype: 'securityToolbar',
        verifyItems: [
            {
                text: '添加',
                xtype: 'button',
                iconCls: 'iconfont icon-add',
                permission: 'add',
                handler: 'onAdd'
            }
        ]
    }
});
