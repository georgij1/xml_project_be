package com.xml_project_be.xml_project.file.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetTableDTO {
    @JsonProperty("fileID")
    private Integer fileID;
    @JsonProperty("nameCompany")
    private String nameCompany;
    @JsonProperty("nameObjectXML")
    private String nameObjectXML;
}