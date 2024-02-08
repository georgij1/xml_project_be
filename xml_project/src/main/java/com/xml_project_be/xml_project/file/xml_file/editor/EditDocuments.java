package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditDocuments {
    public static void setDocuments(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String NameCompany,
            Integer IdFile
    ) {
        if (column_name.equals("document_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set document_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("doc_type_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set doc_type_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("doc_name_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set doc_name_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("doc_number_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set doc_number_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("doc_date_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set doc_date_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("doc_issue_author_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set doc_issue_author_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("file_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set file_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("file_name_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set file_name_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("file_format_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set file_format_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("file_checksum_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set file_checksum_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("file_name_1_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set file_name_1_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("file_format_1_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set file_format_1_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("file_checksum_1_value")) {
            jdbcTemplate.update("update xml_project.public.documents_object_xml set file_checksum_1_value = ? where xml_project.public.documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.documents_object_xml(" +
                            "document_value, doc_type_value, doc_name_value, " +
                            "doc_number_value, doc_date_value, " +
                            "doc_issue_author_value, " +
                            "file_value, " +
                            "file_name_value, file_format_value, " +
                            "file_checksum_value, file_name_1_value, " +
                            "file_format_1_value, file_checksum_1_value, " +
                            "name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
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
                            "xml_project.public.documents_object_xml(" +
                            "document_value, doc_type_value, doc_name_value, " +
                            "doc_number_value, doc_date_value, " +
                            "doc_issue_author_value, " +
                            "file_value, " +
                            "file_name_value, file_format_value, " +
                            "file_checksum_value, file_name_1_value, " +
                            "file_format_1_value, file_checksum_1_value, " +
                            "name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
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