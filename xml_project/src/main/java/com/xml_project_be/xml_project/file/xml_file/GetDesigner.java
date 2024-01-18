package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetDesigner {
    public static Node getDesigner(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("Designer");
        node.setAttribute("General", "нет");
        node.appendChild(doc.createElement("IP")).appendChild(doc.createElement("FamilyName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("FirstName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("SecondName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("OGRNIP")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("PostAddress")).appendChild(doc.createElement("Country")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("PostIndex")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.designer_object_xml(ip_value, " +
                "family_name_value, first_name_value, second_name_value, " +
                "ogrnip_value, post_address_value, country_value, region_value, " +
                "post_index_value, city_value, street_value, building_value, " +
                "room_value, name_company, name_file) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", NameCompany, IdFile);
        return node;
    }
}