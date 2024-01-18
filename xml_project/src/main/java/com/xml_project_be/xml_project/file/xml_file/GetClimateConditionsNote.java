package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetClimateConditionsNote {
    public static Node getClimateConditionsNote(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("ClimateConditionsNote");
        node.appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into xml_project.public.climate_conditions_note_object_xml(" +
                "climate_conditions_note_value, " +
                "name_company, name_file) VALUES (?, ?, ?)", "Данных нет", NameCompany, IdFile);
        return node;
    }
}