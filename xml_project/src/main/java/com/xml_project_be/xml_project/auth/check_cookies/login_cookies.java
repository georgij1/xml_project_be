package com.xml_project_be.xml_project.auth.check_cookies;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.xml_project_be.xml_project.auth.User.UserRepo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.Objects;

public class login_cookies {
    public static String cookies_login(
        String loginFormLogin,
        String loginFormPassword,
        HttpServletResponse response,
        HttpServletRequest request,
        UserRepo userRepo,
        JdbcTemplate jdbcTemplate
    ) {
        var cookies = request.getCookies();
        String token = null;

        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            if (!cookie.getName().equals("auth_token")) {
                if (Objects.equals(loginFormLogin, "")) {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                }

                else {
                    try {
                        if (token != null) {
                            response.setStatus(HttpServletResponse.SC_SEE_OTHER);
                            return "redirect on /main_page";
                        }

                        else {
                            String secret = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXUyJ9.eyJpc3MiOiJhdXRoMCJ9.AbIJTDMFc7yUa5MhvcP03nJPyCPzZtQcGEp-zWfOkEE";

                            if (loginFormLogin.length() > 0 && loginFormPassword.length() >= 8) {
                                if (userRepo.validPassword(loginFormLogin, loginFormPassword, jdbcTemplate)) {
                                    try {
                                        Algorithm algorithm = Algorithm.HMAC512(secret);
                                        String jwtToken = JWT.create()
                                                .withIssuer(loginFormLogin)
                                                .withClaim("userId", "1234")
                                                .withSubject(loginFormLogin)
                                                .withIssuedAt(new Date())
                                                .withExpiresAt(new Date(System.currentTimeMillis() + 50000L))
                                                .sign(algorithm);
                                        JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secret))
                                                .build();
                                        DecodedJWT decodedJWT = verifier.verify(jwtToken);
                                        Cookie cookie_1 = new Cookie("auth_token", jwtToken);
                                        response.addCookie(cookie_1);
                                        System.out.println(cookie_1.getValue());
                                        return cookie_1.getValue();
                                    }

                                    catch (JWTCreationException | org.springframework.dao.EmptyResultDataAccessException | org.springframework.dao.DataIntegrityViolationException ignored) {
                                        System.out.println("catch - JWTCreationException | org.springframework.dao.EmptyResultDataAccessException | org.springframework.dao.DataIntegrityViolationException ignored");
                                    }

                                    return "redirect on /main_page";
                                }

                                else {
                                    return "password is not valid";
                                }
                            }
                        }
                    }

                    catch (org.springframework.dao.EmptyResultDataAccessException | org.springframework.dao.DataIntegrityViolationException exception) {
                        return "/auth/ErrorsPage/not_valid_user";
                    }
                }
            }

                return "/auth/login";
        }
        return "cookies_login";
    }
}