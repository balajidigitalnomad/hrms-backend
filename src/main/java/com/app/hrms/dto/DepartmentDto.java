package com.app.hrms.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class  DepartmentDto {
    private Long departmentId;
    private String departmentCode;
    private String departmentName;
    private Boolean isActive;
}
