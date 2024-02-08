package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditDesigner {
    public static void setDesigner(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String NameCompany,
            Integer IdFile
    ) {
        if (column_name.equals("ip_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set ip_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("family_name_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set family_name_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("first_name_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set first_name_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("second_name_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set second_name_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("ogrnip_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set ogrnip_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("post_address_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set post_address_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("country_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set country_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("region_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set region_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("post_index_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set post_index_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("city_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set city_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("street_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set street_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("building_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set building_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("room_value")) {
            jdbcTemplate.update("update xml_project.public.designer_object_xml set room_value = ? where xml_project.public.designer_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.designer_object_xml(" +
                            "ip_value, family_name_value, first_name_value, " +
                            "second_name_value, ogrnip_value, post_address_value, country_value," +
                            "region_value, post_index_value, city_value, street_value, building_value, " +
                            "room_value, name_company, id_file, " +
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
                            "xml_project.public.designer_object_xml(" +
                            "ip_value, family_name_value, first_name_value, " +
                            "second_name_value, ogrnip_value, post_address_value, country_value," +
                            "region_value, post_index_value, city_value, street_value, building_value, " +
                            "room_value, name_company, id_file, " +
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