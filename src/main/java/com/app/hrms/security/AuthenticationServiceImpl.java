package com.app.hrms.security;

import com.app.hrms.dto.request.AuthenticationRequest;
import com.app.hrms.dto.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public AuthenticationResponse login(AuthenticationRequest authRequest){
     authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),
                authRequest.getPassword()
             )
     );
     UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
     String token = jwtService.generateToken(userDetails);

     return AuthenticationResponse.builder()
             .token(token)
             .build();
    }
}
