package com.hms.demo.service;

import com.hms.demo.web.dto.ServicesDto;
import com.hms.demo.web.dto.request.ServicesReq;

import java.util.List;

public interface ServicesService {
    List<ServicesDto> getAllServices();

    ServicesDto getServicesById(Integer id);

    void createServices(ServicesReq servicesReq);

    void updateServices(Integer id, ServicesReq servicesReq);

    void removeServices(Integer id);

    List<ServicesDto> getServicesByDepartment(Integer departmentId);
}
