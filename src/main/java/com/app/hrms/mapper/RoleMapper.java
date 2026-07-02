package com.app.hrms.mapper;

import com.app.hrms.dto.RoleDto;
import com.app.hrms.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toEntity(RoleDto roleDto);
    RoleDto toDto(Role role);
    void updateEntity(RoleDto roleDto, @MappingTarget Role role);
}
