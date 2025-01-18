package com.xml_project_be.xml_project.file.CreateJson;

import lombok.Data;

import java.util.List;

public class DomainBeanPdf {
    private List<String> name_file;
    private List<String> content_file;

    // Getter и Setter для name_file
    public List<String> getName_file() {
        return name_file;
    }

    public void setName_file(List<String> name_file) {
        this.name_file = name_file;
    }

    // Getter и Setter для content_file
    public List<String> getContent_file() {
        return content_file;
    }

    public void setContent_file(List<String> content_file) {
        this.content_file = content_file;
    }
}