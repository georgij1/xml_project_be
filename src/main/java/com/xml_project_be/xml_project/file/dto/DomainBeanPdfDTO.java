package com.xml_project_be.xml_project.file.dto;

import lombok.Data;
import java.util.List;

@Data
public class DomainBeanPdfDTO {
    private List<String> nameFile;
    private List<String> contentFile;
}