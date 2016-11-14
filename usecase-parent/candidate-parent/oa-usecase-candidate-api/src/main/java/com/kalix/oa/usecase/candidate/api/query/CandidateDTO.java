package com.kalix.oa.usecase.candidate.api.query;

import com.kalix.framework.core.api.web.model.QueryDTO;

/**
 * Created by zangyanming on 2016/06/21.
 */
public class CandidateDTO extends QueryDTO {
    private Long id;
    private String xm;
    private Long candidateId;

    public String getXm() {
        return xm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }
}