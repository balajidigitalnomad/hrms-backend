package com.app.hrms.dto.response;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class  AuthenticationResponse {
    private String token;
}
