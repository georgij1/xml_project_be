package com.xml_project_be.xml_project.xml_file.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetContentFile {
    @JsonProperty("NameFileUnique")
    public String NameFileUnique;
}