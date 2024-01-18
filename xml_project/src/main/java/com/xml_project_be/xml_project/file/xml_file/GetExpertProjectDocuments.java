package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetExpertProjectDocuments {
    public static Node getExpertProjectDocuments(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("ExpertProjectDocuments");
        node.setAttribute("ExpertType", "Данных нет");
        node.appendChild(doc.createElement("ProjectDocumentsReview")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.expert_project_documents_object_xml(" +
                "project_documents_review, name_company, " +
                "name_file) VALUES (?, ?, ?)", "Данных нет",
                NameCompany, IdFile);
        return node;
    }
}