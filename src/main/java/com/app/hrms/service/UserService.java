package com.app.hrms.service;

import com.app.hrms.dto.request.UserRequestDto;
import com.app.hrms.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userDto);
    UserResponseDto updateUserById(Long id, UserRequestDto userDto);
    UserResponseDto getUserById(Long Id);
    List<UserResponseDto> getAllUsers();
    void deleteUserById(Long id);
}
