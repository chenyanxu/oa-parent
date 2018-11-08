package com.kalix.oa.usecase.candidate.api.query;

import com.kalix.framework.core.api.web.model.QueryDTO;

/**
 * Created by zangyanming on 2016/06/21.
 */
public class CandidateDTO extends QueryDTO {
    private String id;
    private String xm;
    private String candidateId;

    public String getXm() {
        return xm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }
}