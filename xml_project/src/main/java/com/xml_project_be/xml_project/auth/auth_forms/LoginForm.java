package com.xml_project_be.xml_project.auth.auth_forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginForm {
    @JsonProperty("login")
    public String login;
    @JsonProperty("password")
    public String password;
}