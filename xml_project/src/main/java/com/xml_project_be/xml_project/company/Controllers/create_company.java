package com.xml_project_be.xml_project.company.Controllers;

import com.xml_project_be.xml_project.aop.CheckHeader;
import com.xml_project_be.xml_project.company.forms.AuthCompany;
import com.xml_project_be.xml_project.company.forms.CreateCompany;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;

@Controller
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/company")
public class create_company {
    HttpServletRequest request;
    HttpServletResponse response;
    JdbcTemplate jdbcTemplate;

    public static void create_dir_company(String company) {
        File file = new File(System.getProperty("user.home")+"/Downloads/uploads/"+company);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    @PostMapping("/auth")
    @ResponseBody
    @CheckHeader
    public String AuthCompany(@RequestBody AuthCompany authCompany) throws IOException {
        System.out.println(authCompany.getNameCompany());
        System.out.println(authCompany.getPassword());

        if (Boolean.TRUE.equals(jdbcTemplate.queryForObject
                ("select exists(select * from company where name_company=?)",
                Boolean.class, authCompany.getNameCompany())
        )) {
            if (Boolean.TRUE.equals(jdbcTemplate.queryForObject("select exists(select * from company where password_company=?)", Boolean.class, authCompany.getPassword()))) {
                System.out.println("Name is exists and password company exists");
                return authCompany.getNameCompany();
            }
            response.sendError(404, "Name is exists, but password is not correct");
            System.out.println("Name is exists");
        }

        else {
            response.sendError(404, "Name is not exists");
            System.out.println("Name is not exists");
        }

        return "";
    }

    @PostMapping("/create")
    @ResponseBody
    @CheckHeader
    public String all_company(@RequestBody CreateCompany createCompany) {
        create_dir_company(createCompany.getName_company());
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
}