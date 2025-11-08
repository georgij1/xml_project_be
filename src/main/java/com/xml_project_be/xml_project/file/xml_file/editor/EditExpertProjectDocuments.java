package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditExpertProjectDocuments {
    public static void setExpertProjectDocuments(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String NameCompany,
            Integer IdFile
    ) {
        if (column_name.equals("project_documents_review")) {
            jdbcTemplate.update("update xml_project.public.expert_project_documents_object_xml set project_documents_review = ? where xml_project.public.expert_project_documents_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.expert_project_documents_object_xml(" +
                            "project_documents_review, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?)",
                    "У вас нет доступа на редактирование id_transaction",
                    NameCompany,
                    IdFile,
                    UUID.randomUUID()
            );
        }

        else {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.expert_project_documents_object_xml(" +
                            "project_documents_review, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?)",
                    "Такой колонки не существует",
                    NameCompany,
                    IdFile,
                    UUID.randomUUID()
            );
        }
    }
}