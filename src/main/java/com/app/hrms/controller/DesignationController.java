package com.app.hrms.controller;

import com.app.hrms.dto.DesignationDto;
import com.app.hrms.service.DesignationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/designations")
@RequiredArgsConstructor
public class DesignationController {
    private final DesignationService designationService;

    @PostMapping
    public ResponseEntity<DesignationDto> createDesignation(@Valid @RequestBody DesignationDto designationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(designationService.createDesignation(designationDto));
    }

    @GetMapping
    public ResponseEntity<List<DesignationDto>> getAllDesignations() {
        return ResponseEntity.ok().body(designationService.getAllDesignations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesignationDto> getDesignationById(@PathVariable Long id) {
        return ResponseEntity.ok().body(designationService.getDesignationById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesignationDto> updateDesignationById(@PathVariable Long id, @RequestBody DesignationDto designationDto) {
        return ResponseEntity.ok().body(designationService.updateDesignationById(id, designationDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDesignationById(@PathVariable Long id) {
        designationService.deleteDesignationById(id);
        return ResponseEntity.ok().body("Designation deleted");
    }
}
