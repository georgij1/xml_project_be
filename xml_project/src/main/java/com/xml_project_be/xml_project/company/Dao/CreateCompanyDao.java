package com.xml_project_be.xml_project.company.Dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class CreateCompanyDao {
    @JsonProperty("name_company")
    private String name_company;
    
    @JsonProperty("password_company")
    private String password_company;
    
    @JsonProperty("desc_company")
    private String desc_company;
    
    @JsonProperty("owner_company")
    private String owner_company;

    // Getter and Setter for name_company
    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    // Getter and Setter for password_company
    public String getPassword_company() {
        return password_company;
    }

    public void setPassword_company(String password_company) {
        this.password_company = password_company;
    }

    // Getter and Setter for desc_company
    public String getDesc_company() {
        return desc_company;
    }

    public void setDesc_company(String desc_company) {
        this.desc_company = desc_company;
    }

    // Getter and Setter for owner_company
    public String getOwner_company() {
        return owner_company;
    }

    public void setOwner_company(String owner_company) {
        this.owner_company = owner_company;
    }
}