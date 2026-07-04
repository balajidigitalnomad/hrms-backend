package com.app.hrms.mapper;

import com.app.hrms.dto.request.EmployeeRequestDto;
import com.app.hrms.dto.response.EmployeeResponseDto;
import com.app.hrms.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "department",ignore =true)
    @Mapping(target = "designation", ignore = true)
    Employee toEntity(EmployeeRequestDto employeeRequestDto); // obj to entity

    @Mapping(target = "departmentId", source = "department.departmentId")
    @Mapping(target = "departmentName", source ="department.departmentName")
    @Mapping(target = "designationId", source ="designation.designationId")
    @Mapping(target = "designationName", source ="designation.designationName")
    EmployeeResponseDto toDto(Employee employee);

    @Mapping(target = "department", ignore = true)
    @Mapping(target = "designation", ignore = true)
    void updateEntity(EmployeeRequestDto employeeRequestDto, @MappingTarget Employee employee);
}
