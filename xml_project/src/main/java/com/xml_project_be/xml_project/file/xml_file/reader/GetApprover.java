package com.xml_project_be.xml_project.file.xml_file.reader;

import com.spire.doc.Document;
import com.spire.doc.collections.ParagraphCollection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

import static com.xml_project_be.xml_project.file.xml_file.reader.put_data.GetOrgElementsValueTXT.getOrgElementsValueTXT;

public class GetApprover {
    public static ArrayList<Object> getApproverFE(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();

        // org_full_name_value
        int object_item_1 = jdbcTemplate.queryForList("select family_name_value from xml_project.public.approver_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size();
        System.out.println(object_item_1);
        for (int i = 0; i < object_item_1; i++) {
            // family_name_value
            arrayList1.put("name_" + i + "_family_name_value", jdbcTemplate.queryForList("select * from xml_project.public.approver_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("family_name_value").toString());
            // first_name_value
            arrayList1.put("name_" + i + "_first_name_value", jdbcTemplate.queryForList("select * from xml_project.public.approver_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("first_name_value").toString());
            // second_name_value
            arrayList1.put("name_" + i + "_second_name_value", jdbcTemplate.queryForList("select * from xml_project.public.approver_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("second_name_value").toString());
            // position_value
            arrayList1.put("name_" + i + "_position_value", jdbcTemplate.queryForList("select * from xml_project.public.approver_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("position_value").toString());
            // id_transaction
            arrayList1.put("name_" + i + "_id_transaction", jdbcTemplate.queryForList("select * from xml_project.public.approver_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("id_transaction").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select family_name_value from xml_project.public.approver_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        System.out.println(arrayList);
        return arrayList;
    }

    public static Node getApprover(
            org.w3c.dom.Document doc,
            String DEST_WORD,
            String NameCompany,
            Integer IDFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element Approver = doc.createElement("Approver");
        File file = new File(DEST_WORD);
        if (!file.exists()) {
            System.out.println("File not found: " + DEST_WORD);
            Approver.appendChild(getOrgElementsValueTXT(doc, "FamilyName", "Файл не найден"));
            Approver.appendChild(getOrgElementsValueTXT(doc, "FirstName", "Файл не найден"));
            Approver.appendChild(getOrgElementsValueTXT(doc, "SecondName", "Файл не найден"));
            Approver.appendChild(getOrgElementsValueTXT(doc, "Position", "Файл не найден"));
            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select " +
                    "exists(select * from xml_project.public.approver_object_xml " +
                    "where family_name_value=? and second_name_value=? and " +
                    "position_value=? and id_file=? and name_company=?)",
                    Boolean.class, "Файл не найден", "Файл не найден",
                    "Файл не найден", IDFile, NameCompany
            ))) {
                jdbcTemplate.update("insert into " +
                                "xml_project.public.approver_object_xml(family_name_value, " +
                                "first_name_value, second_name_value, position_value, " +
                                "name_company, id_file, id_transaction) " +
                                "values (?, ?, ?, ?, ?, ?, ?)",
                        "Файл не найден", "Файл не найден", "Файл не найден", "Файл не найден",
                        IDFile, NameCompany, UUID.randomUUID());
            }
        } else {
            Document document = new Document();
            document.loadFromFile(DEST_WORD);
            if (document.getSections().getCount() > 0 && document.getSections().get(0).getParagraphs().getCount() > 0) {
                ParagraphCollection firstParagraph = document.getSections().get(0).getParagraphs();
                String position = firstParagraph.get(0).getText();
                System.out.println("position - " + position);
                String person = firstParagraph.get(16).getText();
                String[] infoPersonsArr = person.split(" ");
                System.out.println("FamilyName - " + Arrays.stream(infoPersonsArr).toList().get(0));
                System.out.println("FirstName - " + Arrays.stream(infoPersonsArr).toList().get(0));
                System.out.println("SecondName - " + Arrays.stream(infoPersonsArr).toList().get(0));
                Approver.appendChild(getOrgElementsValueTXT(doc, "FamilyName", Arrays.stream(infoPersonsArr).toList().get(0)));
                Approver.appendChild(getOrgElementsValueTXT(doc, "FirstName", Arrays.stream(infoPersonsArr).toList().get(0)));
                Approver.appendChild(getOrgElementsValueTXT(doc, "SecondName", Arrays.stream(infoPersonsArr).toList().get(0)));
                Approver.appendChild(getOrgElementsValueTXT(doc, "Position", position));
                if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(select * from xml_project.public.approver_object_xml where family_name_value=? and first_name_value=? and second_name_value=? and position_value=? and id_file=? and name_company=?)", Boolean.class, Arrays.stream(infoPersonsArr).toList().get(0),
                        Arrays.stream(infoPersonsArr).toList().get(0), Arrays.stream(infoPersonsArr).toList().get(0), position, IDFile, NameCompany))) {
                    jdbcTemplate.update("insert into xml_project.public.approver_object_xml(family_name_value, " +
                                    "first_name_value, second_name_value, " +
                                    "position_value, name_company, id_file, id_transaction) values (?, ?, ?, ?, ?, ?, ?)",
                            Arrays.stream(infoPersonsArr).toList().get(0),
                            Arrays.stream(infoPersonsArr).toList().get(0), Arrays.stream(infoPersonsArr).toList().get(0), position, NameCompany, IDFile, UUID.randomUUID());
                }
            } else {
                Approver.appendChild(getOrgElementsValueTXT(doc, "FamilyName", "Документ word является пустым"));
                Approver.appendChild(getOrgElementsValueTXT(doc, "FirstName", "Документ word является пустым"));
                Approver.appendChild(getOrgElementsValueTXT(doc, "SecondName", "Документ word является пустым"));
                Approver.appendChild(getOrgElementsValueTXT(doc, "Position", "Документ word является пустым"));
                if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(select * from xml_project.public.approver_object_xml where family_name_value=? and second_name_value=? and position_value=? and id_file=? and name_company=?)", Boolean.class, "Документ word является пустым",
                        "Документ word является пустым", "Документ word является пустым", "Документ word является пустым", IDFile, NameCompany))) {
                    jdbcTemplate.update("insert into xml_project.public.approver_object_xml(family_name_value, " +
                                    "first_name_value, second_name_value, " +
                                    "position_value, name_company, id_file, id_transaction) values (?, ?, ?, ?, ?, ?, ?)",
                            "Документ word является пустым",
                            "Документ word является пустым", "Документ word является пустым", "Документ word является пустым", NameCompany, IDFile, UUID.randomUUID());
                }
            }
        }
        return Approver;
    }
}