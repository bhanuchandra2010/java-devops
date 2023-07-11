package com.freelance.demo.services;

import com.freelance.demo.models.LoginRequest;
import com.freelance.demo.models.LoginResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public Mono<LoginResponse> login(LoginRequest request) {
        return Mono.just(new LoginResponse());
    }
}
