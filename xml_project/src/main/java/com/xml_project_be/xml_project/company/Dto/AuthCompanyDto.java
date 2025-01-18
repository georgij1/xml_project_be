package com.xml_project_be.xml_project.company.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthCompanyDto {
    @JsonProperty("name_company")
    private String name_company;
    
    @JsonProperty("password")
    private String password_company;

    // Getter and Setter for NameCompany
    public String getname_company() {
        return name_company;
    }

    public void setname_company(String name_company) {
        this.name_company = name_company;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password_company;
    }

    public void setPassword(String password_company) {
        this.password_company = password_company;
    }
}