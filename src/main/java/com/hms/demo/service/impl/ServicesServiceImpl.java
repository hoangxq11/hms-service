package com.hms.demo.service.impl;

import com.hms.demo.model.MedicalDepartment;
import com.hms.demo.model.Services;
import com.hms.demo.repository.MedicalDepartmentRepository;
import com.hms.demo.repository.ServicesRepository;
import com.hms.demo.service.ServicesService;
import com.hms.demo.service.utils.MappingHelper;
import com.hms.demo.web.dto.ServicesDto;
import com.hms.demo.web.dto.request.ServicesReq;
import com.hms.demo.web.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServicesService {
    private final ServicesRepository servicesRepository;
    private final MedicalDepartmentRepository departmentRepository;
    private final MappingHelper mappingHelper;

    @Override
    public List<ServicesDto> getAllServices() {
        return servicesRepository.findAll().stream()
                .map(e -> mappingHelper.map(e, ServicesDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ServicesDto getServicesById(Integer id) {
        var res = servicesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Services.class.getName()
                        , id.toString()));
        return mappingHelper.map(res, ServicesDto.class);
    }

    @Override
    public void createServices(ServicesReq servicesReq) {
        var department = departmentRepository.findById(servicesReq.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException(MedicalDepartment.class.getName()
                        , servicesReq.getDepartmentId().toString()));
        var res = mappingHelper.map(servicesReq, Services.class);
        res.setDepartment(department);
        servicesRepository.save(res);
    }

    @Override
    public void updateServices(Integer id, ServicesReq servicesReq) {
        var Services = servicesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Services.class.getName()
                        , id.toString()));
        var department = departmentRepository.findById(servicesReq.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException(MedicalDepartment.class.getName()
                        , servicesReq.getDepartmentId().toString()));
        mappingHelper.copyProperties(servicesReq, Services);
        Services.setDepartment(department);
        servicesRepository.save(Services);
    }

    @Override
    public void removeServices(Integer id) {
        servicesRepository.deleteById(id);
    }

    @Override
    public List<ServicesDto> getServicesByDepartment(Integer departmentId) {
        return servicesRepository.findByDepartment_Id(departmentId)
                .stream().map(e -> mappingHelper.map(e, ServicesDto.class))
                .collect(Collectors.toList());
    }
}
