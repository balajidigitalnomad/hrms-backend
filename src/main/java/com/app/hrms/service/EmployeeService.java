package com.app.hrms.service;

import com.app.hrms.dto.request.EmployeeRequestDto;
import com.app.hrms.dto.response.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto updateEmployeeById(Long id, EmployeeRequestDto employeeRequestDto);
    EmployeeResponseDto getEmployeeById(Long id);
    List<EmployeeResponseDto> getAllEmployees();
    void deleteEmployeeById(Long id);
}
