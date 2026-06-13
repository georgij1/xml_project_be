package com.xml_project_be.xml_project.auth.controllers;

import com.xml_project_be.xml_project.auth.dto.Auth;
import com.xml_project_be.xml_project.auth.services.LoginService;
import com.xml_project_be.xml_project.auth.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/user/auth")
public class AuthController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login (
        @RequestBody Auth loginForm
    ) {
        return loginService.login(loginForm);
    }

    @PostMapping("/registration")
    @ResponseBody
    public ResponseEntity<?> registrationUser (@RequestBody Auth auth) {
        return registrationService.create(auth);
    }
}
