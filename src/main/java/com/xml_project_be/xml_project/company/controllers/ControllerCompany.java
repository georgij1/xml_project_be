package com.xml_project_be.xml_project.company.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.xml_project_be.xml_project.company.dto.AuthCompanyDto;
import com.xml_project_be.xml_project.company.dto.CreateCompanyDto;
import com.xml_project_be.xml_project.company.dto.UpdateCompanyDto;
import com.xml_project_be.xml_project.company.service.CompanyServicve;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
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
    public ResponseEntity<?> createCompany(@RequestBody CreateCompanyDto createCompany) {
        return companyServicve.createCompany(createCompany);
    }

    @GetMapping("/listCompany")
    @ResponseBody
    public ResponseEntity<?> getAllCompany() {
        return companyServicve.getAllCompany();
    }

    @GetMapping("/сompany/{id}")
    @ResponseBody
    public ResponseEntity<?> getCompanyById(@PathVariable Integer id) {
        return companyServicve.getCompanyById(id);
    }

    @DeleteMapping("/deleteCompany/{id}")
    @ResponseBody
    public ResponseEntity<?> getAllCompany(@PathVariable Integer id) {
        return companyServicve.deleteCompany(id);
    }

    @PutMapping("/updateCompany/{id}")
    @ResponseBody
    public ResponseEntity<?> updateCompany(
        @PathVariable Integer id,
        UpdateCompanyDto updateCompanyDto
    ) {
        return companyServicve.updateCompany(id, updateCompanyDto);
    }
}