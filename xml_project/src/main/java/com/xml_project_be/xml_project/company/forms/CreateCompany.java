package com.xml_project_be.xml_project.company.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateCompany {
    @JsonProperty("name_company")
    public String name_company;
    @JsonProperty("password_company")
    public String password_company;
    @JsonProperty("desc_company")
    public String desc_company;
}