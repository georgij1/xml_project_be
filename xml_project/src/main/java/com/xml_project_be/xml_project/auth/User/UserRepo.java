package com.xml_project_be.xml_project.auth.User;

import com.xml_project_be.xml_project.auth.auth_forms.RegistrationForm;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
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
    public JdbcTemplate jdbcTemplate;

    public boolean create(RegistrationForm registrationForm) {
        try {
            if (registrationForm.getLogin().length() > 0) {
                jdbcTemplate.update(
                        "insert into public.users(username, password_hash) values (?, ?)",
                        registrationForm.getLogin(),
                        BCrypt.hashpw(registrationForm.getPassword(), BCrypt.gensalt())
                );
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
    public boolean validPassword (String username, String password) {
        var hashed = jdbcTemplate.queryForObject(
                "select password_hash from users where username=?", String.class, username);
        return BCrypt.checkpw(password, hashed);
    }
}