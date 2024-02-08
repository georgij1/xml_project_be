package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditSummary {
    public static void setSummary(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String NameCompany,
            Integer IdFile
    ) {
        if (column_name.equals("engineering_survey_type_value")) {
            jdbcTemplate.update("update xml_project.public.summary_object_xml set engineering_survey_type_value = ? where xml_project.public.summary_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("project_documents_summary_value")) {
            jdbcTemplate.update("update xml_project.public.summary_object_xml set project_documents_summary_value = ? where xml_project.public.summary_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("project_documents_summary_date_value")) {
            jdbcTemplate.update("update xml_project.public.summary_object_xml set project_documents_summary_date_value = ? where xml_project.public.summary_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("examination_summary_value")) {
            jdbcTemplate.update("update xml_project.public.summary_object_xml set examination_summary_value = ? where xml_project.public.summary_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.summary_object_xml(" +
                            "engineering_survey_type_value, " +
                            "project_documents_summary_value," +
                            "project_documents_summary_date_value, " +
                            "examination_summary_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?)",
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
                            "xml_project.public.summary_object_xml(" +
                            "engineering_survey_type_value, " +
                            "project_documents_summary_value," +
                            "project_documents_summary_date_value, " +
                            "examination_summary_value, name_company, id_file, " +
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