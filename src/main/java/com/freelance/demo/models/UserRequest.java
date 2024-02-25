package com.freelance.demo.models;


import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="user_details")
public class UserRequest {

    String firstName;
    String lastName;
    String dob;
    String address;
    String phone;
    String gender;
}
