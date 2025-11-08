package com.xml_project_be.xml_project.file.xml_file.reader;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GetExpertProjectDocuments {
    public static ArrayList<Object> getExpertProjectDocumentsFE (
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select project_documents_review from xml_project.public.expert_project_documents_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size();
        for (int i = 0; i < object_item_1; i++) {
            // project_documents_review
            arrayList1.put("name_"+i+"_project_documents_review", jdbcTemplate.queryForList("select * from xml_project.public.expert_project_documents_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("project_documents_review").toString());
            // id_transaction
            arrayList1.put("name_"+i+"_id_transaction", jdbcTemplate.queryForList("select * from xml_project.public.expert_project_documents_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("id_transaction").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select project_documents_review from xml_project.public.expert_project_documents_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getExpertProjectDocuments(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("ExpertProjectDocuments");
        node.setAttribute("ExpertType", "Данных нет");
        node.appendChild(doc.createElement("ProjectDocumentsReview")).appendChild(doc.createTextNode("Данных нет"));
        if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(" +
            "select * from xml_project.public.expert_project_documents_object_xml " +
            "where project_documents_review=? and " +
            "name_company=? and " +
            "id_file=?)", Boolean.class,
                "Данных нет", NameCompany, IdFile))
        ) {
            jdbcTemplate.update("insert into " +
                            "xml_project.public.expert_project_documents_object_xml(" +
                            "project_documents_review, name_company, " +
                            "id_file, id_transaction) VALUES (?, ?, ?, ?)", "Данных нет",
                    NameCompany, IdFile, UUID.randomUUID());
        }
        return node;
    }
}