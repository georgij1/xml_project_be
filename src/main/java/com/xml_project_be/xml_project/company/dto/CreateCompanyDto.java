package com.xml_project_be.xml_project.company.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateCompanyDto {
    @JsonProperty("nameCompany")
    private String nameCompany;    
    @JsonProperty("passwordCompany")
    private String passwordCompany;
    @JsonProperty("descCompany")
    private String descCompany;    
    @JsonProperty("ownerCompany")
    private String ownerCompany;
}