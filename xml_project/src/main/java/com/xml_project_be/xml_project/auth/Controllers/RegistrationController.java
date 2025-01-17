package com.xml_project_be.xml_project.auth.Controllers;

import com.xml_project_be.xml_project.auth.User.UserRepo;
import com.xml_project_be.xml_project.auth.auth_forms.RegistrationForm;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @SneakyThrows
    public String registration_user (
            @RequestBody RegistrationForm registrationForm,
            HttpServletResponse response
    ) {
        // System.out.println("registration_user");
        // if (
        //     (
        //         Objects.equals(registrationForm.getPassword(), "😩🍆💦💦💦")
        //     ) &&
        //     (
        //         Objects.equals(registrationForm.getRepeatPassword(), "😩🍆💦💦💦")
        //     )
        // ) {
        //     response.sendError(400);
        // }

        // else if ((registrationForm.getLogin().length() > 0 && registrationForm.getPassword().length() >= 8 && registrationForm.getRepeatPassword().length() >= 8)) {
        //     // // if ((Objects.equals(registrationForm.getPassword(), registrationForm.getRepeatPassword()))) {
        //     // //     userRepo.create (
        //     // //         registrationForm,
        //     // //         jdbcTemplate
        //     // //     );
        //     // //     response.setStatus(HttpServletResponse.SC_SEE_OTHER);
        //     // //     return "redirect on login";
        //     // // }

        //     // else {
        //     //         response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        //     //         return "redirect on /auth/registration";
        //     //     }
        //     // }

        //     // else {
        //     //     return "redirect on /auth/ErrorsPage/password_not_correct";
        //     // }

        //     return "redirect on /auth/registration";
        // }
        return "";
    }
}