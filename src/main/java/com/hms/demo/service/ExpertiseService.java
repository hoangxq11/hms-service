package com.hms.demo.service;

import com.hms.demo.model.Expertise;
import com.hms.demo.web.dto.request.ExpertiseReq;

import java.util.List;

public interface ExpertiseService {

    List<Expertise> getAllExpertise();

    Expertise getExpertiseById(Integer id);

    void createExpertise(ExpertiseReq expertiseReq);

    void updateExpertise(Integer id, ExpertiseReq expertiseReq);

    void removeExpertise(Integer id);
}