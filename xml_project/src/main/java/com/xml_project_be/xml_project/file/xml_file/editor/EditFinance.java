package com.xml_project_be.xml_project.file.xml_file.editor;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

public class EditFinance {
    public static void setFinance(
            JdbcTemplate jdbcTemplate,
            String column_name,
            String column_value,
            UUID id_transaction,
            String NameCompany,
            Integer IdFile
    ) {
        if (column_name.equals("finance_type")) {
            jdbcTemplate.update("update xml_project.public.finance_object_xml set finance_type = ? where xml_project.public.finance_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("finance_size")) {
            jdbcTemplate.update("update xml_project.public.finance_object_xml set finance_size = ? where xml_project.public.finance_object_xml.id_transaction = ?", column_value, id_transaction);
        }

        else if (column_name.equals("id_transaction")) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.finance_object_xml(" +
                            "finance_type, finance_size, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?)",
                    "У вас нет доступа на редактирование id_transaction",
                    "У вас нет доступа на редактирование id_transaction",
                    NameCompany,
                    IdFile,
                    UUID.randomUUID()
            );
        }

        else {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.finance_object_xml(" +
                            "finance_type, finance_size, name_company, id_file, " +
                            "id_transaction) VALUES " +
                            "(?, ?, ?, ?, ?)",
                    "Такой колонки не существует",
                    "Такой колонки не существует",
                    NameCompany,
                    IdFile,
                    UUID.randomUUID()
            );
        }
    }
}
