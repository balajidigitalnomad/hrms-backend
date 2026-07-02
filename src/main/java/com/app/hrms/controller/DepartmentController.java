package com.app.hrms.controller;

import com.app.hrms.dto.DepartmentDto;
import com.app.hrms.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        departmentService.createDepartment(departmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> updateDepartmentById(@PathVariable Long id,@Valid @RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.updateDepartmentById(id, departmentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.ok().body("Department deleted");
    }
}
