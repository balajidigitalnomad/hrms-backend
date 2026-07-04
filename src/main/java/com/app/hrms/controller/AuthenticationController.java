package com.app.hrms.controller;

import com.app.hrms.dto.request.AuthenticationRequest;
import com.app.hrms.dto.response.AuthenticationResponse;
import com.app.hrms.security.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody AuthenticationRequest authRequest) {
        return ResponseEntity.ok(authenticationService.login(authRequest));
    }
}
