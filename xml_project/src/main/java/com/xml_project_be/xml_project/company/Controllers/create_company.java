package com.xml_project_be.xml_project.company.Controllers;

import com.xml_project_be.xml_project.company.forms.CreateCompany;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/company")
public class create_company {
    HttpServletRequest request;
    HttpServletResponse response;
    JdbcTemplate jdbcTemplate;

    @PostMapping("/create")
    @ResponseBody
    public String all_company(@RequestBody CreateCompany createCompany) {
        if (request.getHeader("Authorization") != null
            &&
            request.getHeader("Authorization").startsWith("Bearer ")
        ) {
            System.out.println(createCompany.getName_company());
            System.out.println(createCompany.getPassword_company());
            System.out.println(createCompany.getDesc_company());

            jdbcTemplate.update("insert into xml_project.public.company(" +
                "name_company, password_company, desc_company, owner_company) " +
                "VALUES (?, ?, ?, ?)", createCompany.getName_company(),
                createCompany.getPassword_company(), createCompany.getDesc_company(),
                createCompany.getOwner_company()
            );

            return "success create company";
        }

        else {
            System.out.println("you have not got jwt token");

            return "you have not got jwt token";
        }
    }
}