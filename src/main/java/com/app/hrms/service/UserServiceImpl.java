package com.app.hrms.service;

import com.app.hrms.dto.request.UserRequestDto;
import com.app.hrms.dto.response.UserResponseDto;
import com.app.hrms.entity.User;
import com.app.hrms.exception.ResourceNotFoundException;
import com.app.hrms.mapper.UserMapper;
import com.app.hrms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto  userRequestDto) {
        return userMapper.toUserResponseDto(userRepository.save(userMapper.toEntity(userRequestDto)));
    }

    @Override
    public UserResponseDto updateUserById(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id", id));
        userMapper.updateEntity(userRequestDto,user);
        return userMapper.toUserResponseDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id", id));
        return userMapper.toUserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers(){
        return userRepository.findAll().stream().map(userMapper::toUserResponseDto).toList();
    }

    @Override
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
