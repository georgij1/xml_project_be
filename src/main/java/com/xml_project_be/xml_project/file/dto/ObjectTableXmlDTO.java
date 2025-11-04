package com.xml_project_be.xml_project.file.dto;

import java.util.List;

import lombok.Data;

@Data
public class ObjectTableXmlDTO {
    private List<?> nameFile;
    private List<?> contentFile;
    private Object tables;
    private Integer countTables;
}
