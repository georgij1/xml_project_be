package com.xml_project_be.xml_project.auth.repositories;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import com.xml_project_be.xml_project.auth.dto.Auth;

@Service
@AllArgsConstructor
@Repository
@Controller
@RequestMapping
@CrossOrigin("*")
public class UserRepo {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserRepo.class);

    public static String encodePassword(String rawPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(rawPassword.getBytes());
            return Base64.getEncoder().encodeToString(encodedHash);
        } 
        
        catch (NoSuchAlgorithmException e) {
            logger.info(e.toString());

            throw new RuntimeException("Ошибка хэширования", e);
        }
    }

    public ResponseEntity<?> create(
        Auth auth,
        JdbcTemplate jdbcTemplate
    ) {
        try {
            jdbcTemplate.update(
                "insert into xml_project.users(username, password_hash) values (?, ?)",
                auth.getLogin(),
                encodePassword(auth.getPassword())
            );

            return new ResponseEntity<>("", HttpStatus.OK);
        }
        
        catch (DataAccessException exception) {
            logger.info(exception.toString());

            return new ResponseEntity<>("Ошибка: "+exception, HttpStatus.BAD_REQUEST);
        }
    }

    public boolean validPassword (
        @NotNull String username,
        @NotNull String password,
        JdbcTemplate jdbcTemplate
    ) {
        try {
            var hashed = jdbcTemplate.queryForObject (
                "select password_hash from xml_project.users where username=?",
                String.class, username
            );

            return hashed.equals(encodePassword(password));
        }

        catch (DataAccessException exception) {
            logger.error(exception.toString());

            return false;
        }
    }

    public String getUserId(
        @NotNull String username,
        JdbcTemplate jdbcTemplate
    ) {
        try {
            var userId = jdbcTemplate.queryForObject(
                "select id from users where username=?",
                String.class, 
                username
            );

            return userId;
        }

        catch (DataAccessException exception) {
            logger.error(exception.toString());

            return "0";
        }        
    }
}