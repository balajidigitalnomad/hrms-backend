package com.app.hrms.controller;

import com.app.hrms.dto.request.EmployeeRequestDto;
import com.app.hrms.dto.response.EmployeeResponseDto;
import com.app.hrms.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> updateEmployeeById(@RequestBody EmployeeRequestDto employeeRequestDto, @PathVariable Long id) {
        return ResponseEntity.ok().body(employeeService.updateEmployeeById(id, employeeRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().body("Employee deleted");
    }


}
