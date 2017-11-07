package com.kalix.oa.workflow.employapply.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.web.model.BaseDTO;
import com.kalix.framework.core.util.Assert;
import com.kalix.framework.core.util.SerializeUtil;
import com.kalix.middleware.workflow.api.Const;
import com.kalix.middleware.workflow.api.exception.NotSameStarterException;
import com.kalix.middleware.workflow.api.model.WorkflowStaus;
import com.kalix.middleware.workflow.biz.WorkflowGenericBizServiceImpl;
import com.kalix.oa.usecase.candidate.api.biz.ICandidateBeanService;
import com.kalix.oa.usecase.candidate.entities.CandidateBean;
import com.kalix.oa.workflow.employapply.api.biz.IEmployApplyBeanService;
import com.kalix.oa.workflow.employapply.api.dao.IEmployApplyBeanDao;
import com.kalix.oa.workflow.employapply.api.query.EmployApplyDTO;
import com.kalix.oa.workflow.employapply.entities.EmployApplyBean;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenyanxu
 */
public class EmployApplyBeanServiceImpl extends WorkflowGenericBizServiceImpl<IEmployApplyBeanDao, EmployApplyBean> implements IEmployApplyBeanService {
    private ICandidateBeanService candidateBeanService;



    @Override
    public String getProcessKeyName() {
        return PROCESS_KEY_NAME;
    }

    /**
     * 通过招聘人员表与入职审批工作流表的关联，查询出招聘人员的人员类别，传递给工作流
     * @param map
     * @param bean
     * @return
     */
    @Override
    public Map getVariantMap(Map map, EmployApplyBean bean) {
        List<CandidateBean> candidateBeanList = candidateBeanService.getAllEntity();
        for (CandidateBean c:candidateBeanList) {
            if(c.getEmployApplyWorkflowId()!=null) {
                if (c.getEmployApplyWorkflowId() == bean.getId()) {
                    map.put("personCategory", c.getPersonCategory());
                    break;
                }
            }
        }

        return map;
    }

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr) {
        Map<String, String> jsonMap = SerializeUtil.json2Map(jsonStr);
        //获得查询的sql语句
        String sql = getNativeQueryStr();
        //获得返回的结果类
        Class<? extends BaseDTO> cls = getResultClass();
        Assert.notNull(cls, "返回查询结果类不能为空.");
        //数据安全(注释掉数据权限，已经通过数据权限功能实现)
        /*if(jsonMap.get("createById")!=null){
            sql = sql + " and a.createById=" +jsonMap.get("createById") ;
            jsonMap.remove("createById");
        }*/


        String posSql = " order by a.creationDate desc";
        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
            sql = sql + " and a." + entry.getKey() + " like '%" + entry.getValue() + "%'";
        }

        JsonData jsonData = dao.findByNativeSql(sql + posSql, page, limit, cls, null);
        List<EmployApplyDTO> list = jsonData.getData();
        for (EmployApplyDTO obj : list) {
            if (obj.getStatus() == null) {
                obj.setTitle("吉林动画学院入职申请表");
                obj.setStatus(WorkflowStaus.INACTIVE);
                obj.setAuditResult("流程尚未启动");
            }
        }
        return jsonData;
    }

    /**
     * 查询可以入职人员
     * 招聘人员表oa_candidate与入职工作流表employApplyWorkflowId关联查询
     * 当人员类别为1(行政和科研人员)时，那么需要初试面试和复试面试都通过
     * 当人员类别为2(专职教师)时，那么需要进行一次面试通过和试讲通过
     * 当人员类别为3(兼职教师)时，那么需要试讲通过
     * @return
     */
    @Override
    protected String getNativeQueryStr() {
        return "select a.id,a.personCategory,a.orgId,a.orgName,a.xm,a.sex,a.age,a.tel,a.position,a.orgId,a.orgName,a.createby," +
                "b.id as employApplyWorkflowId," +
                "b.processInstanceId," +
                "b.currentNode," +
                "b.status," +
                "b.auditResult," +
                "b.businessNo," +
                "b.branchSchoolLeader,b.schoolLeader,b.manpower,b.applydate,a.id as candidateId,b.title,a.xm as candidateName " +
                "from oa_candidate a left join oa_workflow_employapply b " +
                "on a.employApplyWorkflowId = b.id " +
                "where (case a.personcategory when '1' then a.id in (select candidateid from oa_interview c where c.passfirst=true and c.passsecond=true) " +
                "when '2' then a.id in (select d.candidateid from oa_interview d, oa_lecture e where d.candidateid=e.candidateid and d.passfirst=true and e.pass=true) " +
                "when '3' then a.id in (select candidateid from oa_lecture e where e.pass=true)" +
                "end)";
    }

    @Override
    protected Class<? extends BaseDTO> getResultClass() {
        return EmployApplyDTO.class;
    }

    @Override
    public JsonStatus startProcess(String id) {
        CandidateBean candidateBean = candidateBeanService.getEntity(Long.parseLong(id));
        if(candidateBean.getEmployApplyWorkflowId() == null || candidateBean.getEmployApplyWorkflowId() == 0){
            EmployApplyBean employApplyBean = new EmployApplyBean();
            employApplyBean.setId(0);
            employApplyBean.setOrgId(candidateBean.getOrgId());
            employApplyBean.setOrgName(candidateBean.getOrgName());
            employApplyBean.setTitle("吉林动画学院入职申请表");

            JsonStatus jsonStatus = this.saveEntity(employApplyBean);

            candidateBean.setEmployApplyWorkflowId(Long.parseLong(jsonStatus.getTag()));
            candidateBeanService.updateEntity(candidateBean);

            return startProcessSelf(jsonStatus.getTag());
        }else{
            return startProcessSelf(String.valueOf(candidateBean.getEmployApplyWorkflowId()));
        }
    }

    protected JsonStatus startProcessSelf(String id) {
        JsonStatus jsonStatus = new JsonStatus();

        jsonStatus.setSuccess(true);
        try {
            String bizKey = getProcessKeyName() + ":" + id;
            //获得当前登陆用户
            String userName = this.getShiroService().getSubject().getPrincipal().toString();
            identityService.setAuthenticatedUserId(userName);
            EmployApplyBean bean = this.getEntity(new Long(id));

            //检查流程启动人和申请人是同一个人
            if (!bean.getCreateBy().equals(this.getShiroService().getCurrentUserRealName()))
                throw new NotSameStarterException();

            //启动流程
            Map varMap = new HashMap<>();
            //put orgName to variant
            varMap.put(Const.VAR_STARTER_ORG_Name, String.valueOf(bean.getOrgName()));
            getVariantMap(varMap,bean);

            // 将人员类别varMap传递到工作流中去，用于控制流程的分支
            ProcessInstance instance = runtimeService.startProcessInstanceByKey(getProcessKeyName(),bizKey, varMap);

            Task task = taskService.createTaskQuery().processInstanceId(instance.getProcessInstanceId()).singleResult();
            //设置实体状态
            bean.setProcessInstanceId(instance.getProcessInstanceId());
            bean.setCurrentNode(task.getName());
            bean.setStatus(WorkflowStaus.ACTIVE);
            bean.setAuditResult("审批中...");
            bean.setApplyDate(new Date());
            //创建流程业务编号
            String bizNo = createBusinessNo();
            bean.setBusinessNo(bizNo);
            this.updateEntity(bean);

            runtimeService.setProcessInstanceName(instance.getId(), bizNo);

            jsonStatus.setMsg("启动流程成功！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setFailure(true);
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("启动流程失败！");
        }
        return jsonStatus;
    }

    public ICandidateBeanService getCandidateBeanService() {
        return candidateBeanService;
    }

    public void setCandidateBeanService(ICandidateBeanService candidateBeanService) {
        this.candidateBeanService = candidateBeanService;
    }
}
