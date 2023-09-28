package com.xml_project_be.xml_project.company.Controllers;

import com.xml_project_be.xml_project.company.forms.CreateCompany;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/company")
public class create_company {
    HttpServletRequest request;
    HttpServletResponse response;

    @PostMapping("/create")
    @ResponseBody
    public String all_company(@RequestBody CreateCompany createCompany) {
        if (request.getHeader("Authorization") != null) {
            System.out.println(createCompany.getName_company());
            System.out.println(createCompany.getPassword_company());
            System.out.println(createCompany.getDesc_company());

            return "all_company";
        }

        else {
            System.out.println("you have not got jwt token");

            return "you have not got jwt token";
        }
    }
}