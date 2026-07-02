package com.app.hrms.mapper;


import com.app.hrms.dto.request.UserRequestDto;
import com.app.hrms.dto.response.UserResponseDto;
import com.app.hrms.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto toUserResponseDto(User user);
    User toEntity(UserRequestDto userRequestDto);
    void updateEntity(UserRequestDto userRequestDto, @MappingTarget User user);
}
