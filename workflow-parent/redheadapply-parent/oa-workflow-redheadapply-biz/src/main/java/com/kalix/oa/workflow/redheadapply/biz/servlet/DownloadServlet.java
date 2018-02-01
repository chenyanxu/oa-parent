package com.kalix.oa.workflow.redheadapply.biz.servlet;

import com.kalix.admin.template.api.biz.ITemplateBeanService;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.oa.workflow.redheadapply.api.biz.IRedheadApplyBeanService;
import com.kalix.oa.workflow.redheadapply.entities.RedheadApplyBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/31.
 */
public class DownloadServlet extends HttpServlet {
    private IRedheadApplyBeanService redheadApplyBeanService;
    private ITemplateBeanService templateBeanService;
    private static final String REDHEAD_TEMPLATE_NAME = "红头文件下载模板";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String redheadId = req.getParameter("redheadid") == null ? "" : req.getParameter("redheadid");
            String content = "";
            String fileName = "";
            long id = Long.parseLong(redheadId);
            RedheadApplyBean redheadApplyBean = redheadApplyBeanService.getEntity(id);
            if (redheadApplyBean != null) {
                content = redheadApplyBean.getDocContent();
                fileName = redheadApplyBean.getTitle() + ".doc";
            }
            if (StringUtils.isEmpty(fileName)) {
                fileName = "吉林动画学院红头文件样例.doc";
            }
            // 根据模板生成文件内容
            Map<String, String> map = new HashMap<>();
            map.put("a", content);
            String fileContent = templateBeanService.getTemplateResult(REDHEAD_TEMPLATE_NAME, map);

            // 输出文件
            byte b[] = fileContent.getBytes("GB2312");
            resp.setCharacterEncoding("utf-8");
            // 导出word格式("application/x-msdownloadoctet-stream;charset=utf-8")
            resp.setContentType("application/msword");
            resp.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            OutputStream out = resp.getOutputStream();
            out.write(b);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRedheadApplyBeanService(IRedheadApplyBeanService redheadApplyBeanService) {
        this.redheadApplyBeanService = redheadApplyBeanService;
    }

    public void setTemplateBeanService(ITemplateBeanService templateBeanService) {
        this.templateBeanService = templateBeanService;
    }
}
