package com.xml_project_be.xml_project.file.xml_file;

import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GetExperts {
    public static ArrayList<Object> getExpertsFE(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select expert_value from xml_project.public.experts_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size();
        for (int i = 0; i < object_item_1; i++) {
            // expert_value
            arrayList1.put("name_" + i + "_expert_value", jdbcTemplate.queryForList("select * from xml_project.public.experts_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("expert_value").toString());
            // family_name_value
            arrayList1.put("name_" + i + "_family_name_value", jdbcTemplate.queryForList("select * from xml_project.public.experts_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("family_name_value").toString());
            // first_name_value
            arrayList1.put("name_" + i + "_first_name_value", jdbcTemplate.queryForList("select * from xml_project.public.experts_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("first_name_value").toString());
            // second_name_value
            arrayList1.put("name_" + i + "_second_name_value", jdbcTemplate.queryForList("select * from xml_project.public.experts_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("second_name_value").toString());
            // expert_type_value
            arrayList1.put("name_" + i + "_expert_type_value", jdbcTemplate.queryForList("select * from xml_project.public.experts_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("expert_type_value").toString());
            // expert_certificate_value
            arrayList1.put("name_" + i + "_expert_certificate_value", jdbcTemplate.queryForList("select * from xml_project.public.experts_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("expert_certificate_value").toString());
            // expert_certificate_begindate_value
            arrayList1.put("name_" + i + "_expert_certificate_begindate_value", jdbcTemplate.queryForList("select * from xml_project.public.experts_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("expert_certificate_begindate_value").toString());
            // expert_certificate_end_date_value
            arrayList1.put("name_" + i + "_expert_certificate_end_date_value", jdbcTemplate.queryForList("select * from xml_project.public.experts_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("expert_certificate_end_date_value").toString());
            // id_transaction
            arrayList1.put("name_" + i + "_id_transaction", jdbcTemplate.queryForList("select * from xml_project.public.experts_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("id_transaction").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select expert_value from xml_project.public.experts_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getExperts(
            Document doc,
            String DEST_WORD,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("Experts");
        File file = new File(DEST_WORD);
        com.spire.doc.Document document = new com.spire.doc.Document();
        document.loadFromFile(DEST_WORD);
        if (!file.exists()) {
            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(" +
                            "select * from xml_project.public.experts_object_xml " +
                            "where expert_value=? and  family_name_value=? and " +
                            "first_name_value=? and second_name_value=? and " +
                            "expert_type_value=? and expert_certificate_value=? " +
                            "and " +
                            "expert_certificate_begindate_value=? and " +
                            "expert_certificate_end_date_value=? and " +
                            "name_company=? and id_file=?)", Boolean.class,
                    "Файл не найден", "Файл не найден", "Файл не найден", "Файл не найден",
                    "Файл не найден", "Файл не найден", "Файл не найден", "Файл не найден",
                    NameCompany, IdFile))
            ) {
                jdbcTemplate.update("insert into " +
                                "xml_project.public.experts_object_xml(expert_value, " +
                                "family_name_value, first_name_value, second_name_value, " +
                                "expert_type_value, expert_certificate_value, " +
                                "expert_certificate_begindate_value, " +
                                "expert_certificate_end_date_value," +
                                "name_company, id_file, id_transaction) VALUES (?, ?, ?, ?, ?, " +
                                "?, ?, ?, ?, ?, ?)",
                        "Файл не найден", "Файл не найден", "Файл не найден", "Файл не найден",
                        "Файл не найден", "Файл не найден", "Файл не найден", "Файл не найден",
                        NameCompany, IdFile, UUID.randomUUID());
            }
            return node;
        } else {
            if (document.getSections().getCount() > 0 && document.getSections().get(0).getParagraphs().getCount() > 0) {
                String GetTextFile = String.valueOf(document.getChildObjects().get(0).getDocument().getText());
                System.out.println(GetTextFile);
            } else return node;
            node.appendChild(doc.createElement("Expert")).appendChild(doc.createElement("FamilyName")).appendChild(doc.createTextNode("Матвеев"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("FirstName")).appendChild(doc.createTextNode("Алексей"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("SecondName")).appendChild(doc.createTextNode("Александрович"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertType")).appendChild(doc.createTextNode("Нет данных"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificate")).appendChild(doc.createTextNode("МС-Э-1-10-13222"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificateBeginDate")).appendChild(doc.createTextNode("2020-01-29"));
            node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificateEndDate")).appendChild(doc.createTextNode("2025-01-29"));
            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(" +
                "select * from xml_project.public.experts_object_xml " +
                "where expert_value=? and family_name_value=? and first_name_value=? and " +
                            "second_name_value=? and " +
                "expert_type_value=? and expert_certificate_value=? and " +
                "expert_certificate_begindate_value=? and " +
                "expert_certificate_end_date_value=? and " +
                "name_company=? and id_file=?)", Boolean.class,
                    "Файл не найден", "Файл не найден", "Файл не найден",
                    "Файл не найден",
                    "Файл не найден", "Файл не найден", "Файл не найден",
                    "Файл не найден",
                    NameCompany, IdFile))
            ) {
                jdbcTemplate.update("insert into " +
                                "xml_project.public.experts_object_xml(expert_value, " +
                                "family_name_value, first_name_value, second_name_value, " +
                                "expert_type_value, expert_certificate_value, " +
                                "expert_certificate_begindate_value, " +
                                "expert_certificate_end_date_value," +
                                "name_company, id_file, id_transaction) VALUES (?, ?, ?, ?, ?, " +
                                "?, ?, ?, ?, ?, ?)",
                        "Файл не найден", "Файл не найден",
                        "Файл не найден", "Файл не найден",
                        "Файл не найден", "Файл не найден", "Файл не найден",
                        "Файл не найден",
                        NameCompany, IdFile, UUID.randomUUID());
            }
        }
        return node;
    }
}