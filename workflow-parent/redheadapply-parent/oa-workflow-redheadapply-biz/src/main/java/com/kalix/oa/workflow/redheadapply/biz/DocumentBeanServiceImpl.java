package com.kalix.oa.workflow.redheadapply.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.middleware.statemachine.api.biz.IStatemachineService;
import com.kalix.oa.workflow.redheadapply.api.biz.IDocumentBeanService;
import com.kalix.oa.workflow.redheadapply.api.biz.IRedheadApplyBeanService;
import com.kalix.oa.workflow.redheadapply.api.dao.IDocumentBeanDao;
import com.kalix.oa.workflow.redheadapply.entities.DocumentBean;
import com.kalix.oa.workflow.redheadapply.entities.RedheadApplyBean;

import javax.transaction.Transactional;
import java.io.InputStream;


/**
 * @author sunlf
 */
public class DocumentBeanServiceImpl extends ShiroGenericBizServiceImpl<IDocumentBeanDao, DocumentBean> implements IDocumentBeanService {
    private IStatemachineService statemachineService;
    private IRedheadApplyBeanService redheadApplyBeanService;

    @Override
    public DocumentBean getMinEntity(Integer docType, String year, String status) {
        return this.dao.getMinEntity(docType, year, status);
    }

    @Override
    public DocumentBean getEntityByBusinessNo(String businessNo) {
        return this.dao.getEntityByBusinessNo(businessNo);
    }

    @Override
    @Transactional
    public JsonStatus abolishBusinessNo(Long id) {
        JsonStatus jsonStatus = new JsonStatus();
        jsonStatus.setSuccess(true);
        try {
            DocumentBean documentBean = this.getEntity(id);
            RedheadApplyBean redheadApplyBean = redheadApplyBeanService.getEntity(documentBean.getRedheadId());
            // 判断文件使用状态（处于工作流中和工作流结束）
            if (redheadApplyBean.getDocStatus().equals("审批中")){
                // 处于工作流中，调用停止工作流服务
            }

            // 修改文件使用状态
            InputStream isRedhead = this.getClass().getClassLoader().getResourceAsStream("redhead-state.xml");
            statemachineService.initFSM(isRedhead, redheadApplyBean.getDocStatus());
            statemachineService.processFSM("废除");
            redheadApplyBean.setDocStatus(statemachineService.getCurrentState());
            redheadApplyBeanService.updateEntity(redheadApplyBean);

            // 修改文号状态
            // 要求初始状态必须[使用中]才能[废除],否则会出错
            InputStream isDocument = this.getClass().getClassLoader().getResourceAsStream("document-state.xml");
            statemachineService.initFSM(isDocument, documentBean.getStatus());
            statemachineService.processFSM("废除");
            documentBean.setStatus(statemachineService.getCurrentState());
            this.updateEntity(documentBean);

            jsonStatus.setMsg("文号废除成功!");
        }
        catch (Exception e) {
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("文号删除失败,原因:" + e.getMessage());
            e.printStackTrace();
        }
        return jsonStatus;
    }

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        return dao.getAllRelations(page, limit, jsonStr, sort);
    }

    public void setStatemachineService(IStatemachineService statemachineService) {
        this.statemachineService = statemachineService;
    }

    public void setRedheadApplyBeanService(IRedheadApplyBeanService redheadApplyBeanService) {
        this.redheadApplyBeanService = redheadApplyBeanService;
    }
}
