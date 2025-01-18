package com.xml_project_be.xml_project.file.xml_file.reader;

import java.util.List;

public class ObjectTableXML {
    private List<?> name_file;
    private List<?> content_file;
    private Object tables;
    private Integer count_tables;

    // Getter и Setter для name_file
    public List<?> getName_file() {
        return name_file;
    }

    public void setName_file(List<?> name_file) {
        this.name_file = name_file;
    }

    // Getter и Setter для content_file
    public List<?> getContent_file() {
        return content_file;
    }

    public void setContent_file(List<?> content_file) {
        this.content_file = content_file;
    }

    // Getter и Setter для tables
    public Object getTables() {
        return tables;
    }

    public void setTables(Object tables) {
        this.tables = tables;
    }

    // Getter и Setter для count_tables
    public Integer getCount_tables() {
        return count_tables;
    }

    public void setCount_tables(Integer count_tables) {
        this.count_tables = count_tables;
    }
}
