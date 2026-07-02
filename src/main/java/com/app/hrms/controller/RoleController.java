package com.app.hrms.controller;

import com.app.hrms.dto.RoleDto;
import com.app.hrms.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleDto> createRole(@Valid @RequestBody RoleDto roleDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.createRole(roleDto));
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable Long id) {
        return ResponseEntity.ok().body(roleService.getRoleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> updateRoleById(@PathVariable Long id, @RequestBody RoleDto roleDto) {
        return ResponseEntity.ok().body(roleService.updateRoleById(id, roleDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoleById(@PathVariable Long id) {
        roleService.deleteRoleById(id);
        return ResponseEntity.ok().body("Role deleted");
    }

}
