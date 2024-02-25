package com.freelance.demo.services;

import com.freelance.demo.models.LoginRequest;
import com.freelance.demo.models.LoginResponse;
import com.freelance.demo.models.UserRequest;
import com.freelance.demo.models.UserResponse;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface UserService {
    Mono<LoginResponse> login(LoginRequest request);
    Mono<UserResponse> save(UserRequest request);
    Mono<String> getfiles() throws IOException, GeneralSecurityException;
}
