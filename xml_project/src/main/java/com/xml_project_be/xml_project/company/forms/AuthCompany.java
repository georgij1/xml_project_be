package com.xml_project_be.xml_project.company.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthCompany {
    @JsonProperty("NameCompany")
    public String NameCompany;
    @JsonProperty("PasswordCompany")
    public String password;
}