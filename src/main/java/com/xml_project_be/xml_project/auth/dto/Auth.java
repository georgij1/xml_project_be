package com.xml_project_be.xml_project.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Auth {
    @NotNull
    @JsonProperty("login")
    private String login;
    @NotNull
    @JsonProperty("password")
    private String password;
}