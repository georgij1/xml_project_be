package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetFinance {
    public static Node getFinance(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("Finance");
        node.appendChild(doc.createElement("FinanceType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("FinanceSize")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.finance_object_xml(finance_type, " +
                "finance_size, name_company, name_file) " +
                "VALUES (?, ?, ?, ?)", "Данных нет", "Данных нет", NameCompany, IdFile);
        return node;
    }
}