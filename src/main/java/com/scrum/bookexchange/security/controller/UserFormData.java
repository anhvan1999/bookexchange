package com.scrum.bookexchange.security.controller;

import lombok.Data;

@Data
public class UserFormData {

    private String email;

    private String password;

    private String schoolName;

    private String studentId;

    private String fullName;

    private String phoneNumber;
    
}
