package com.app.hrms.controller;

import com.app.hrms.dto.request.UserRequestDto;
import com.app.hrms.dto.response.UserResponseDto;
import com.app.hrms.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto>  createUser(@Valid @RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok().body(userService.createUser(userRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUserById(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto){
        return ResponseEntity.ok().body(userService.updateUserById(id, userRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok().body("Delete user Successfully");
    }

    @GetMapping("/password-hash/{username}")
    public ResponseEntity<String> getPasswordHash(@PathVariable String username){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return ResponseEntity.ok().body(encoder.encode(username));

    }
}
