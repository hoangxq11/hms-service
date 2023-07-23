package com.hms.demo.service.impl;

import com.hms.demo.model.Authority;
import com.hms.demo.repository.AuthorityRepository;
import com.hms.demo.service.AuthorityService;
import com.hms.demo.service.utils.MappingHelper;
import com.hms.demo.web.dto.request.AuthorityReq;
import com.hms.demo.web.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository authorityRepository;
    private final MappingHelper mappingHelper;

    @Override
    public void createAuthority(AuthorityReq authorityReq) {
        authorityRepository.save(mappingHelper.map(authorityReq, Authority.class));
    }

    @Override
    public List<Authority> getAuthorities() {
        return authorityRepository.findAll();
    }

    @Override
    public void updateAuthority(Integer authorityId, AuthorityReq authorityReq) {
        var authority = authorityRepository.findById(authorityId)
                .orElseThrow(() -> new EntityNotFoundException(Authority.class.getName(), authorityId.toString()));
        mappingHelper.copyProperties(authorityReq, authority);
        authorityRepository.save(authority);
    }

    @Override
    public void deleteAuthority(Integer authorityId) {
        authorityRepository.deleteById(authorityId);
    }
}
