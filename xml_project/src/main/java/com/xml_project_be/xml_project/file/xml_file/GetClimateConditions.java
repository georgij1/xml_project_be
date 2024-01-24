package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GetClimateConditions {
    public static ArrayList<Object> getClimateConditionsFE(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select climate_district_value from xml_project.public.climate_conditions_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).size();
        for (int i = 1; i < object_item_1; i++) {
            // climate_district_value
            arrayList1.put("name_" + i + "_climate_district_value", jdbcTemplate.queryForList("select * from xml_project.public.climate_conditions_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("climate_district_value").toString());
            // geological_conditions_value
            arrayList1.put("name_" + i + "_geological_conditions_value", jdbcTemplate.queryForList("select * from xml_project.public.climate_conditions_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("geological_conditions_value").toString());
            // wind_district_value
            arrayList1.put("name_" + i + "_wind_district_value", jdbcTemplate.queryForList("select * from xml_project.public.climate_conditions_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("wind_district_value").toString());
            // snow_district_value
            arrayList1.put("name_" + i + "_snow_district_value", jdbcTemplate.queryForList("select * from xml_project.public.climate_conditions_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("snow_district_value").toString());
            // seismic_activity_value
            arrayList1.put("name_" + i + "_seismic_activity_value", jdbcTemplate.queryForList("select * from xml_project.public.climate_conditions_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("seismic_activity_value").toString());
            // id_transaction
            arrayList1.put("name_" + i + "_id_transaction", jdbcTemplate.queryForList("select * from xml_project.public.approver_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("id_transaction").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select climate_district_value from xml_project.public.climate_conditions_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getClimateConditions(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("ClimateConditions");
        node.appendChild(doc.createElement("ClimateDistrict")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("GeologicalConditions")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("WindDistrict")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("SnowDistrict")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("SeismicActivity")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into xml_project.public.climate_conditions_object_xml(climate_district_value, " +
                        "geological_conditions_value, wind_district_value, snow_district_value, seismic_activity_value, " +
                        "name_company, id_file, id_transaction) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", "Данных нет",
                "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", NameCompany, IdFile, UUID.randomUUID());
        return node;
    }
}