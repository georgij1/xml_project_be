package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditPreviousSimpleConclusions {
    public static void setPreviousSimpleConclusions(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String NameCompany,
            Integer IdFile
    ) {
        if (column_name.equals("previous_simple_conclusion_value")) {
            jdbcTemplate.update("update xml_project.public.previous_simple_conclusions_object_xml set previous_simple_conclusion_value = ? where xml_project.public.previous_simple_conclusions_object_xml.id_transaction = ?", column_value, id_transaction);
        }
        
        else if (column_name.equals("date_value")) {
            jdbcTemplate.update("update xml_project.public.previous_simple_conclusions_object_xml set date_value = ? where xml_project.public.previous_simple_conclusions_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("number_value")) {
            jdbcTemplate.update("update xml_project.public.previous_simple_conclusions_object_xml set number_value = ? where xml_project.public.previous_simple_conclusions_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("result_value")) {
            jdbcTemplate.update("update xml_project.public.previous_simple_conclusions_object_xml set result_value = ? where xml_project.public.previous_simple_conclusions_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.previous_simple_conclusions_object_xml(" +
                            "previous_simple_conclusion_value, date_value, number_value, " +
                            "result_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?)",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    NameCompany,
                    IdFile,
                    UUID.randomUUID()
            );
        }

        else {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.previous_simple_conclusions_object_xml(" +
                            "previous_simple_conclusion_value, date_value, number_value, " +
                            "result_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?)",
                    "Такой колонки не существует",
                    "Такой колонки не существует",
                    "Такой колонки не существует",
                    "Такой колонки не существует",
                    NameCompany,
                    IdFile,
                    UUID.randomUUID()
            );
        }
    }
}