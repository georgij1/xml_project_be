package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import static com.xml_project_be.xml_project.file.xml_file.GetOrgElementsValueFunc_7.getOrgElementsValueFunc_7;

public class GetDocuments {
    public static Node getDocuments(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element Documents = doc.createElement("Documents");
        Documents.appendChild(getOrgElementsValueFunc_7(
                doc
        ));
        jdbcTemplate.update("insert into " +
                "xml_project.public.documents_object_xml(document_value, " +
                "doc_type_value, doc_name_value, doc_number_value, " +
                "doc_date_value, doc_issue_author_value, file_value, " +
                "file_name_value, file_format_value, file_checksum_value, " +
                "file_name_1_value, file_format_1_value, file_checksum_1_value, " +
                "name_company_value, name_file_value) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                "", "01.01", "Заявление на заключение договора на " +
                        "экспертное сопровождение в отношении проектной " +
                        "документации объекта капитального строительства",
                "43/261", "2022-04-01", "ООО «Специализированный " +
                        "застройщик «Лидер констракшн»", "", "Заявление " +
                        "о заключении договора.pdf", "pdf", "eebbdb54",
                "Заявление о заключении договора.pdf.sig", "sig", "3718b4c5", NameCompany, IdFile);
        return Documents;
    }
}