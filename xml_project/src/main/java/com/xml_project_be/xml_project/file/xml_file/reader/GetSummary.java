package com.xml_project_be.xml_project.file.xml_file.reader;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GetSummary {
    public static ArrayList<Object> getSummaryFE(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select engineering_survey_type_value from xml_project.public.summary_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size();
        for (int i = 0; i < object_item_1; i++) {
            // engineering_survey_type_value
            arrayList1.put("name_" + i + "_engineering_survey_type_value", jdbcTemplate.queryForList("select * from xml_project.public.summary_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("engineering_survey_type_value").toString());
            // project_documents_summary_value
            arrayList1.put("name_" + i + "_project_documents_summary_value", jdbcTemplate.queryForList("select * from xml_project.public.summary_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("project_documents_summary_value").toString());
            // project_documents_summary_date_value
            arrayList1.put("name_" + i + "_project_documents_summary_date_value", jdbcTemplate.queryForList("select * from xml_project.public.summary_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("project_documents_summary_date_value").toString());
            // examination_summary_value
            arrayList1.put("name_" + i + "_examination_summary_value", jdbcTemplate.queryForList("select * from xml_project.public.summary_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("examination_summary_value").toString());
            // id_transaction
            arrayList1.put("name_" + i + "_id_transaction", jdbcTemplate.queryForList("select * from xml_project.public.summary_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("id_transaction").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select engineering_survey_type_value from xml_project.public.summary_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getSummary(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("Summary");
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("ProjectDocumentsSummary")).appendChild(doc.createTextNode("Данных нет"));
        if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(" +
                        "select * from xml_project.public.summary_object_xml " +
                        "where engineering_survey_type_value=? and " +
                        "project_documents_summary_value=? and " +
                        "project_documents_summary_date_value=? and " +
                        "examination_summary_value=? and name_company=? and " +
                        "id_file=?)", Boolean.class,
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                NameCompany, IdFile))
        ) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.summary_object_xml(" +
                            "engineering_survey_type_value, " +
                            "project_documents_summary_value, " +
                            "project_documents_summary_date_value, " +
                            "examination_summary_value, name_company, " +
                            "id_file, id_transaction) VALUES (?, ?, ?, ?, ?, ?, ?)",
                    "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                    NameCompany, IdFile, UUID.randomUUID());
        }
        return node;
    }
}