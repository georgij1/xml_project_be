package com.xml_project_be.xml_project.file.xml_file.reader;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import static com.xml_project_be.xml_project.file.xml_file.reader.put_data.GetOrgElementsValueTXT.getOrgElementsValueTXT;

public class GetExaminationObject {
    public static ArrayList<Object> getExaminationObjectFE(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();

        // examination_form_value
        int object_item_1 = jdbcTemplate.queryForList("select examination_form_value from xml_project.public.examination_object_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size();
        System.out.println(object_item_1);
        for (int i = 0; i < object_item_1; i++) {
            // examination_form_value
            arrayList1.put("name_" + i + "_examination_form_value", jdbcTemplate.queryForList("select * from xml_project.public.examination_object_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("examination_form_value").toString());
            // examination_result_value
            arrayList1.put("name_" + i + "_examination_result_value", jdbcTemplate.queryForList("select * from xml_project.public.examination_object_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("examination_result_value").toString());
            // examination_object_type_value
            arrayList1.put("name_" + i + "_examination_object_type_value", jdbcTemplate.queryForList("select * from xml_project.public.examination_object_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("examination_object_type_value").toString());
            // examination_type_value
            arrayList1.put("name_" + i + "_examination_type_value", jdbcTemplate.queryForList("select * from xml_project.public.examination_object_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("examination_type_value").toString());
            // construction_type_value
            arrayList1.put("name_" + i + "_construction_type_value", jdbcTemplate.queryForList("select * from xml_project.public.examination_object_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("construction_type_value").toString());
            // examination_stage_value
            arrayList1.put("name_" + i + "_examination_stage_value", jdbcTemplate.queryForList("select * from xml_project.public.examination_object_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("examination_stage_value").toString());
            // name_value
            arrayList1.put("name_" + i + "_name_value", jdbcTemplate.queryForList("select * from xml_project.public.examination_object_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("name_value").toString());
            // id_transaction
            arrayList1.put("name_" + i + "_id_transaction", jdbcTemplate.queryForList("select * from xml_project.public.examination_object_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("id_transaction").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select examination_form_value from xml_project.public.examination_object_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        System.out.println(arrayList);
        return arrayList;
    }

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