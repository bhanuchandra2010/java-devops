package com.freelance.demo.services;

import com.freelance.demo.models.LoginRequest;
import com.freelance.demo.models.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.http.WebSocket;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public Mono<LoginResponse> login(LoginRequest request) {

        return WebClient.create("https://reqres.in/api/login")
                .post()
                .bodyValue(request)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(LoginResponse.class);
    }
}
