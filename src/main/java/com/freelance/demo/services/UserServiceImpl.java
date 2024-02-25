package com.freelance.demo.services;

import com.freelance.demo.models.LoginRequest;
import com.freelance.demo.models.LoginResponse;
import com.freelance.demo.models.UserRequest;
import com.freelance.demo.models.UserResponse;
import com.freelance.demo.repository.UserRepository;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    GoogleDriveService driveService;

    @Override
    public Mono<LoginResponse> login(LoginRequest request) {

        return WebClient.create("https://reqres.in/api/login")
                .post()
                .bodyValue(request)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(LoginResponse.class);
    }

    @Override
    public Mono<UserResponse> save(UserRequest request) {
        return null;
    }

    @Override
    public Mono<String> getfiles() throws IOException, GeneralSecurityException {

        Drive service = driveService.instance;
        if (service == null) service = driveService.getInstance();


        // Print the names and IDs for up to 10 files.
        FileList result = service.files().list()
                .setPageSize(10)
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
            return Mono.just("No files found.");
        } else {
            return Mono.just(files.toString());
        }
    }
}
