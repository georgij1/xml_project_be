package com.xml_project_be.xml_project.auth.User;

import com.xml_project_be.xml_project.auth.auth_forms.RegistrationForm;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.xml_project_be.xml_project.auth.User.SHA256PasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Service
@AllArgsConstructor
@Repository
@Controller
@RequestMapping
@CrossOrigin("*")
public class UserRepo {
    public boolean create (
            RegistrationForm registrationForm,
            JdbcTemplate jdbcTemplate
    ) {
        try {
            if (registrationForm.getLogin().length() > 0) {
                jdbcTemplate.update(
                        "insert into public.users(username, password_hash) values (?, ?)",
                        registrationForm.getLogin(),
                        SHA256PasswordEncoder.encodePassword(registrationForm.getPassword())
                );
                System.out.println("регистрация");
            }

            else {
                System.out.println("Ошибка в регистрации");
            }
        } catch (DataAccessException exception) {
            return false;
        }

        return true;
    }

    // Метод для проверки пароля и успешной авторизации
    public boolean validPassword (
            @NotNull String username,
            @NotNull String password,
            JdbcTemplate jdbcTemplate
    ) {
        var hashed = jdbcTemplate.queryForObject (
                "select password_hash from users where username=?",
                String.class, username
        );
        return SHA256PasswordEncoder.matches(password, hashed);
    }
}