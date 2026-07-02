package com.app.hrms.security;

import com.app.hrms.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final User user;

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    @Override
    public String getPassword(){
        return user.getPassword();
    }


}
