package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditApprover {
    public static void setApprover(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String NameCompany,
            Integer IdFile
    ) {
        if (column_name.equals("family_name_value")) {
            jdbcTemplate.update("update xml_project.public.approver_object_xml set family_name_value = ? where xml_project.public.approver_object_xml.id_transaction = ?", column_value, id_transaction);
        } else if (column_name.equals("first_name_value")) {
            jdbcTemplate.update("update xml_project.public.approver_object_xml set first_name_value = ? where xml_project.public.approver_object_xml.id_transaction = ?", column_value, id_transaction);
        } else if (column_name.equals("second_name_value")) {
            jdbcTemplate.update("update xml_project.public.approver_object_xml set second_name_value = ? where xml_project.public.approver_object_xml.id_transaction = ?", column_value, id_transaction);
        } else if (column_name.equals("position_value")) {
            jdbcTemplate.update("update xml_project.public.approver_object_xml set position_value = ? where xml_project.public.approver_object_xml.id_transaction = ?", column_value, id_transaction);
        } else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.approver_object_xml(" +
                            "family_name_value, first_name_value, second_name_value, " +
                            "position_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?)",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    NameCompany,
                    IdFile,
                    UUID.randomUUID()
            );
        } else {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.approver_object_xml(" +
                            "family_name_value, first_name_value, second_name_value, " +
                            "position_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?)",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    NameCompany,
                    IdFile,
                    UUID.randomUUID()
            );
        }
    }
}