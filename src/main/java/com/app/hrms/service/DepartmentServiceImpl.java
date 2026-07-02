package com.app.hrms.service;

import com.app.hrms.dto.DepartmentDto;
import com.app.hrms.entity.Department;
import com.app.hrms.exception.ResourceNotFoundException;
import com.app.hrms.mapper.DepartmentMapper;
import com.app.hrms.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        return departmentMapper.toDto(departmentRepository.save(departmentMapper.toEntity(departmentDto)));
    }

    @Override
    public DepartmentDto updateDepartmentById(Long id, DepartmentDto departmentDto) {
        Department department = departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department not found with id", id));
        departmentMapper.updateEntity(departmentDto, department);
        return departmentMapper.toDto(departmentRepository.save(department));
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Department not found with id", id));
        return departmentMapper.toDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll().stream().map(departmentMapper::toDto).toList();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

}
