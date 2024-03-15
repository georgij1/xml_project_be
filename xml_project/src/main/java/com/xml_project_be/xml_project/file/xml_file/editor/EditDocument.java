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
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditExpertOrganization.setExpertOrganization(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getApprover_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditApprover.setApprover(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getObject_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditObject.setObject(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getCadastralNumber_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditCadastralNumber.setCadastralNumber(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDocuments_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditDocuments.setDocuments(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getPreviousConclusions_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditPreviousConclusions.setPreviousConclusions(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getPreviousSimpleConclusions_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditPreviousSimpleConclusions.setPreviousSimpleConclusions(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDeclarant_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditDeclarant.setDeclarant(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getProjectDocumentsDeveloper_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditProjectDocumentsDeveloper.setProjectDocumentsDeveloper(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getFinance_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditFinance.setFinance(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getClimateConditions_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditClimateConditions.setClimateConditions(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getClimateConditionsNote_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditClimateConditionsNote.setClimateConditionsNote(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getExpertProjectDocuments_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditExpertProjectDocuments.setExpertProjectDocuments(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getExperts_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditExperts.setExperts(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDesigner_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditDesigner.setDesigner(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getSummary_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditSummary.setSummary(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
        return ResponseEntity.ok().body(stringSuccessRequestMessage_part_1 + TableName + stringSuccessRequestMessage_part_2);
    }

    @SneakyThrows
    public static ResponseEntity<?> getExaminationObject_object(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        EditExaminationObject.setExaminationObject(jdbcTemplate, column_name, column_value, id_transaction, NameCompany, IdFile);
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

    @SneakyThrows
    public static ResponseEntity<?> getCreateRow(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            String TableName,
            String NameCompany,
            Integer IdFile
    ) {
        if (TableName.equals("ExpertOrganization")) {
            if (column_name.equals("org_full_name_value")) {
                jdbcTemplate.update("insert into xml_project.public.expert_organization_object_xml(" +
                        "org_full_name_value, " +
                        "org_ogrn_value, " +
                        "org_inn_value, " +
                        "org_kpp_value, " +
                        "region_value, " +
                        "city_value, " +
                        "street_value, " +
                        "building_value, " +
                        "room_value, " +
                        "name_company, " +
                        "id_file, " +
                        "id_transaction" +
                        ") VALUES (" +
                        "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?" +
                        ")", column_value, "Вы ещё не заполнили это поле", "Вы ещё не заполнили это поле",
                        "Вы ещё не заполнили это поле", "Вы ещё не заполнили это поле", "Вы ещё не заполнили это поле",
                        "Вы ещё не заполнили это поле", "Вы ещё не заполнили это поле", "Вы ещё не заполнили это поле",
                        NameCompany, IdFile, UUID.randomUUID()
                );
            }

            else {
                jdbcTemplate.update("insert into xml_project.public.expert_organization_object_xml(" +
                    "org_full_name_value, " +
                    "org_ogrn_value, " +
                    "org_inn_value, " +
                    "org_kpp_value, " +
                    "region_value, " +
                    "city_value, " +
                    "street_value, " +
                    "building_value, " +
                    "room_value, " +
                    "name_company, " +
                    "id_file, " +
                    "id_transaction" +
                    ") VALUES (" +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?" +
                    ")",
                        "Имя такой колонки не найдено",
                        "Вы ещё не заполнили это поле", "Вы ещё не заполнили это поле",
                    "Вы ещё не заполнили это поле", "Вы ещё не заполнили это поле", "Вы ещё не заполнили это поле",
                    "Вы ещё не заполнили это поле", "Вы ещё не заполнили это поле", "Вы ещё не заполнили это поле",
                    NameCompany, IdFile, UUID.randomUUID()
                );
            }
            return ResponseEntity.ok().body("Запись успешно сохранена");
        }

        else {
            return ResponseEntity.ok().body("Таблицы с таким именем нет");
        }
    }
}