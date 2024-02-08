package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditClimateConditions {
    public static void setClimateConditions(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String NameCompany,
            Integer IdFile
    ) {
        if (column_name.equals("climate_district_value")) {
            jdbcTemplate.update("update xml_project.public.climate_conditions_object_xml set climate_district_value = ? where xml_project.public.climate_conditions_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("geological_conditions_value")) {
            jdbcTemplate.update("update xml_project.public.climate_conditions_object_xml set geological_conditions_value = ? where xml_project.public.climate_conditions_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("wind_district_value")) {
            jdbcTemplate.update("update xml_project.public.climate_conditions_object_xml set wind_district_value = ? where xml_project.public.climate_conditions_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("snow_district_value")) {
            jdbcTemplate.update("update xml_project.public.climate_conditions_object_xml set snow_district_value = ? where xml_project.public.climate_conditions_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("seismic_activity_value")) {
            jdbcTemplate.update("update xml_project.public.climate_conditions_object_xml set seismic_activity_value = ? where xml_project.public.climate_conditions_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.climate_conditions_object_xml(" +
                            "climate_district_value, geological_conditions_value, wind_district_value, " +
                            "snow_district_value, seismic_activity_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?)",
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
                            "xml_project.public.climate_conditions_object_xml(" +
                            "climate_district_value, geological_conditions_value, wind_district_value, " +
                            "snow_district_value, seismic_activity_value, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?, ?, ?, ?)",
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