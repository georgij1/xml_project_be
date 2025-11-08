package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditProjectDocumentsDeveloper {
    public static void setProjectDocumentsDeveloper(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String NameCompany,
            Integer IdFile
    ) {
        if (column_name.equals("organization_value")) {
            jdbcTemplate.update("update xml_project.public.project_documents_developer_object_xml set organization_value = ? where xml_project.public.project_documents_developer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        if (column_name.equals("org_full_name_value")) {
            jdbcTemplate.update("update xml_project.public.project_documents_developer_object_xml set org_full_name_value = ? where xml_project.public.project_documents_developer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        if (column_name.equals("org_ogrn_value")) {
            jdbcTemplate.update("update xml_project.public.project_documents_developer_object_xml set org_ogrn_value = ? where xml_project.public.project_documents_developer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        if (column_name.equals("org_inn_value")) {
            jdbcTemplate.update("update xml_project.public.project_documents_developer_object_xml set org_inn_value = ? where xml_project.public.project_documents_developer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        if (column_name.equals("org_kpp_value")) {
            jdbcTemplate.update("update xml_project.public.project_documents_developer_object_xml set org_kpp_value = ? where xml_project.public.project_documents_developer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        if (column_name.equals("region_value")) {
            jdbcTemplate.update("update xml_project.public.project_documents_developer_object_xml set region_value = ? where xml_project.public.project_documents_developer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        if (column_name.equals("city_value")) {
            jdbcTemplate.update("update xml_project.public.project_documents_developer_object_xml set city_value = ? where xml_project.public.project_documents_developer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        if (column_name.equals("street_value")) {
            jdbcTemplate.update("update xml_project.public.project_documents_developer_object_xml set street_value = ? where xml_project.public.project_documents_developer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        if (column_name.equals("building_value")) {
            jdbcTemplate.update("update xml_project.public.project_documents_developer_object_xml set building_value = ? where xml_project.public.project_documents_developer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        if (column_name.equals("room_value")) {
            jdbcTemplate.update("update xml_project.public.project_documents_developer_object_xml set room_value = ? where xml_project.public.project_documents_developer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.project_documents_developer_object_xml(" +
                            "organization_value, org_full_name_value, org_ogrn_value, " +
                            "org_inn_value, " +
                            "org_kpp_value, region_value, city_value, street_value, " +
                            "building_value, room_value, name_company, id_file, " +
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
                            "xml_project.public.project_documents_developer_object_xml(" +
                            "organization_value, org_full_name_value, org_ogrn_value, " +
                            "org_inn_value, " +
                            "org_kpp_value, region_value, city_value, street_value, " +
                            "building_value, room_value, name_company, id_file, " +
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