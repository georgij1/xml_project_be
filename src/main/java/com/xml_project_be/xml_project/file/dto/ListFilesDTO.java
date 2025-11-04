package com.xml_project_be.xml_project.file.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ListFilesDTO {
    @JsonProperty("nameCompany")
    private String nameCompany;
}
