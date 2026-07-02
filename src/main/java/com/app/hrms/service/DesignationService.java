package com.app.hrms.service;

import com.app.hrms.dto.DesignationDto;

import java.util.List;

public interface DesignationService {
    DesignationDto createDesignation(DesignationDto designationDto);
    DesignationDto updateDesignationById(Long id, DesignationDto designationDto);
    DesignationDto getDesignationById(Long id);
    List<DesignationDto> getAllDesignations();
    void deleteDesignationById(Long id);
}
