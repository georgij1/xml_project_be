package com.xml_project_be.xml_project.auth.Controllers;

import com.xml_project_be.xml_project.auth.dto.Auth;
import com.xml_project_be.xml_project.auth.repositories.UserRepo;
import com.xml_project_be.xml_project.auth.services.LoginService;
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
            @RequestBody Auth loginForm,
            HttpServletResponse response,
            HttpServletRequest request,
            UserRepo userRepo
    ) {
        return LoginService.login(loginForm, userRepo, jdbcTemplate);
    }

    @PostMapping("/registration")
    @ResponseBody
    public ResponseEntity<?> registrationUser (@RequestBody Auth auth) {
        return userRepo.create(auth, jdbcTemplate);
    }
}
