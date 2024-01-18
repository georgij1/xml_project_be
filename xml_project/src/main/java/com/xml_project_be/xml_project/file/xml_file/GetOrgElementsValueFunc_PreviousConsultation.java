package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetOrgElementsValueFunc_PreviousConsultation {
    public static Node getOrgElementsValueFunc_PreviousConsultation(
            org.w3c.dom.Document doc,
            String PreviousConclusion,
            String Date,
            String TextDate,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement(PreviousConclusion);
        node.appendChild(doc.createElement(Date)).appendChild(doc.createTextNode(TextDate));
        node.appendChild(doc.createElement("Number")).appendChild(doc.createElement("EGRZ")).appendChild(doc.createTextNode("66-2-1-3-049345-2020"));
        node.appendChild(doc.createElement("ExaminationObjectType")).appendChild(doc.createTextNode("3"));
        node.appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Жилая многоэтажная застройка квартала 4.15.1 в границах улиц Краснолесья - Рябинина - Очеретина в Академическом районе г. Екатеринбурга"));
        node.appendChild(doc.createElement("Result")).appendChild(doc.createTextNode("1"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.previous_conclusions(" +
                "previous_conclusion_value, date_value, number_value, " +
                "egrz_value, examination_object_type_value, name_value, " +
                "result_value, name_company, name_file) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", "",
                TextDate, "", "66-2-1-3-049345-2020", "3",
                "Жилая многоэтажная застройка квартала 4.15.1 в границах " +
                        "улиц Краснолесья - Рябинина - Очеретина в " +
                        "Академическом районе г. Екатеринбурга",
                "1", NameCompany, IdFile);
        return node;
    }
}