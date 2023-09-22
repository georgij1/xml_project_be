package com.xml_project_be.xml_project.dto;

import com.xml_project_be.xml_project.models.Role;
import com.xml_project_be.xml_project.models.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFilterDTO {
    String firstName;
    String lastName;
    String secondName;
    String login;
    String email;
    Role role;
    State state;
    String phoneNumber;
}