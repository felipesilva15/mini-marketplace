package io.github.felipesilva15.marketplace.auth.controller;

import java.util.List;

import io.github.felipesilva15.marketplace.auth.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.felipesilva15.marketplace.auth.dto.UserRequest;
import io.github.felipesilva15.marketplace.auth.mapper.UserMapper;
import io.github.felipesilva15.marketplace.auth.model.User;
import io.github.felipesilva15.marketplace.auth.service.UserService;
import jakarta.validation.Valid;



@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request){
         User user = userService.create(userMapper.toModel(request));
         UserResponse response = userMapper.toResponse(user);

         return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll(){
        List<User> users = userService.findAll();
        List<UserResponse> response = userMapper.toResponseList(users);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
