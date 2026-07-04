package com.app.hrms.service;

import com.app.hrms.dto.request.UserRequestDto;
import com.app.hrms.dto.response.UserResponseDto;
import com.app.hrms.entity.Role;
import com.app.hrms.entity.User;
import com.app.hrms.exception.ResourceNotFoundException;
import com.app.hrms.mapper.UserMapper;
import com.app.hrms.repository.RoleRepository;
import com.app.hrms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserResponseDto createUser(UserRequestDto  userRequestDto) {
        Set<Role> roles = new HashSet<>(roleRepository.findAllById(userRequestDto.getRoleIds()));
        userRequestDto.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        User user = userMapper.toEntity(userRequestDto);
        user.setRoles(roles);
        return userMapper.toUserResponseDto(userRepository.save(user));
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
