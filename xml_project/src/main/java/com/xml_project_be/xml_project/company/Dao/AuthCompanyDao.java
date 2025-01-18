package com.xml_project_be.xml_project.company.Dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthCompanyDao {
    @JsonProperty("NameCompany")
    private String NameCompany;
    
    @JsonProperty("PasswordCompany")
    private String password;

    // Getter and Setter for NameCompany
    public String getNameCompany() {
        return NameCompany;
    }

    public void setNameCompany(String NameCompany) {
        this.NameCompany = NameCompany;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}