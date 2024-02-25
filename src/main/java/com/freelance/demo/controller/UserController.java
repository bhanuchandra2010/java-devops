package com.freelance.demo.controller;

import com.freelance.demo.models.LoginRequest;
import com.freelance.demo.models.LoginResponse;
import com.freelance.demo.models.UserRequest;
import com.freelance.demo.models.UserResponse;
import com.freelance.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<LoginResponse>> login(@RequestBody LoginRequest request) {
        return userService.login(request)
                .map(ResponseEntity::ok)
                .onErrorReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<UserResponse>> save(UserRequest request) {
        return userService.save(request)
                .map(ResponseEntity::ok)
                .onErrorReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/files:get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<String>> getFiles() throws GeneralSecurityException, IOException {
        return userService.getfiles()
                .map(ResponseEntity::ok)
                .onErrorReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }

}
