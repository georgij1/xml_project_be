package com.xml_project_be.xml_project.file.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Form {
    @JsonProperty("name_company")
    private String name_company;

    public String getname_company() {
        return name_company;
    }

    public void setname_company(String name_company) {
        this.name_company = name_company;
    }
}
