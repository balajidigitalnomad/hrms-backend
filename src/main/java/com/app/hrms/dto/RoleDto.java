package com.app.hrms.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDto {
    private Long id;
    private String roleId;
    private String roleName;
    private Boolean active;
}
