package com.xml_project_be.xml_project.auth.auth_forms;

import lombok.Data;

@Data
public class RegistrationForm {
    public String login;
    public String password;
    public String RepeatPassword;
}