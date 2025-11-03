package com.xml_project_be.xml_project.auth.user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xml_project_be.xml_project.auth.authForms.RegistrationForm;

@Service
@AllArgsConstructor
@Repository
@Controller
@RequestMapping
@CrossOrigin("*")
public class UserRepo {
    public ResponseEntity<?> create(
            RegistrationForm registrationForm,
            JdbcTemplate jdbcTemplate
    ) {
        try {
            jdbcTemplate.update(
                    "insert into public.users(username, password_hash) values (?, ?)",
                    registrationForm.getLogin(),
                    SHA256PasswordEncoder.encodePassword(registrationForm.getPassword())
            );

            return new ResponseEntity<>("create user is success", HttpStatus.OK);
        } catch (DataAccessException exception) {
            return new ResponseEntity<>("Error: "+exception, HttpStatus.BAD_REQUEST);
        }
    }

    public boolean validPassword (
            @NotNull String username,
            @NotNull String password,
            JdbcTemplate jdbcTemplate
    ) {
        var hashed = jdbcTemplate.queryForObject (
                "select password_hash from users where username=?",
                String.class, username
        );

        return hashed.equals(SHA256PasswordEncoder.encodePassword(password));
    }
}