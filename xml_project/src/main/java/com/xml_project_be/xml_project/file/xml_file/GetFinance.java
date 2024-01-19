package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class GetFinance {
    public static ArrayList<Object> getFinanceFE (
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select finance_type from xml_project.public.finance_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).size();
        for (int i = 1; i < object_item_1; i++) {
            // finance_type
            arrayList1.put("name_"+i+"_finance_type", jdbcTemplate.queryForList("select * from xml_project.public.finance_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("finance_type").toString());
            // finance_size
            arrayList1.put("name_"+i+"_finance_size", jdbcTemplate.queryForList("select * from xml_project.public.finance_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("finance_size").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select finance_type from xml_project.public.finance_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getFinance(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("Finance");
        node.appendChild(doc.createElement("FinanceType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("FinanceSize")).appendChild(doc.createTextNode("Данных нет"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.finance_object_xml(finance_type, " +
                "finance_size, name_company, name_file) " +
                "VALUES (?, ?, ?, ?)", "Данных нет", "Данных нет", NameCompany, IdFile);
        return node;
    }
}