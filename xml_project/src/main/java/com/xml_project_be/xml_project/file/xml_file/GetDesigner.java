package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GetDesigner {
    public static ArrayList<Object> getDesignerFE (
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select ip_value from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size();
        for (int i = 0; i < object_item_1; i++) {
            // ip_value
            arrayList1.put("name_"+i+"_ip_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("ip_value").toString());
            // family_name_value
            arrayList1.put("name_"+i+"_family_name_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("family_name_value").toString());
            // first_name_value
            arrayList1.put("name_"+i+"_first_name_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("first_name_value").toString());
            // second_name_value
            arrayList1.put("name_"+i+"_second_name_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("second_name_value").toString());
            // ogrnip_value
            arrayList1.put("name_"+i+"_ogrnip_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("ogrnip_value").toString());
            // post_address_value
            arrayList1.put("name_"+i+"_post_address_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("post_address_value").toString());
            // country_value
            arrayList1.put("name_"+i+"_country_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("country_value").toString());
            // region_value
            arrayList1.put("name_"+i+"_region_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("region_value").toString());
            // post_index_value
            arrayList1.put("name_"+i+"_post_index_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("post_index_value").toString());
            // city_value
            arrayList1.put("name_"+i+"_city_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("city_value").toString());
            // street_value
            arrayList1.put("name_"+i+"_street_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("street_value").toString());
            // building_value
            arrayList1.put("name_"+i+"_building_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("building_value").toString());
            // room_value
            arrayList1.put("name_"+i+"_room_value", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("room_value").toString());
            // id_transaction
            arrayList1.put("name_"+i+"_id_transaction", jdbcTemplate.queryForList("select * from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("id_transaction").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select ip_value from xml_project.public.designer_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getDesigner(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("Designer");
        node.setAttribute("General", "нет");
        node.appendChild(doc.createElement("IP")).appendChild(doc.createElement("FamilyName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("FirstName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("SecondName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("OGRNIP")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("PostAddress")).appendChild(doc.createElement("Country")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("PostIndex")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("Данных нет"));
        if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(" +
                        "select * from xml_project.public.designer_object_xml " +
                        "where ip_value=? and " +
                        "family_name_value=? and " +
                        "first_name_value=? and second_name_value=? and " +
                        "ogrnip_value=? and post_address_value=? and country_value=? and " +
                        "region_value=? and " +
                        "post_index_value=? and city_value=? and " +
                        "street_value=? and building_value=? and " +
                        "room_value=? and name_company=? and id_file=?)", Boolean.class,
                "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                "Данных нет", "Данных нет", NameCompany, IdFile))
        ) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.designer_object_xml(ip_value, " +
                            "family_name_value, first_name_value, second_name_value, " +
                            "ogrnip_value, post_address_value, country_value, region_value, " +
                            "post_index_value, city_value, street_value, building_value, " +
                            "room_value, name_company, id_file, id_transaction) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    "Данных нет", "Данных нет", "Данных нет",
                    "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                    "Данных нет", "Данных нет", "Данных нет", "Данных нет",
                    "Данных нет", "Данных нет", NameCompany, IdFile,
                    UUID.randomUUID());
        }
        return node;
    }
}