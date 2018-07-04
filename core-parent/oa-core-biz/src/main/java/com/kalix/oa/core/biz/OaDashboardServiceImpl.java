package com.kalix.oa.core.biz;

import com.kalix.framework.core.api.biz.IDashboardService;
import com.kalix.framework.core.api.dto.PanelGroupDTO;
import com.kalix.framework.core.api.dto.PieSeriesDataDTO;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.DashboardServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:
 * 类描述:    oa-dashboard服务实现类
 * 创建人:    hqj
 * 创建时间:  2018/6/27
 * 修改人:
 * 修改时间:
 * 修改备注:  [说明本次修改内容]
 */
public class OaDashboardServiceImpl extends DashboardServiceImpl implements IDashboardService {

    @Override
    public JsonData getPanelGroupData() {
        JsonData jsonData = new JsonData();
        List<PanelGroupDTO> list = new ArrayList<PanelGroupDTO>();
        PanelGroupDTO panelGroupDTO = new PanelGroupDTO();
        panelGroupDTO.setKey("test1");
        panelGroupDTO.setIconName("peoples");
        panelGroupDTO.setText("aaa");
        panelGroupDTO.setEndVal(102400);
        panelGroupDTO.setDuration(2600);

        list.add(panelGroupDTO);

        panelGroupDTO = new PanelGroupDTO();
        panelGroupDTO.setKey("test2");
        panelGroupDTO.setIconName("message");
        panelGroupDTO.setText("bbb");
        panelGroupDTO.setEndVal(81212);
        panelGroupDTO.setDuration(3000);
        list.add(panelGroupDTO);

        panelGroupDTO = new PanelGroupDTO();
        panelGroupDTO.setKey("aaa");
        panelGroupDTO.setIconName("money");
        panelGroupDTO.setText("Purchases");
        panelGroupDTO.setEndVal(9280);
        panelGroupDTO.setDuration(3200);
        list.add(panelGroupDTO);

        jsonData.setTotalCount(3L);
        jsonData.setData(list);
        return jsonData;
    }

    @Override
    public List<Integer> getLineChartBizData(String chartKey, String legend) {
        return super.getLineChartBizData(chartKey, legend);
    }

    @Override
    public List<Integer> getRaddarChartBizData(String chartKey, String legend) {
        return super.getRaddarChartBizData(chartKey, legend);
    }

    @Override
    public List<PieSeriesDataDTO> getPieChartBizData(String chartKey) {
        return super.getPieChartBizData(chartKey);
    }

    @Override
    public List<Integer> getBarChartBizData(String chartKey, String legend) {
        return super.getBarChartBizData(chartKey, legend);
    }
}
