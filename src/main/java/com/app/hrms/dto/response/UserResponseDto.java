package com.app.hrms.dto.response;

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
public class UserResponseDto {
    @NotBlank
    private Long  id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private Boolean enabled;

    @NotNull
    private Boolean accountNonLocked;

    @NotNull
    private Boolean accountNonExpired;

    @NotNull
    private Boolean credentialsNonExpired;

    private Long employeeId;

    private Set<Long> roleIds;

    private Boolean isActive;
}
