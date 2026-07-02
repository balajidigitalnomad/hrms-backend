package com.app.hrms.service;

import com.app.hrms.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto updateDepartmentById(Long id, DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long id);
    List<DepartmentDto> getAllDepartments();
    void deleteDepartmentById(Long id);
}
