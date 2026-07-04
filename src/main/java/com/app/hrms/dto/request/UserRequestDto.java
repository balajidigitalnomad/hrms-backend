package com.app.hrms.dto.request;


import com.app.hrms.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Builder.Default
    private Boolean enabled = true;

    @NotNull
    private Boolean accountNonLocked;

    @NotNull
    private Boolean accountNonExpired;

    @NotNull
    private Boolean credentialsNonExpired;

    private Long employeeId;

    private Set<Long> roleIds;

    @Builder.Default
    private Boolean isActive = true;
}
