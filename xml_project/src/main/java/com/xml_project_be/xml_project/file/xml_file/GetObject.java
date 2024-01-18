package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetObject {
    public static Node getObject(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("Object");
        node.appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Type")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Functions")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Address")).appendChild(doc.createElement("Country")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Note")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("TEI")).appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("TEI").item(0).appendChild(doc.createElement("Measure")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("TEI").item(0).appendChild(doc.createElement("Value")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.object_object_xml(name_value, " +
                "type_value, " +
                "functions_value, address_value, country_value, " +
                        "region_value, " +
                "city_value, note_value, tei_name_value, " +
                        "tei_measure_value, " +
                "tei_value_value, name_company, name_file) VALUES (?, " +
                        "?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", NameCompany, IdFile);
        return node;
    }
}