package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class GetOrgElementsValueFunc_PreviousConsultation {
    public static ArrayList<Object> getPreviousConclusionsFE (
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select previous_conclusion_value from xml_project.public.previous_conclusions where name_file=? and name_company=?", IdFile.toString(), NameCompany).size();
        for (int i = 1; i < object_item_1; i++) {
            // previous_conclusion_value
            arrayList1.put("name_"+i+"_previous_conclusion_value", jdbcTemplate.queryForList("select * from xml_project.public.previous_conclusions where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("previous_conclusion_value").toString());
            // date_value
            arrayList1.put("name_"+i+"_date_value", jdbcTemplate.queryForList("select * from xml_project.public.previous_conclusions where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("date_value").toString());
            // number_value
            arrayList1.put("name_"+i+"_number_value", jdbcTemplate.queryForList("select * from xml_project.public.previous_conclusions where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("number_value").toString());
            // egrz_value
            arrayList1.put("name_"+i+"_egrz_value", jdbcTemplate.queryForList("select * from xml_project.public.previous_conclusions where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("doc_number_value").toString());
            // examination_object_type_value
            arrayList1.put("name_"+i+"_examination_object_type_value", jdbcTemplate.queryForList("select * from xml_project.public.previous_conclusions where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("examination_object_type_value").toString());
            // name_value
            arrayList1.put("name_"+i+"_name_value", jdbcTemplate.queryForList("select * from xml_project.public.previous_conclusions where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("name_value").toString());
            // result_value
            arrayList1.put("name_"+i+"_result_value", jdbcTemplate.queryForList("select * from xml_project.public.previous_conclusions where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("result_value").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select previous_conclusion_value from xml_project.public.previous_conclusions where name_file=? and name_company=?", IdFile.toString(), NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getOrgElementsValueFunc_PreviousConsultation(
            org.w3c.dom.Document doc,
            String PreviousConclusion,
            String Date,
            String TextDate,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement(PreviousConclusion);
        node.appendChild(doc.createElement(Date)).appendChild(doc.createTextNode(TextDate));
        node.appendChild(doc.createElement("Number")).appendChild(doc.createElement("EGRZ")).appendChild(doc.createTextNode("66-2-1-3-049345-2020"));
        node.appendChild(doc.createElement("ExaminationObjectType")).appendChild(doc.createTextNode("3"));
        node.appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Жилая многоэтажная застройка квартала 4.15.1 в границах улиц Краснолесья - Рябинина - Очеретина в Академическом районе г. Екатеринбурга"));
        node.appendChild(doc.createElement("Result")).appendChild(doc.createTextNode("1"));
        jdbcTemplate.update("insert into " +
                "xml_project.public.previous_conclusions(" +
                "previous_conclusion_value, date_value, number_value, " +
                "egrz_value, examination_object_type_value, name_value, " +
                "result_value, name_company, name_file) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", "",
                TextDate, "", "66-2-1-3-049345-2020", "3",
                "Жилая многоэтажная застройка квартала 4.15.1 в границах " +
                        "улиц Краснолесья - Рябинина - Очеретина в " +
                        "Академическом районе г. Екатеринбурга",
                "1", NameCompany, IdFile);
        return node;
    }
}