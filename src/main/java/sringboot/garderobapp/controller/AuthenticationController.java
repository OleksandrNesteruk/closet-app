package sringboot.garderobapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sringboot.garderobapp.dto.request.UserRequestDto;
import sringboot.garderobapp.dto.response.UserResponseDto;
import sringboot.garderobapp.mappers.UserMapper;
import sringboot.garderobapp.model.User;
import sringboot.garderobapp.service.AuthenticationService;
import javax.validation.Valid;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    @PostMapping
    public UserResponseDto register(@Valid @RequestBody UserRequestDto requestDto) {
        User user = authenticationService
                .register(requestDto.getEmail(),
                        requestDto.getPassword(),
                        requestDto.getFirstName(),
                        requestDto.getLastName());
        return userMapper.mapToDto(user);
    }
}
