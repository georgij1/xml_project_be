package com.xml_project_be.xml_project.file.xml_file.editor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.UUID;

@Data
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
}