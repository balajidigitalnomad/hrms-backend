package com.app.hrms.service;

import com.app.hrms.dto.request.EmployeeRequestDto;
import com.app.hrms.dto.response.EmployeeResponseDto;
import com.app.hrms.entity.Employee;
import com.app.hrms.exception.ResourceNotFoundException;
import com.app.hrms.mapper.EmployeeMapper;
import com.app.hrms.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
        return employeeMapper.toDto(employeeRepository.save(employeeMapper.toEntity(employeeRequestDto)));
    }

    @Override
    public EmployeeResponseDto updateEmployeeById(Long id, EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with id", id));
        employeeMapper.updateEntity(employeeRequestDto,employee);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with id", id));
        return employeeMapper.toDto(employee);
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees(){
        return employeeRepository.findAll().stream().map(employeeMapper::toDto).toList();
    }

    @Override
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }
}
