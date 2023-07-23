package com.hms.demo.service;

import com.hms.demo.model.Authority;
import com.hms.demo.web.dto.request.AuthorityReq;

import java.util.List;

public interface AuthorityService {
    void createAuthority(AuthorityReq authorityReq);

    List<Authority> getAuthorities();

    void updateAuthority(Integer authorityId, AuthorityReq authorityReq);

    void deleteAuthority(Integer authorityId);
}
