package com.xml_project_be.xml_project.auth.controllers;

import com.xml_project_be.xml_project.auth.authForms.LoginForm;
import com.xml_project_be.xml_project.auth.authForms.RegistrationForm;
import com.xml_project_be.xml_project.auth.checkCookies.LoginCookies;
import com.xml_project_be.xml_project.auth.user.UserRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/user/auth")
@AllArgsConstructor
public class AuthController {
    public JdbcTemplate jdbcTemplate;
    private UserRepo userRepo;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login (
            @RequestBody LoginForm loginForm,
            HttpServletResponse response,
            HttpServletRequest request,
            UserRepo userRepo
    ) {
        return LoginCookies.cookiesLogin(
            loginForm.getLogin(),
            loginForm.getPassword(),
            response,
            request,
            userRepo,
            jdbcTemplate
        );
    }

    @PostMapping("/registration")
    @ResponseBody
    public ResponseEntity<?> registrationUser (
        @RequestBody RegistrationForm registrationForm,
        HttpServletResponse response
    ) {
        return userRepo.create(
            registrationForm,
            jdbcTemplate
        );
    }
}
