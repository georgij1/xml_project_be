package com.xml_project_be.xml_project.file.xml_file.editor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class BodyGetEditedFields {
    @NotBlank
    String table_name;
    @NotBlank
    String column_value;
    @NotBlank
    String column_name;
    @NotBlank
    String company_name;
    @NotBlank
    UUID id_transaction;
    @NotBlank
    @Min(1)
    Integer id_file;
}