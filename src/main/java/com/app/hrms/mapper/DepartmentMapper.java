package com.app.hrms.mapper;

import com.app.hrms.dto.DepartmentDto;
import com.app.hrms.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel ="spring")
public interface DepartmentMapper {
    Department toEntity(DepartmentDto departmentDto);
    DepartmentDto toDto(Department department);
    void updateEntity(DepartmentDto departmentDto, @MappingTarget Department department);
}
