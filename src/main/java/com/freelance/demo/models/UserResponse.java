package com.freelance.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    String userId;
    String firstName;
    String lastName;
    String dob;
    String address;
    String phone;
    String gender;
}
