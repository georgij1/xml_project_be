package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GetProjectDocumentsDeveloper {
    public static ArrayList<Object> getProjectDocumentsDeveloperFE(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select organization_value from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size();
        for (int i = 0; i < object_item_1; i++) {
            // organization_value
            arrayList1.put("name_" + i + "_organization_value", jdbcTemplate.queryForList("select * from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("organization_value").toString());
            // org_full_name_value
            arrayList1.put("name_" + i + "_org_full_name_value", jdbcTemplate.queryForList("select * from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("org_full_name_value").toString());
            // org_ogrn_value
            arrayList1.put("name_" + i + "_org_ogrn_value", jdbcTemplate.queryForList("select * from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("org_ogrn_value").toString());
            // org_inn_value
            arrayList1.put("name_" + i + "_org_inn_value", jdbcTemplate.queryForList("select * from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("org_inn_value").toString());
            // org_kpp_value
            arrayList1.put("name_" + i + "_org_kpp_value", jdbcTemplate.queryForList("select * from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("org_kpp_value").toString());
            // region_value
            arrayList1.put("name_" + i + "_region_value", jdbcTemplate.queryForList("select * from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("region_value").toString());
            // city_value
            arrayList1.put("name_" + i + "_city_value", jdbcTemplate.queryForList("select * from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("city_value").toString());
            // street_value
            arrayList1.put("name_" + i + "_street_value", jdbcTemplate.queryForList("select * from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("street_value").toString());
            // building_value
            arrayList1.put("name_" + i + "_building_value", jdbcTemplate.queryForList("select * from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("building_value").toString());
            // room_value
            arrayList1.put("name_" + i + "_room_value", jdbcTemplate.queryForList("select * from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("room_value").toString());
            // id_transaction
            arrayList1.put("name_" + i + "_id_transaction", jdbcTemplate.queryForList("select * from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("id_transaction").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select organization_value from xml_project.public.project_documents_developer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getProjectDocumentsDeveloper(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("ProjectDocumentsDeveloper");
        node.appendChild(doc.createElement("Organization")).appendChild(doc.createElement("OrgFullName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgOGRN")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgINN")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgKPP")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("Данных нет"));
        if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select " +
                        "exists(select * from " +
                        "xml_project.public.project_documents_developer_object_xml " +
                        "where organization_value=? and " +
                        "org_full_name_value=? and org_ogrn_value=? and " +
                        "org_inn_value=? and " +
                        "org_kpp_value=? and " +
                        "region_value=? and " +
                        "city_value=? and " +
                        "street_value=? and building_value=? and room_value=? " +
                        "and " +
                        "name_company=? and id_file=?)",
                Boolean.class,
                "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", NameCompany, IdFile))) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.project_documents_developer_object_xml(" +
                            "organization_value, org_full_name_value, org_ogrn_value, " +
                            "org_inn_value, org_kpp_value, region_value, " +
                            "city_value, street_value, building_value, room_value, " +
                            "name_company, id_file, id_transaction) VALUES (?, ?, ?, ?, ?, " +
                            "?, ?, ?, ?, ?, ?, ?, ?)", "Данных нет", "Данных нет",
                    "Данных нет", "Данных нет", "Данных нет",
                    "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                    "Данных нет", NameCompany, IdFile, UUID.randomUUID());
        }
        return node;
    }
}