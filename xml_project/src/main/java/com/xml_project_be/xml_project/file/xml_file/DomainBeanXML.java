package com.xml_project_be.xml_project.file.xml_file;

import lombok.Data;

import java.util.List;

@Data
public class DomainBeanXML {
    public List<?> name_file;
    public List<?> content_file;
    public Object tables;
    public Integer count_tables;
}