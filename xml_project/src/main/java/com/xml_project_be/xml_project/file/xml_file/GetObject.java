package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GetObject {
    public static ArrayList<Object> getObjectFE (
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select name_value from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).size();
        for (int i = 1; i < object_item_1; i++) {
            // name_value
            arrayList1.put("name_"+i+"_name_value", jdbcTemplate.queryForList("select * from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("name_value").toString());
            // type_value
            arrayList1.put("name_"+i+"_type_value", jdbcTemplate.queryForList("select * from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("type_value").toString());
            // functions_value
            arrayList1.put("name_"+i+"_functions_value", jdbcTemplate.queryForList("select * from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("functions_value").toString());
            // country_value
            arrayList1.put("name_"+i+"_country_value", jdbcTemplate.queryForList("select * from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("country_value").toString());
            // region_value
            arrayList1.put("name_"+i+"_region_value", jdbcTemplate.queryForList("select * from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("region_value").toString());
            // city_value
            arrayList1.put("name_"+i+"_city_value", jdbcTemplate.queryForList("select * from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("city_value").toString());
            // note_value
            arrayList1.put("name_"+i+"_note_value", jdbcTemplate.queryForList("select * from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("note_value").toString());
            // tei_name_value
            arrayList1.put("name_"+i+"_tei_name_value", jdbcTemplate.queryForList("select * from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("tei_name_value").toString());
            // tei_measure_value
            arrayList1.put("name_"+i+"_tei_measure_value", jdbcTemplate.queryForList("select * from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("tei_measure_value").toString());
            // tei_value_value
            arrayList1.put("name_"+i+"_tei_value_value", jdbcTemplate.queryForList("select * from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("tei_value_value").toString());
            // id_transaction
            arrayList1.put("name_"+i+"_id_transaction", jdbcTemplate.queryForList("select * from xml_project.public.approver_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("id_transaction").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select name_value from xml_project.public.object_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getObject(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("Object");
        node.appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Type")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Functions")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Address")).appendChild(doc.createElement("Country")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Note")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("TEI")).appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("TEI").item(0).appendChild(doc.createElement("Measure")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("TEI").item(0).appendChild(doc.createElement("Value")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.object_object_xml(name_value, " +
                "type_value, " +
                "functions_value, country_value, " +
                        "region_value, " +
                "city_value, note_value, tei_name_value, " +
                        "tei_measure_value, " +
                "tei_value_value, name_company, id_file, id_transaction) VALUES (?, " +
                        "?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)","Данных нет",
                "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", NameCompany, IdFile, UUID.randomUUID());
        return node;
    }
}