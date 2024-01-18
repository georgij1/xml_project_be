package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import static com.xml_project_be.xml_project.file.xml_file.GetPreviousSimpleConclusion.getPreviousSimpleConclusion;

public class GetPreviousSimpleConclusions {
    public static Node getPreviousSimpleConclusions(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element PreviousSimpleConclusions = doc.createElement("PreviousSimpleConclusions");
        PreviousSimpleConclusions.appendChild(getPreviousSimpleConclusion(doc, NameCompany, IdFile, jdbcTemplate));
        return PreviousSimpleConclusions;
    }
}