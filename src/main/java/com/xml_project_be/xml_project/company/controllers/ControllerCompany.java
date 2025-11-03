package com.xml_project_be.xml_project.company.controllers;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.xml_project_be.xml_project.company.dto.AuthCompanyDto;
import com.xml_project_be.xml_project.company.dto.CreateCompanyDto;

import java.io.File;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Controller
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/company")
public class ControllerCompany {
    JdbcTemplate jdbcTemplate;

    public static Boolean createDirCompany(String company) {
        String basePath = System.getProperty("user.home") + File.separator + "xmlApp" + File.separator + "uploads";
        File file = new File(basePath + File.separator + company);
        
        if (!file.exists()) {
            boolean created = file.mkdirs();
            return created;
        }

        return false;
    }

    @PostMapping("/auth")
    @ResponseBody
    public ResponseEntity<?> authCompany(@RequestBody AuthCompanyDto authCompany) throws IOException {
        var isNameCompany = Boolean.TRUE.equals(
            jdbcTemplate.queryForObject(
                "select exists(select * from company where name_company=?)",
                Boolean.class, 
                authCompany.getNameCompany()
            )
        );

        var isPasswordCompany = Boolean.TRUE.equals(
            jdbcTemplate.queryForObject(
                "select exists(select * from company where password_company=?)", 
                Boolean.class, 
                authCompany.getPasswordCompany()
            )
        );
        
        if (isNameCompany && isPasswordCompany) {
            return new ResponseEntity<>("Success auth in company", HttpStatus.OK);
        }

        return new ResponseEntity<>("Name is exists, but password is not correct", HttpStatus.FORBIDDEN);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> all_company(@RequestBody CreateCompanyDto createCompany) {
        createDirCompany(createCompany.getNameCompany());
        
        jdbcTemplate.update(
            "insert into xml_project.public.company(" +
            "name_company, password_company, desc_company, owner_company) " +
            "VALUES (?, ?, ?, ?)", createCompany.getNameCompany(),
            createCompany.getPasswordCompany(), createCompany.getDescCompany(),
            createCompany.getOwnerCompany()
        );

        return new ResponseEntity<>("success create company", HttpStatus.OK);
    }
}