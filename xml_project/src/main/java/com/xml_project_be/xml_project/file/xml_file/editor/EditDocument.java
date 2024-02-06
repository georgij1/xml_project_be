package com.xml_project_be.xml_project.file.xml_file.editor;

import jakarta.validation.constraints.NotBlank;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditDocument {
    static String stringSuccessRequestMessage_part_1 = "Данные объекта ";
    static String stringSuccessRequestMessage_part_2 = " успешно обновлены";

    @SneakyThrows
    public static ResponseEntity<?> setExpertOrganization_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditExpertOrganization.setExpertOrganization(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getApprover_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditApprover.setApprover(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    // start here
    @SneakyThrows
    public static ResponseEntity<?> getObject_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditObject.setObject(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getCadastralNumber_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditCadastralNumber.setCadastralNumber(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDocuments_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditDocuments.setDocuments(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getPreviousConclusions_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditPreviousConclusions.setPreviousConclusions(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getPreviousSimpleConclusions_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditPreviousSimpleConclusions.setPreviousSimpleConclusions(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDeclarant_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditDeclarant.setDeclarant(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getProjectDocumentsDeveloper_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditProjectDocumentsDeveloper.setProjectDocumentsDeveloper(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getFinance_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditFinance.setFinance(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getClimateConditions_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditClimateConditions.setClimateConditions(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getClimateConditionsNote_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditClimateConditionsNote.setClimateConditionsNote(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getExpertProjectDocuments_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditExpertProjectDocuments.setExpertProjectDocuments(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getExperts_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditExperts.setExperts(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDesigner_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditDesigner.setDesigner(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getSummary_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditSummary.setSummary(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getExaminationObject_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName
    ) {
        EditExaminationObject.setExaminationObject(jdbcTemplate, column_name, column_value, id_transaction);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getNotFoundObject(
            @NotBlank Integer IdFile,
            @NotBlank String NameCompany,
            @NotBlank String column_value,
            @NotBlank UUID id_transaction,
            @NotBlank String tableName
    ) {
        return ResponseEntity.ok().body("Произошла ошибка. Ошибка в этих данных: " +
                "IdFile - " + IdFile + ", NameCompany - " + NameCompany + ", column_value - "
                + column_value + ", id_transaction - " + id_transaction + ", tableName - " + tableName);
    }
}