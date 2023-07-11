package com.freelance.demo.controller;

import com.freelance.demo.models.LoginRequest;
import com.freelance.demo.models.LoginResponse;
import com.freelance.demo.services.UserService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

@RestController
public class UserController {


    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<LoginResponse>> login(@RequestBody LoginRequest request) {
        return userService.login(request)
                .map(ResponseEntity::ok)
                .onErrorReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
