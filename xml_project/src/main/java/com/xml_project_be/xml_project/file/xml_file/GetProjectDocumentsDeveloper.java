package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetProjectDocumentsDeveloper {
    public static Node getProjectDocumentsDeveloper(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("ProjectDocumentsDeveloper");
        node.appendChild(doc.createElement("Organization")).appendChild(doc.createElement("OrgFullName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgOGRN")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgINN")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgKPP")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.project_documents_developer_object_xml(" +
                "organization_value, org_full_name_value, org_ogrn_value, " +
                "org_inn_value, org_kpp_value, address_value, region_value, " +
                "city_value, street_value, building_value, room_value, " +
                "name_company, name_file) VALUES (?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?)", "", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", "",
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", NameCompany, IdFile);
        return node;
    }
}