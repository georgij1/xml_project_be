package com.xml_project_be.xml_project.auth.Controllers;

import com.xml_project_be.xml_project.auth.User.UserRepo;
import com.xml_project_be.xml_project.auth.auth_forms.RegistrationForm;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/user/auth")
@AllArgsConstructor
public class RegistrationController {
    public UserRepo userRepo;
    public JdbcTemplate jdbcTemplate;

    @PostMapping("/registration")
    @ResponseBody
    public ResponseEntity<String> registration_user (
            @RequestBody RegistrationForm registrationForm,
            HttpServletResponse response
    ) {
    if (
        (
            Objects.equals(registrationForm.getPassword(), "😩🍆💦💦💦")
        ) &&
        (
            Objects.equals(registrationForm.getRepeatPassword(), "😩🍆💦💦💦")
        )
    ) {
       return new ResponseEntity<>("redirect on login", HttpStatus.FORBIDDEN);
    }

    else if ((registrationForm.getLogin().length() > 0 && registrationForm.getPassword().length() >= 8 && registrationForm.getRepeatPassword().length() >= 8)) {
        if ((Objects.equals(registrationForm.getPassword(), registrationForm.getRepeatPassword()))) {
            userRepo.create (
                registrationForm,
                jdbcTemplate
            );
            return new ResponseEntity<>("redirect on login", HttpStatus.OK);
        }

        else {
                return new ResponseEntity<>("redirect on /auth/registration", HttpStatus.FORBIDDEN);
            }
        }

        else {
            return new ResponseEntity<>("redirect on /auth/ErrorsPage/password_not_correct", HttpStatus.FORBIDDEN);
        }
    }
}