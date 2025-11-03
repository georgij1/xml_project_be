package com.xml_project_be.xml_project.auth.checkCookies;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xml_project_be.xml_project.auth.user.UserRepo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.Objects;

public class LoginCookies {
    public static ResponseEntity<?> cookiesLogin(
        String loginFormLogin,
        String loginFormPassword,
        HttpServletResponse response,
        HttpServletRequest request,
        UserRepo userRepo,
        JdbcTemplate jdbcTemplate
    ) {
        if (Objects.equals(loginFormLogin, "")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        else {
            String secret = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";

            if (loginFormLogin.length() > 0 && loginFormPassword.length() >= 8) {
                if (userRepo.validPassword(loginFormLogin, loginFormPassword, jdbcTemplate)) {
                    Algorithm algorithm = Algorithm.HMAC512(secret);
                    String jwtToken = JWT.create()
                            .withIssuer(loginFormLogin)
                            .withClaim("userId", "1234")
                            .withSubject(loginFormLogin)
                            .withIssuedAt(new Date())
                            .withExpiresAt(new Date(System.currentTimeMillis() + 43200L))
                            .sign(algorithm);
                    Cookie cookie_1 = new Cookie("auth_token", jwtToken);
                    response.addCookie(cookie_1);
                    System.out.println(cookie_1.getValue());
                    return new ResponseEntity<>(cookie_1.getValue(), HttpStatus.OK);
                }

                else {
                    return new ResponseEntity<>("password is not valid", HttpStatus.BAD_REQUEST);
                }
            }
        }

        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
}
