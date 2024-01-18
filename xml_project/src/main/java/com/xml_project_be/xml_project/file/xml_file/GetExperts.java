package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;

public class GetExperts {
    public static Node getExperts(
            Document doc,
            String DEST_WORD,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("Experts");
        File file = new File(DEST_WORD);
        com.spire.doc.Document document = new com.spire.doc.Document();
        document.loadFromFile(DEST_WORD);
        if (!file.exists()) {
            jdbcTemplate.update("insert into " +
                    "xml_project.public.expert_project_documents_object_xml(" +
                    "project_documents_review, name_company, " +
                    "name_file) VALUES (?, ?, ?)", "Файл не найден", NameCompany, IdFile);
            return node;
        } else {
            if (document.getSections().getCount() > 0 && document.getSections().get(0).getParagraphs().getCount() > 0) {
                String GetTextFile = String.valueOf(document.getChildObjects().get(0).getDocument().getText());
                System.out.println(GetTextFile);
            }

            else {
                System.out.println("Not found string");
                return node;
            }

            node.appendChild(doc.createElement("Expert")).appendChild(doc.createElement("FamilyName")).appendChild(doc.createTextNode("Матвеев"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("FirstName")).appendChild(doc.createTextNode("Алексей"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("SecondName")).appendChild(doc.createTextNode("Александрович"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertType")).appendChild(doc.createTextNode("Нет данных"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificate")).appendChild(doc.createTextNode("МС-Э-1-10-13222"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificateBeginDate")).appendChild(doc.createTextNode("2020-01-29"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificateEndDate")).appendChild(doc.createTextNode("2025-01-29"));
            jdbcTemplate.update("insert into " +
                    "xml_project.public.experts_object_xml(expert_value, " +
                    "family_name_value, first_name_value, second_name_value, " +
                    "expert_type_value, expert_certificate_value, " +
                    "expert_certificate_begindate_value, " +
                    "expert_certificate_end_date_value," +
                    "name_company, name_file) VALUES (?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?)", "", "Матвеев", "Алексей", "Александрович", "Нет данных", "МС-Э-1-10-13222", "2020-01-29", "2025-01-29", NameCompany, IdFile);
        }
        return node;
    }
}