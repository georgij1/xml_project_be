package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditObject {
    public static void setObject(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String NameCompany,
            Integer IdFile
    ) {
        if (column_name.equals("name_value")) {
            jdbcTemplate.update("update xml_project.public.object_object_xml set name_value = ? where xml_project.public.object_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("type_value")) {
            jdbcTemplate.update("update xml_project.public.object_object_xml set type_value = ? where xml_project.public.object_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("functions_value")) {
            jdbcTemplate.update("update xml_project.public.object_object_xml set functions_value = ? where xml_project.public.object_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("country_value")) {
            jdbcTemplate.update("update xml_project.public.object_object_xml set country_value = ? where xml_project.public.object_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("region_value")) {
            jdbcTemplate.update("update xml_project.public.object_object_xml set region_value = ? where xml_project.public.object_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("city_value")) {
            jdbcTemplate.update("update xml_project.public.object_object_xml set city_value = ? where xml_project.public.object_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("note_value")) {
            jdbcTemplate.update("update xml_project.public.object_object_xml set note_value = ? where xml_project.public.object_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("tei_name_value")) {
            jdbcTemplate.update("update xml_project.public.object_object_xml set tei_name_value = ? where xml_project.public.object_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("tei_measure_value")) {
            jdbcTemplate.update("update xml_project.public.object_object_xml set tei_measure_value = ? where xml_project.public.object_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("tei_value_value")) {
            jdbcTemplate.update("update xml_project.public.object_object_xml set tei_value_value = ? where xml_project.public.object_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.object_object_xml(" +
                            "name_value, type_value, functions_value, " +
                            "country_value, region_value, city_value, note_value, " +
                            "tei_name_value, tei_measure_value, tei_value_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
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
                            "xml_project.public.object_object_xml(" +
                            "name_value, type_value, functions_value, " +
                            "country_value, region_value, city_value, note_value, " +
                            "tei_name_value, tei_measure_value, tei_value_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    "Такой колонки не существует",
                    "Такой колонки не существует",
                    "Такой колонки не существует",
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