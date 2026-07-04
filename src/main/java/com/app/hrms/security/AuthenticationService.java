package com.app.hrms.security;

import com.app.hrms.dto.request.AuthenticationRequest;
import com.app.hrms.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
}
