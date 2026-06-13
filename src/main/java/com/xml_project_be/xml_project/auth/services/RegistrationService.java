package com.xml_project_be.xml_project.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xml_project_be.xml_project.auth.dto.Auth;
import com.xml_project_be.xml_project.auth.repositories.UserRepo;

@Service
public class RegistrationService {
    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<?> create(Auth auth) {
        return userRepo.create(auth);
    }
}
