package sringboot.garderobapp.mappers;

import org.mapstruct.Mapper;
import sringboot.garderobapp.dto.request.UserRequestDto;
import sringboot.garderobapp.dto.response.UserResponseDto;
import sringboot.garderobapp.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToModel(UserRequestDto requestDto);
    UserResponseDto mapToDto(User user);
}
