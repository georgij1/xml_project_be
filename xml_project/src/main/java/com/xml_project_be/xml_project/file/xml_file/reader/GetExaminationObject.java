package com.xml_project_be.xml_project.file.xml_file.reader;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.util.UUID;

import static com.xml_project_be.xml_project.file.xml_file.reader.put_data.GetOrgElementsValueTXT.getOrgElementsValueTXT;

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
            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select " +
                            "exists(select * from " +
                            "xml_project.public.examination_object_object_xml " +
                            "where examination_form_value=? and " +
                            "examination_result_value=? and examination_object_type_value=?" +
                            "and examination_type_value=? and construction_type_value=?" +
                            "and examination_stage_value=? and " +
                            "name_value=? and name_company=? and " +
                            "id_file=?)",
                    Boolean.class,
                    "Файл не найден",
                    "Файл не найден", "Файл не найден",
                    "Файл не найден", "Файл не найден",
                    "Файл не найден", "Файл не найден",
                    NameCompany,
                    IdFile))) {
                jdbcTemplate.update("insert into xml_project.public.examination_object_object_xml(examination_form_value, " +
                                "examination_result_value, examination_object_type_value, examination_type_value, construction_type_value, examination_stage_value, " +
                                "name_value, name_company, id_file, id_transaction) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                        "Файл не найден",
                        "Файл не найден", "Файл не найден",
                        "Файл не найден", "Файл не найден",
                        "Файл не найден", "Файл не найден",
                        NameCompany,
                        IdFile, UUID.randomUUID());
            }
        } else {
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ExaminationForm", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ExaminationResult", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ExaminationObjectType", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ExaminationType", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ConstructionType", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "ExaminationStage", "Данные не указаны"));
            ExaminationObject.appendChild(getOrgElementsValueTXT(doc, "Name", "Данные не указаны"));
            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select " +
                            "exists(select * from " +
                            "xml_project.public.examination_object_object_xml " +
                            "where examination_form_value=? and " +
                            "examination_result_value=? and examination_object_type_value=?" +
                            "and examination_type_value=? and construction_type_value=?" +
                            "and examination_stage_value=? and " +
                            "name_value=? and name_company=? and " +
                            "id_file=?)",
                    Boolean.class,
                    "Данные не указаны",
                    "Данные не указаны", "Данные не указаны",
                    "Данные не указаны", "Данные не указаны",
                    "Данные не указаны", "Данные не указаны",
                    NameCompany,
                    IdFile))) {
                jdbcTemplate.update("insert into xml_project.public.examination_object_object_xml(examination_form_value, " +
                                "examination_result_value, examination_object_type_value, examination_type_value, construction_type_value, examination_stage_value, " +
                                "name_value, name_company, id_file, id_transaction) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                        "Данные не указаны",
                        "Данные не указаны", "Данные не указаны",
                        "Данные не указаны", "Данные не указаны",
                        "Данные не указаны", "Данные не указаны",
                        NameCompany,
                        IdFile, UUID.randomUUID());
            }
        }
        return ExaminationObject;
    }
}