package com.app.hrms.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DesignationDto {
    private Long designationId;
    private String designationCode;
    private String designationName;
    private Boolean isActive;
}
