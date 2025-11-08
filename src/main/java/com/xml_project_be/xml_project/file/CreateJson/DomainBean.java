package com.xml_project_be.xml_project.file.CreateJson;

import lombok.Data;

public class DomainBean {
    private String id_file;
    private String file_name;
    private String time_stamp;
    private String author;
    private String company;

    // Getter и Setter для id_file
    public String getId_file() {
        return id_file;
    }

    public void setId_file(String id_file) {
        this.id_file = id_file;
    }

    // Getter и Setter для file_name
    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    // Getter и Setter для time_stamp
    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    // Getter и Setter для author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter и Setter для company
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}