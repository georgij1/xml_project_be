package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditCadastralNumber {
    public static void setCadastralNumber(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction
    ) {
        if (column_name.equals("examination_form_value")) {
            jdbcTemplate.update("update xml_project.public.expert_organization_object_xml set org_full_name_value = ? where xml_project.public.expert_organization_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.expert_organization_object_xml(" +
                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                            "org_kpp_value, region_value, city_value, street_value, " +
                            "building_value, room_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
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
                    column_value,
                    UUID.randomUUID()
            );
        }

        else {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.expert_organization_object_xml(" +
                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                            "org_kpp_value, region_value, city_value, street_value, " +
                            "building_value, room_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
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
                    column_value,
                    UUID.randomUUID()
            );
        }
    }
}