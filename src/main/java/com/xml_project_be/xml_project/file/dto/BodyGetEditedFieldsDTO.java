package com.xml_project_be.xml_project.file.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.UUID;

@Data
public class BodyGetEditedFieldsDTO {
    @NotBlank
    private String tableName;
    @NotBlank
    private String columnValue;
    @NotBlank
    private String columnName;
    @NotBlank
    private String companyName;
    @NotBlank
    private UUID idTransaction;
    @NotBlank
    @Min(1)
    private Integer idFile;
}