package com.xml_project_be.xml_project.company.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AuthCompanyDto {
    @JsonProperty("nameCompany")
    private String nameCompany;
    @JsonProperty("passwordCompany")
    private String passwordCompany;
}