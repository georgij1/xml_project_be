package com.xml_project_be.xml_project.auth.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xml_project_be.xml_project.auth.dto.Auth;
import com.xml_project_be.xml_project.auth.repositories.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Date;
import java.util.Objects;

public class LoginService {
    private static String secret = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";

    public static ResponseEntity<?> login(
        Auth auth,
        UserRepo userRepo,
        JdbcTemplate jdbcTemplate
    ) {
        var statePassqordValid = userRepo.validPassword(auth.getLogin(), auth.getPassword(), jdbcTemplate);

        if (statePassqordValid) {
            Algorithm algorithm = Algorithm.HMAC512(secret);

            String jwtToken = JWT.create()
                .withIssuer(auth.getLogin())
                .withClaim("userId", userRepo.getUserId(auth.getLogin(), jdbcTemplate))
                .withSubject(auth.getLogin())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 43200L))
                .sign(algorithm);

            return new ResponseEntity<>(jwtToken, HttpStatus.OK);
        }
        
        return new ResponseEntity<>("password is not valid", 
            Objects.equals(auth.getLogin(), "") 
            || 
            !statePassqordValid ? 
            HttpStatus.BAD_REQUEST 
            : 
            HttpStatus.OK
        );
    }
}
