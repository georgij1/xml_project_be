package com.xml_project_be.xml_project.file.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Form {
    @JsonProperty("NameCompany")
    public String NameCompany;
}