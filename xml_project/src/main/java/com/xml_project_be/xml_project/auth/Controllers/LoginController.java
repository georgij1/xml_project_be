package com.xml_project_be.xml_project.auth.Controllers;

import com.xml_project_be.xml_project.auth.User.UserRepo;
import com.xml_project_be.xml_project.auth.auth_forms.LoginForm;
import com.xml_project_be.xml_project.auth.check_cookies.login_cookies;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/user/auth")
@AllArgsConstructor
public class LoginController {
    public JdbcTemplate jdbcTemplate;

    @PostMapping("/login")
    @ResponseBody
    public String login (
            @RequestBody LoginForm loginForm,
            HttpServletResponse response,
            HttpServletRequest request,
            UserRepo userRepo
    ) {
        if (
            loginForm.getLogin() == null
            && loginForm.getPassword() == null
        ) {
            return "all fields in LoginForm are null";
        }

        else  {
            return login_cookies.cookies_login(
                    loginForm.getLogin(),
                    loginForm.getPassword(),
                    response,
                    request,
                    userRepo,
                    jdbcTemplate
            );
        }
    }
}