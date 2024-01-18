package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetClimateConditions {
    public static Node getClimateConditions(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("ClimateConditions");
        node.appendChild(doc.createElement("ClimateDistrict")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("GeologicalConditions")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("WindDistrict")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("SnowDistrict")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("SeismicActivity")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into xml_project.public.climate_conditions_object_xml(climate_district_value, " +
                "geological_conditions_value, wind_district_value, snow_district_value, seismic_activity_value, " +
                "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, ?)", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", NameCompany, IdFile);
        return node;
    }
}