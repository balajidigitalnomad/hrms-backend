package com.app.hrms.service;

import com.app.hrms.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto createRole(RoleDto roleDto);
    RoleDto updateRoleById(Long id, RoleDto roleDto);
    RoleDto getRoleById(Long Id);
    List<RoleDto> getAllRoles();
    void deleteRoleById(Long id);
}
