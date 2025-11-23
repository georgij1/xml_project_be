package com.xml_project_be.xml_project.company.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.xml_project_be.xml_project.company.dto.AuthCompanyDto;
import com.xml_project_be.xml_project.company.dto.CreateCompanyDto;
import com.xml_project_be.xml_project.company.service.CompanyServicve;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/company")
public class ControllerCompany {
    @Autowired
    private CompanyServicve companyServicve;

    @PostMapping("/auth")
    @ResponseBody
    public ResponseEntity<?> authCompany(@RequestBody AuthCompanyDto authCompany) {
        return companyServicve.authCompany(authCompany);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> all_company(@RequestBody CreateCompanyDto createCompany) {
        return companyServicve.registerCompany(createCompany);
    }
}