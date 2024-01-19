package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class GetDeclarant {
    public static ArrayList<Object> getDeclarantFE (
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select organization_value from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).size();
        for (int i = 1; i < object_item_1; i++) {
            // organization_value
            arrayList1.put("name_"+i+"_organization_value", jdbcTemplate.queryForList("select * from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("organization_value").toString());
            // org_full_name_value
            arrayList1.put("name_"+i+"_org_full_name_value", jdbcTemplate.queryForList("select * from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("org_full_name_value").toString());
            // org_ogrn_value
            arrayList1.put("name_"+i+"_org_ogrn_value", jdbcTemplate.queryForList("select * from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("org_ogrn_value").toString());
            // org_inn_value
            arrayList1.put("name_"+i+"_org_inn_value", jdbcTemplate.queryForList("select * from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("org_inn_value").toString());
            // org_kpp_value
            arrayList1.put("name_"+i+"_org_kpp_value", jdbcTemplate.queryForList("select * from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("org_kpp_value").toString());
            // address_value
            arrayList1.put("name_"+i+"_address_value", jdbcTemplate.queryForList("select * from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("address_value").toString());
            // region_value
            arrayList1.put("name_"+i+"_region_value", jdbcTemplate.queryForList("select * from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("region_value").toString());
            // city_value
            arrayList1.put("name_"+i+"_city_value", jdbcTemplate.queryForList("select * from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("city_value").toString());
            // street_value
            arrayList1.put("name_"+i+"_street_value", jdbcTemplate.queryForList("select * from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("street_value").toString());
            // building_value
            arrayList1.put("name_"+i+"_building_value", jdbcTemplate.queryForList("select * from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("building_value").toString());
            // room_value
            arrayList1.put("name_"+i+"_room_value", jdbcTemplate.queryForList("select * from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("room_value").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select organization_value from xml_project.public.declarant_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getDeclarant (
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("Declarant");
        node.appendChild(doc.createElement("Organization")).appendChild(doc.createElement("OrgFullName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgOGRN")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgINN")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgKPP")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.declarant_object_xml(organization_value, " +
                "org_full_name_value, org_ogrn_value, org_inn_value, " +
                "org_kpp_value, address_value, region_value, city_value, " +
                "street_value, building_value, room_value, " +
                "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?)", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", NameCompany, IdFile);
        return node;
    }
}