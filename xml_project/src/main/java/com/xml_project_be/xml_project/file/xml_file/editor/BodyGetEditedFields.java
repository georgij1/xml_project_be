package com.xml_project_be.xml_project.file.xml_file.editor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

public class BodyGetEditedFields {
    @NotBlank
    private String table_name;

    @NotBlank
    private String column_value;

    @NotBlank
    private String column_name;

    @NotBlank
    private String company_name;

    @NotBlank
    private UUID id_transaction;

    @NotBlank
    @Min(1)
    private Integer id_file;

    // Getter и Setter для table_name
    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    // Getter и Setter для column_value
    public String getColumn_value() {
        return column_value;
    }

    public void setColumn_value(String column_value) {
        this.column_value = column_value;
    }

    // Getter и Setter для column_name
    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    // Getter и Setter для company_name
    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    // Getter и Setter для id_transaction
    public UUID getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(UUID id_transaction) {
        this.id_transaction = id_transaction;
    }

    // Getter и Setter для id_file
    public Integer getId_file() {
        return id_file;
    }

    public void setId_file(Integer id_file) {
        this.id_file = id_file;
    }
}