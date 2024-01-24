package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.util.UUID;

import static com.xml_project_be.xml_project.file.xml_file.put_data.GetOrgElementsValueTXT.getOrgElementsValueTXT;

public class GetExaminationObject {
    public static Node getExaminationObject(
            org.w3c.dom.Document doc,
            String DEST_WORD,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element ExaminationObject = doc.createElement("ExaminationObject");
        File file = new File(DEST_WORD);

        if (!file.exists()) {
            System.out.println("File not found: " + DEST_WORD);
            jdbcTemplate.update("insert into xml_project.public.documents_object_xml(document_value, " +
                            "doc_type_value, doc_name_value, doc_number_value, doc_date_value, doc_issue_author_value, " +
                            "file_value, file_name_value, file_format_value, file_checksum_value, file_name_1_value, " +
                            "file_format_1_value, file_checksum_1_value, name_company, " +
                            "id_file, id_transaction) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    "Файл не найден",
                    "Файл не найден", "Файл не найден", "Файл не найден", "Файл не найден",
                    "Файл не найден", "Файл не найден", "Файл не найден", "Файл не найден",
                    "Файл не найден", "Файл не найден", "Файл не найден", "Файл не найден", NameCompany,
                    IdFile, UUID.randomUUID());
        } else {
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ExaminationForm", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ExaminationResult", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ExaminationObjectType", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ExaminationType", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ConstructionType", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ExaminationStage", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "Name", "Данные не указаны"));
            jdbcTemplate.update("insert into xml_project.public.documents_object_xml(document_value, " +
                            "doc_type_value, doc_name_value, doc_number_value, doc_date_value, doc_issue_author_value, " +
                            "file_value, file_name_value, file_format_value, file_checksum_value, file_name_1_value, " +
                            "file_format_1_value, file_checksum_1_value, name_company, " +
                            "id_file, id_transaction) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", "Данные не указаны",
                    "Данные не указаны", "Данные не указаны", "Данные не указаны", "Данные не указаны",
                    "Данные не указаны", "Данные не указаны", "Данные не указаны", "Данные не указаны",
                    "Данные не указаны", "Данные не указаны", "Данные не указаны", "Данные не указаны", NameCompany,
                    IdFile, UUID.randomUUID());
        }
        return ExaminationObject;
    }
}