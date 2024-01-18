package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetSummary {
    public static Node getSummary(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("Summary");
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("ProjectDocumentsSummary")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.summary_object_xml(" +
                "engineering_survey_type_value, " +
                "project_documents_summary_value, " +
                "project_documents_summary_date_value, " +
                "examination_summary_value, name_company, " +
                "name_file) VALUES (?, ?, ?, ?, ?, ?)", "Данных нет", "Данных нет", "Данных нет", "Данных нет", NameCompany, IdFile);
        return node;
    }
}