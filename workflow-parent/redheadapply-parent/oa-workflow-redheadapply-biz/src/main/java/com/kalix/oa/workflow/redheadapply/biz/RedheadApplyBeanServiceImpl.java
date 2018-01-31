package com.kalix.oa.workflow.redheadapply.biz;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.kalix.framework.core.api.persistence.JpaStatistic;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.web.model.QueryDTO;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.middleware.statemachine.api.biz.IStatemachineService;
import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.system.dict.api.biz.IOADictBeanService;
import com.kalix.oa.system.dict.entities.OADictBean;
import com.kalix.oa.workflow.redheadapply.api.biz.IDocumentBeanService;
import com.kalix.oa.workflow.redheadapply.api.biz.IDocumentConfigBeanService;
import com.kalix.oa.workflow.redheadapply.api.biz.IRedheadApplyBeanService;
import com.kalix.oa.workflow.redheadapply.api.dao.IRedheadApplyBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.DocumentBean;
import com.kalix.oa.workflow.redheadapply.entities.DocumentConfigBean;
import com.kalix.oa.workflow.redheadapply.entities.RedheadApplyBean;

import javax.persistence.Tuple;
import java.io.InputStream;
import java.util.*;

/**
 * @author sunlf
 */
public class RedheadApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IRedheadApplyBeanDao, RedheadApplyBean> implements IRedheadApplyBeanService {
    private IStatemachineService statemachineService;
    private IDocumentBeanService documentBeanService;
    private IDocumentConfigBeanService documentConfigBeanService;
    private IOADictBeanService oaDictBeanService;

    /**
     * 创建流程业务编号-----文号
     * 格式：
     * 类型： 吉动院字
     * 吉动院人字
     * 吉动院教字
     * 吉动院学字
     * 吉动院招字
     * 吉动院研字
     * 吉动院学位字
     * 吉动校友字
     * 吉动院研学字
     * 文号： [2017]1号
     *
     * @return
     */
    @Override
    public synchronized String createBusinessNo(RedheadApplyBean bean) {
        /*if (bean.getDocCategory().equals("对内")) { // 吉动X字〔2017〕X号

        } else if (bean.getDocCategory().equals("对外")) { //吉动院字〔2017〕X号

        }
        return super.createBusinessNo(bean);*/
        String businessNo = "";
        //获取年份信息
        Calendar c = Calendar.getInstance();
        String year = String.valueOf(c.get(Calendar.YEAR));
        //获取最小文号发文信息
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("document-state.xml");
        statemachineService.initFSM(is, "已撤回");
        DocumentBean documentBean = documentBeanService.getMinEntity(bean.getDocType(), year, statemachineService.getCurrentState());
        //存在记录，使用最小文号(状态重置为【使用中】且更新记录为当前业务，注保证最新)
        if (documentBean != null) {
            businessNo = documentBean.getBusinessNo();
            //修改记录状态(状态重置为【使用中】)
            statemachineService.processFSM("回收");
            documentBean.setStatus(statemachineService.getCurrentState());
            //更新业务数据
            documentBean.setRedheadId(bean.getId());
            /*documentBean.setDocDate(bean.getDocDate());
            documentBean.setDocDept(bean.getDocDept());
            documentBean.setTitle(bean.getTitle());
            documentBean.setDocUrl(bean.getDocUrl());
            documentBean.setDocContent(bean.getDocContent());*/
            documentBeanService.updateEntity(documentBean);
        } else { //不存在记录,使用配置表文号(取号码)
            Integer num = 1;
            DocumentConfigBean documentConfigBean = documentConfigBeanService.getEntity(bean.getDocType(), year);
            if (documentConfigBean != null) {
                //存在配置信息,取号码
                num = documentConfigBean.getNumber();
                //修改配置信息
                documentConfigBeanService.updateNumber(documentConfigBean.getId(), (num + 1));
            } else {
                //不存在配置信息,生成并保存配置信息
                documentConfigBean = new DocumentConfigBean();
                documentConfigBean.setDocType(bean.getDocType());
                documentConfigBean.setYear(year);
                documentConfigBean.setNumber(num.intValue() + 1);
                documentConfigBeanService.saveEntity(documentConfigBean);
            }
            //生成文号【吉动X字〔2017〕X号】【吉动院字〔2017〕X号】
            OADictBean oaDictBean = oaDictBeanService.getByTypeAndValue("文号类型", bean.getDocType());
            businessNo = oaDictBean.getLabel() + "[" + year + "]" + num.toString() + "号";
            //保存发文信息
            documentBean = new DocumentBean();
            documentBean.setRedheadId(bean.getId());
            /*documentBean.setDocDate(bean.getDocDate());
            documentBean.setDocDept(bean.getDocDept());
            documentBean.setTitle(bean.getTitle());
            documentBean.setDocUrl(bean.getDocUrl());
            documentBean.setDocContent(bean.getDocContent());*/
            documentBean.setDocType(bean.getDocType());
            documentBean.setYear(year);
            documentBean.setNumber(num);
            documentBean.setBusinessNo(businessNo);
            is = this.getClass().getClassLoader().getResourceAsStream("document-state.xml");
            statemachineService.initFSM(is, "新建");
            statemachineService.processFSM("使用");
            documentBean.setStatus(statemachineService.getCurrentState());
            documentBeanService.saveEntity(documentBean);
        }
        return businessNo;
    }

    @Override
    public void beforeSaveEntity(RedheadApplyBean entity, JsonStatus status) {
        if (entity.getId() > 0) {
//            update
        } else {
//            add
            InputStream is = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
            statemachineService.initFSM(is, "新建");
            entity.setDocStatus(statemachineService.getCurrentState());
        }
        super.beforeSaveEntity(entity, status);
    }

    @Override
    public void getStartMap(Map map, RedheadApplyBean bean) {
        List<String> assigneeList = Arrays.asList("蔡志忠", "马世硕");
       /*List<String> assigneeList = new ArrayList<>();
        String importantAttendees = bean.getManagerUser();
        if (importantAttendees.length() > 0) {
            String[] split = importantAttendees.split(",");
            for (int i = 0; i < split.length; i++) {
                assigneeList.add(split[i]);
            }
        }*/
        map.put("assigneeList", assigneeList);
        super.getStartMap(map, bean);
    }

    @Override
    public void beforeUpdateEntity(RedheadApplyBean entity, JsonStatus status) {
        // 判断如果流程启动，编辑时，生成businessNo字段
        // 流程启动
        if (entity.getStatus() == 1) {
            // 判断entity.editDocType，是否允许修改文号（处理逻辑放在流程里处理，通过环境变量配置处理entity.editDocType）
            // 如果允许修改，根据主键entity.id查找RedheadApplyBean对象，比较文号类型是否改变
            // 文号类型改变，设置文号状态为【已撤回】，调用createBusinessNo方法生成新文号
            // 查找修改前红头文件信息
            RedheadApplyBean oldRedheadApplyBean = this.getEntity(entity.getId());
            // 判断是否修改文号
            if (entity.getEditDocType()) {
                // 比较新旧文号类型是否改变,如果改变
                if (!oldRedheadApplyBean.getDocType().equals(entity.getDocType())) {
                    InputStream is = this.getClass().getClassLoader().getResourceAsStream("document-state.xml");
                    statemachineService.initFSM(is, "使用中");
                    statemachineService.processFSM("撤回");
                    DocumentBean documentBean = documentBeanService.getEntityByBusinessNo(oldRedheadApplyBean.getBusinessNo());
                    // 文号使用记录表中存在记录，修改状态为【已撤回】，保证该文号下次生成可用
                    if (documentBean != null) {
                        documentBean.setStatus(statemachineService.getCurrentState());
                        documentBeanService.updateEntity(documentBean);
                    } else {
                        // 文号记录表中无记录（正常不应该存在该情况，可以insert补充）
                    }
                    // 取新的文号
                    String newBusinessNo = this.createBusinessNo(entity);
                    entity.setBusinessNo(newBusinessNo);
                    // 修改流程运行时名称
                    runtimeService.setProcessInstanceName(entity.getProcessInstanceId(), newBusinessNo);
                }
            }
            // 流程启动，判断是否修改审批选项
            if (!oldRedheadApplyBean.getNeedHeader().equals(entity.getNeedHeader())) {
                // 处理流程(暂不需要处理，已经在流程中处理)
            }
        }
        super.beforeUpdateEntity(entity, status);
    }

    @Override
    public void afterFinishProcess(RedheadApplyBean bean, String result) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
        statemachineService.initFSM(is, bean.getDocStatus());
        statemachineService.processFSM("通过");
        bean.setDocStatus(statemachineService.getCurrentState());
    }

    @Override
    public void beforeStartProcess(RedheadApplyBean bean) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
        statemachineService.initFSM(is, bean.getDocStatus());
        statemachineService.processFSM("审批");
        bean.setDocStatus(statemachineService.getCurrentState());
    }

    @Override
    public String getProcessKeyName() {
        return PROCESS_KEY_NAME;
    }

    @Override
    public Map getVariantMap(Map map, RedheadApplyBean bean) {
        //测试状态机
//        InputStream is = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
//        statemachineService.initFSM(is, "START");
//        String currentState = statemachineService.getCurrentState();
//        statemachineService.processFSM("MOVELEFT");
//        currentState = statemachineService.getCurrentState();

        map.put("needHeader", bean.getNeedHeader());
        return map;
    }

    public void setStatemachineService(IStatemachineService statemachineService) {
        this.statemachineService = statemachineService;
    }

    public void setDocumentBeanService(IDocumentBeanService documentBeanService) {
        this.documentBeanService = documentBeanService;
    }

    public void setDocumentConfigBeanService(IDocumentConfigBeanService documentConfigBeanService) {
        this.documentConfigBeanService = documentConfigBeanService;
    }

    public void setOaDictBeanService(IOADictBeanService oaDictBeanService) {
        this.oaDictBeanService = oaDictBeanService;
    }

    /**
     * 图表展现demo
     *
     * @param jsonStr
     * @return
     */
    public JsonData getStatisticByDocType(String jsonStr) {
        Map<String, String> jsonMap = null;
        Map<String, String> barMap = new HashMap<>();
        if (jsonStr != null && !jsonStr.isEmpty()) {
            jsonMap = SerializeUtil.json2Map(jsonStr);
        }
        QueryDTO dto = new QueryDTO();
        // select doctype,count(number) from oa_workflow_redheadapply group by doctype;
        JpaStatistic jpaStatistic = new JpaStatistic();
        jpaStatistic.setGroupBys(new String[]{"docType"});
        jpaStatistic.setSelectNotStatistics(new String[]{"docType"});
        jpaStatistic.setSelectStatistics(new String[]{"number"});
        jpaStatistic.setStatisticTypes(new JpaStatistic.Statistic[]{JpaStatistic.Statistic.COUNT});
        Map<String, String> params = jpaStatistic.getStatisticParam();
        if (jsonMap != null && !jsonMap.isEmpty()) {
            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                params.put(entry.getKey(), entry.getValue());
            }
        }
        //params.put("docType:in","5,6");
        dto.setJsonMap(params);
        JsonData data = dao.getAllByStatistic(dto);
        List<Tuple> list = data.getData();

        JsonData d1 = new JsonData();
        List<Map<String, String>> dataList = new ArrayList<>();
//        String barData = testBar(true);
        String barData = BarChart(list);

        barMap.put("option", barData);
        dataList.add(barMap);
        d1.setData(dataList);
        return d1;
    }

    /**
     * 柱状图显示demo
     *
     * @param list
     * @return
     */
    private String BarChart(List<Tuple> list) {
        String[] types = new String[list.size()];
        int[] datas = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            types[i] = String.valueOf(list.get(i).get(0));
            datas[i] = Integer.parseInt(list.get(i).get(1).toString());
        }
        String title = "红头文件分类统计";
        GsonOption option = new GsonOption();
        option.title(title); // 标题
        // 工具栏
        option.toolbox().show(true).feature(Tool.mark, // 辅助线
                Tool.dataView, // 数据视图
                new MagicType(Magic.line, Magic.bar),// 线图、柱状图切换
                Tool.restore,// 还原
                Tool.saveAsImage);// 保存为图片
        option.tooltip().show(true).formatter("{a} <br/>{b} : {c}");//显示工具提示,设置提示格式
        option.legend(title);// 图例
        Bar bar = new Bar(title);// 图类别(柱状图)
        CategoryAxis category = new CategoryAxis();// 轴分类
        category.data(types);// 轴数据类别
        // 循环数据
        for (int i = 0; i < datas.length; i++) {
            int data = datas[i];
            Map<String, Object> map = new HashMap<>();
            map.put("value", data);
            bar.data(map);
        }
        option.xAxis(category);// x轴
        option.yAxis(new ValueAxis());// y轴
        option.series(bar);
        return option.toString();
    }
}
