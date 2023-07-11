package com.freelance.demo.services;

import com.freelance.demo.models.LoginRequest;
import com.freelance.demo.models.LoginResponse;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<LoginResponse> login(LoginRequest request);
}
