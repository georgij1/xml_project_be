package com.xml_project_be.xml_project.file.xml_file.editor;

import lombok.Data;

public class CreateRow {
    private String TableName;
    private Integer id_file;
    private String NameCompany;
    private Object OrgFullName;
    private Object id;
    private Object value;

    // Getter и Setter для TableName
    public String getTableName() {
        return TableName;
    }

    public void setTableName(String TableName) {
        this.TableName = TableName;
    }

    // Getter и Setter для id_file
    public Integer getId_file() {
        return id_file;
    }

    public void setId_file(Integer id_file) {
        this.id_file = id_file;
    }

    // Getter и Setter для NameCompany
    public String getNameCompany() {
        return NameCompany;
    }

    public void setNameCompany(String NameCompany) {
        this.NameCompany = NameCompany;
    }

    // Getter и Setter для OrgFullName
    public Object getOrgFullName() {
        return OrgFullName;
    }

    public void setOrgFullName(Object OrgFullName) {
        this.OrgFullName = OrgFullName;
    }

    // Getter и Setter для id
    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    // Getter и Setter для value
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}