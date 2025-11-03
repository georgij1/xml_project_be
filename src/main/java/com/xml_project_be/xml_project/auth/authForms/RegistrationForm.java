package com.xml_project_be.xml_project.auth.authForms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegistrationForm {
    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String password;
}