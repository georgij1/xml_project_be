package com.xml_project_be.xml_project.auth;

import com.xml_project_be.xml_project.config.JwtService;
import com.xml_project_be.xml_project.dao.UserDao;
import com.xml_project_be.xml_project.models.Role;
import com.xml_project_be.xml_project.models.State;
import com.xml_project_be.xml_project.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .secondName(request.getSecondName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .login(request.getLogin())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();
        userDao.save(user);
        var jwt = jwtService.generateJWT(user);
        return AuthenticationResponse.builder()
                .jwt(jwt)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        var user = userDao.findByLogin(request.getLogin()).orElseThrow();
        var jwt = jwtService.generateJWT(user);
        return AuthenticationResponse.builder()
                .jwt(jwt)
                .build();
    }
}