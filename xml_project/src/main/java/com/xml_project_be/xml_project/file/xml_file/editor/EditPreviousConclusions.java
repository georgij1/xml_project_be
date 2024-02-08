package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditPreviousConclusions {
    public static void setPreviousConclusions(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String NameCompany,
            Integer IdFile
    ) {
        if (column_name.equals("previous_conclusion_value")) {
            jdbcTemplate.update("update xml_project.public.previous_conclusions set previous_conclusion_value = ? where xml_project.public.previous_conclusions.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("date_value")) {
            jdbcTemplate.update("update xml_project.public.previous_conclusions set date_value = ? where xml_project.public.previous_conclusions.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("number_value")) {
            jdbcTemplate.update("update xml_project.public.previous_conclusions set number_value = ? where xml_project.public.previous_conclusions.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("egrz_value")) {
            jdbcTemplate.update("update xml_project.public.previous_conclusions set egrz_value = ? where xml_project.public.previous_conclusions.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("examination_object_type_value")) {
            jdbcTemplate.update("update xml_project.public.previous_conclusions set examination_object_type_value = ? where xml_project.public.previous_conclusions.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("name_value")) {
            jdbcTemplate.update("update xml_project.public.previous_conclusions set name_value = ? where xml_project.public.previous_conclusions.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("result_value")) {
            jdbcTemplate.update("update xml_project.public.previous_conclusions set result_value = ? where xml_project.public.previous_conclusions.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.previous_conclusions(" +
                            "previous_conclusion_value, date_value, number_value, " +
                            "egrz_value, examination_object_type_value, " +
                            "name_value, result_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    "У вас нет доступа на редактирование id_transaction",
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

        else {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.previous_conclusions(" +
                            "previous_conclusion_value, date_value, number_value, " +
                            "egrz_value, examination_object_type_value, " +
                            "name_value, result_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    "Такой колонки не существует",
                    "Такой колонки не существует",
                    "Такой колонки не существует",
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