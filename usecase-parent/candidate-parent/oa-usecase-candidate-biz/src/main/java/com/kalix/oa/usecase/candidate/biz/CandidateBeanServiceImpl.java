package com.kalix.oa.usecase.candidate.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.oa.usecase.candidate.api.biz.ICandidateBeanService;
import com.kalix.oa.usecase.candidate.api.dao.ICandidateBeanDao;
import com.kalix.oa.usecase.candidate.api.query.CandidateDTO;
import com.kalix.oa.usecase.candidate.entities.CandidateBean;

import java.util.List;

/**
 * @类描述： 
 * @创建人：  
 * @创建时间： 
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class CandidateBeanServiceImpl extends ShiroGenericBizServiceImpl<ICandidateBeanDao, CandidateBean> implements ICandidateBeanService {
    private JsonStatus jsonStatus = new JsonStatus();
    public CandidateBeanServiceImpl() {
        super.init(CandidateBean.class.getName());
    }

    public JsonData getAllEntityByCheck(String type){
        JsonData jsonData = new JsonData();
        List<PersistentEntity> checkList;
        if(type.equals("first")) {// first 获取初试人员
            // 从应聘人员表oa_candidate和面试表oa_interview中左连接进行查询
            // 查询条件为未被初试面试的人员并且人员类别为1(行政和科研人员)或者2(专职教师)的这些人进行初试面试
            checkList = dao.findByNativeSql("select b.id,a.id as candidateId,a.xm from oa_candidate a LEFT JOIN oa_interview b on a.id = b.candidateid where (b.passfirst = false or b.passfirst is null) and (a.personcategory='1' or a.personcategory='2')", CandidateDTO.class, "");
        }else if(type.equals("second")){// second 获取复试人员
            // 从应聘人员表oa_candidate和面试表oa_interview中左连接进行查询
            // 查询条件为已经通过初试面试的人员并且人员类别为1(行政和科研人员),并且未进行复试的人员进行复试
            // 也就是说只有行政科研人员有复试，专职教师类没有复试
            checkList = dao.findByNativeSql("select b.id,a.id as candidateId,a.xm from oa_candidate a LEFT JOIN oa_interview b on a.id = b.candidateid where b.passfirst = true and (b.passSecond = false or b.passSecond is null) and a.personcategory='1'", CandidateDTO.class, "");
        }else{// lecture 获取试讲人员
            // 从应聘人员表oa_candidate和面试表oa_interview中左连接进行查询
            // 查询条件为 当人员类别2(专职教师)时，那么初试必须通过；当人员类别为3(兼职教师)，那么查还未进行试讲的人员
            // 也就是说专职教师只有一次面试，通过后可进行试讲，兼职教师可以直接试讲
            checkList = dao.findByNativeSql("select b.id,a.id as candidateId,a.xm from oa_candidate a LEFT JOIN oa_interview b on a.id = b.candidateid " +
                    "where (case a.personcategory when '2' then a.id in (select candidateid from oa_interview c where c.passfirst=true) " +
                    " when '3' then a.id not in (select candidateid from oa_lecture d where d.pass=true)" +
                    " end)", CandidateDTO.class, "");
        }

        jsonData.setTotalCount(Long.valueOf(checkList.size()));
        jsonData.setData(checkList);
        return jsonData;
    }
}
