package com.xml_project_be.xml_project.file.xml_file.reader;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetOrgElementsValueFunc_PreviousConsultation.getOrgElementsValueFunc_PreviousConsultation;

public class GetPreviousConclusions {
    public static Node getPreviousConclusions(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element PreviousConclusions = doc.createElement("PreviousConclusions");
        PreviousConclusions.appendChild(getOrgElementsValueFunc_PreviousConsultation(
                doc,
                "PreviousConclusion",
                "Date",
                "2020-10-02",
                NameCompany,
                IdFile,
                jdbcTemplate
        ));
        return PreviousConclusions;
    }
}