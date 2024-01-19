package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class GetPreviousSimpleConclusion {
    public static ArrayList<Object> getPreviousSimpleConclusionsFE (
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select previous_simple_conclusion_value from xml_project.public.previous_simple_conclusions_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).size();
        for (int i = 1; i < object_item_1; i++) {
            // previous_conclusion_value
            arrayList1.put("name_"+i+"_previous_conclusion_value", jdbcTemplate.queryForList("select * from xml_project.public.previous_simple_conclusions_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("previous_conclusion_value").toString());
            // date_value
            arrayList1.put("name_"+i+"_date_value", jdbcTemplate.queryForList("select * from xml_project.public.previous_simple_conclusions_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("date_value").toString());
            // number_value
            arrayList1.put("name_"+i+"_number_value", jdbcTemplate.queryForList("select * from xml_project.public.previous_simple_conclusions_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("number_value").toString());
            // result_value
            arrayList1.put("name_"+i+"_result_value", jdbcTemplate.queryForList("select * from xml_project.public.previous_simple_conclusions_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("result_value").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select previous_simple_conclusion_value from xml_project.public.previous_simple_conclusions_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getPreviousSimpleConclusion(
            org.w3c.dom.Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("PreviousSimpleConclusion");
        node.appendChild(doc.createElement("Date")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Number")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Result")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.previous_simple_conclusions_object_xml(" +
                "previous_simple_conclusion_value, date_value, number_value, " +
                "result_value, name_company, name_file) " +
                "VALUES (?, ?, ?, ?, ?, ?)", "", "Данных нет", "Данных нет", "Данных нет", NameCompany, IdFile);
        return node;
    }
}