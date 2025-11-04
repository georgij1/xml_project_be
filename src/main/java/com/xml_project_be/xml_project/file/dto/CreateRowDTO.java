package com.xml_project_be.xml_project.file.dto;

import lombok.Data;

@Data
public class CreateRowDTO {
    private String tableName;
    private Integer idFile;
    private String nameCompany;
    private Object orgFullName;
    private Object id;
    private Object value;
}