package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import static com.xml_project_be.xml_project.file.xml_file.GetOrgElementsValueFunc_7.getOrgElementsValueFunc_7;

public class GetDocuments {
    public static ArrayList<Object> getDocumentsFE (
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select document_value from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).size();
        for (int i = 1; i < object_item_1; i++) {
            // document_value
            arrayList1.put("name_"+i+"_document_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("document_value").toString());
            // doc_type_value
            arrayList1.put("name_"+i+"_doc_type_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("doc_type_value").toString());
            // doc_name_value
            arrayList1.put("name_"+i+"_doc_name_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("doc_name_value").toString());
            // doc_number_value
            arrayList1.put("name_"+i+"_doc_number_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("doc_number_value").toString());
            // doc_date_value
            arrayList1.put("name_"+i+"_doc_date_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("doc_date_value").toString());
            // doc_issue_author_value
            arrayList1.put("name_"+i+"_doc_issue_author_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("doc_issue_author_value").toString());
            // file_value
            arrayList1.put("name_"+i+"_file_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("file_value").toString());
            // file_name_value
            arrayList1.put("name_"+i+"_file_name_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("file_name_value").toString());
            // file_format_value
            arrayList1.put("name_"+i+"_file_format_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("file_format_value").toString());
            // file_checksum_value
            arrayList1.put("name_"+i+"_file_checksum_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("file_checksum_value").toString());
            // file_name_1_value
            arrayList1.put("name_"+i+"_file_name_1_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("file_name_1_value").toString());
            // file_format_1_value
            arrayList1.put("name_"+i+"_file_format_1_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("file_format_1_value").toString());
            // file_checksum_1_value
            arrayList1.put("name_"+i+"_file_checksum_1_value", jdbcTemplate.queryForList("select * from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("file_checksum_1_value").toString());
            // id_transaction
            arrayList1.put("name_"+i+"_id_transaction", jdbcTemplate.queryForList("select * from xml_project.public.approver_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("id_transaction").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select file_checksum_1_value from xml_project.public.documents_object_xml where id_file=? and name_company=?", IdFile.toString(), NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getDocuments(
            Document doc,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element Documents = doc.createElement("Documents");
        Documents.appendChild(getOrgElementsValueFunc_7(
                doc
        ));
        jdbcTemplate.update("insert into " +
                "xml_project.public.documents_object_xml(document_value, " +
                "doc_type_value, doc_name_value, doc_number_value, " +
                "doc_date_value, doc_issue_author_value, file_value, " +
                "file_name_value, file_format_value, file_checksum_value, " +
                "file_name_1_value, file_format_1_value, file_checksum_1_value, " +
                "name_company, id_file, id_transaction) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                "Данных нет", "01.01", "Заявление на заключение договора на " +
                        "экспертное сопровождение в отношении проектной " +
                        "документации объекта капитального строительства",
                "43/261", "2022-04-01", "ООО «Специализированный " +
                        "застройщик «Лидер констракшн»", "Данных нет", "Заявление " +
                        "о заключении договора.pdf", "pdf", "eebbdb54",
                "Заявление о заключении договора.pdf.sig", "sig", "3718b4c5", NameCompany, IdFile, UUID.randomUUID());
        return Documents;
    }
}