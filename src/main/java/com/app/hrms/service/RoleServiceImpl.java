package com.app.hrms.service;

import com.app.hrms.dto.RoleDto;
import com.app.hrms.entity.Role;
import com.app.hrms.exception.ResourceNotFoundException;
import com.app.hrms.mapper.RoleMapper;
import com.app.hrms.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        return roleMapper.toDto(roleRepository.save(roleMapper.toEntity(roleDto)));
    }

    @Override
    public RoleDto updateRoleById(Long id, RoleDto roleDto) {
        Role role = roleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Role not found with id", id));
        roleMapper.updateEntity(roleDto,role);
        return roleMapper.toDto(roleRepository.save(role));
    }

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Role not found with id", id));
        return roleMapper.toDto(role);
    }

    @Override
    public List<RoleDto> getAllRoles(){
        return roleRepository.findAll().stream().map(roleMapper::toDto).toList();
    }


    @Override
    public void deleteRoleById(Long id){
        roleRepository.deleteById(id);
    }
}
