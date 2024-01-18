package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetPreviousSimpleConclusion {
    public static Node getPreviousSimpleConclusion(
            org.w3c.dom.Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("PreviousSimpleConclusion");
        node.appendChild(doc.createElement("Date")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Number")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Result")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.previous_simple_conclusions_object_xml(" +
                "previous_simple_conclusion_value, date_value, number_value, " +
                "result_value, name_company, name_file) " +
                "VALUES (?, ?, ?, ?, ?, ?)", "", "Данных нет", "Данных нет", "Данных нет", NameCompany, IdFile);
        return node;
    }
}