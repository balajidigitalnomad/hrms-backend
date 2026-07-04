package com.app.hrms.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Service;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
