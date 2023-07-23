package com.hms.demo.service.impl;

import com.hms.demo.model.Expertise;
import com.hms.demo.repository.ExpertiseRepository;
import com.hms.demo.service.ExpertiseService;
import com.hms.demo.service.utils.MappingHelper;
import com.hms.demo.web.dto.request.ExpertiseReq;
import com.hms.demo.web.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExpertiseServiceImpl implements ExpertiseService {
    private final ExpertiseRepository expertiseRepository;
    private final MappingHelper mappingHelper;

    @Override
    public List<Expertise> getAllExpertise() {
        return expertiseRepository.findAll();
    }

    @Override
    public Expertise getExpertiseById(Integer id) {
        return expertiseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Expertise.class.getName()
                        , id.toString()));
    }

    @Override
    public void createExpertise(ExpertiseReq expertiseReq) {
        var res = mappingHelper.map(expertiseReq, Expertise.class);
        expertiseRepository.save(res);
    }

    @Override
    public void updateExpertise(Integer id, ExpertiseReq expertiseReq) {
        var expertise = expertiseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Expertise.class.getName()
                        , id.toString()));
        mappingHelper.copyProperties(expertiseReq, expertise);
        expertiseRepository.save(expertise);
    }

    @Override
    public void removeExpertise(Integer id) {
        expertiseRepository.deleteById(id);
    }
}
