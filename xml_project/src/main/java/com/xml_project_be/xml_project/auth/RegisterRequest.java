package com.xml_project_be.xml_project.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank
    private String firstName;
    private String lastName;
    private String secondName;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @Email
    private String email;
}
