package com.app.hrms.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {
    private Long roleId;
    private String roleName;
    private Boolean isActive;
}
