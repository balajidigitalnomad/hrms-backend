package com.app.hrms.mapper;

import com.app.hrms.dto.DesignationDto;
import com.app.hrms.entity.Designation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel =  "spring")
public interface DesignationMapper {
    Designation toEntity(DesignationDto designationDto);
    DesignationDto toDto(Designation designation);
    void updateEntity(DesignationDto designationDto, @MappingTarget Designation designation);

}
