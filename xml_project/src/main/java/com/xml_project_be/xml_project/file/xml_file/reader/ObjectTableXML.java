package com.xml_project_be.xml_project.file.xml_file.reader;

import lombok.Data;

import java.util.List;

@Data
public class ObjectTableXML {
    public List<?> name_file;
    public List<?> content_file;
    public Object tables;
    public Integer count_tables;
}