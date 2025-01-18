package com.xml_project_be.xml_project.file.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class Form {
    @JsonProperty("NameCompany")
    private String NameCompany;

    // Getter и Setter для NameCompany
    public String getNameCompany() {
        return NameCompany;
    }

    public void setNameCompany(String NameCompany) {
        this.NameCompany = NameCompany;
    }
}
