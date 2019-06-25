package com.entity;

import java.util.Date;

public class AuthenticationInfo {
    private Integer id;

    private Integer certifiedUserId;

    private Integer authenticatorId;

    private Date certifieTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCertifiedUserId() {
        return certifiedUserId;
    }

    public void setCertifiedUserId(Integer certifiedUserId) {
        this.certifiedUserId = certifiedUserId;
    }

    public Integer getAuthenticatorId() {
        return authenticatorId;
    }

    public void setAuthenticatorId(Integer authenticatorId) {
        this.authenticatorId = authenticatorId;
    }

    public Date getCertifieTime() {
        return certifieTime;
    }

    public void setCertifieTime(Date certifieTime) {
        this.certifieTime = certifieTime;
    }
}