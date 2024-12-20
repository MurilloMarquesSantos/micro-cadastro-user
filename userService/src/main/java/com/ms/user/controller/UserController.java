package com.ms.user.controller;

import com.ms.user.domain.User;
import com.ms.user.domain.dto.UserDto;
import com.ms.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
}
