package com.xml_project_be.xml_project.file.xml_file;

import com.spire.doc.collections.ParagraphCollection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GetCadastralNumber {
    public static ArrayList<Object> getCadastralNumberFE (
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();
        int object_item_1 = jdbcTemplate.queryForList("select cadastral_number_value from xml_project.public.cadastral_number_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size();
        System.out.println(object_item_1);
        for (int i = 0; i < object_item_1; i++) {
            // cadastral_number_value
            arrayList1.put("name_"+i+"_cadastral_number_value", jdbcTemplate.queryForList("select * from xml_project.public.cadastral_number_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("cadastral_number_value").toString());
            // id_transaction
            arrayList1.put("name_"+i+"_id_transaction", jdbcTemplate.queryForList("select * from xml_project.public.cadastral_number_object_xml where id_file=? and name_company=?", IdFile, NameCompany).get(i).get("id_transaction").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select cadastral_number_value from xml_project.public.cadastral_number_object_xml where id_file=? and name_company=?", IdFile, NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getCadastralNumber(
            Document doc,
            String DEST_WORD,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        Element node = doc.createElement("CadastralNumber");
        File file = new File(DEST_WORD);
        if (!file.exists()) {
            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(" +
                            "select * from xml_project.public.cadastral_number_object_xml " +
                            "where cadastral_number_value=? and " +
                            "name_company=? and " +
                            "id_file=?)", Boolean.class,
                    "Файл не найден", NameCompany, IdFile))
            ) {
                jdbcTemplate.update("insert into xml_project.public.cadastral_number_object_xml(" +
                                "cadastral_number_value, name_company, id_file, id_transaction) VALUES (?, ?, ?, ?)",
                        "Файл не найден", NameCompany, IdFile, UUID.randomUUID());
            }
        } else {
            com.spire.doc.Document document = new com.spire.doc.Document();
            document.loadFromFile(DEST_WORD);
            if (document.getSections().getCount() > 0 && document.getSections().get(0).getParagraphs().getCount() > 0) {
                ParagraphCollection firstParagraph = document.getSections().get(0).getParagraphs();
                String CadastralNumber = firstParagraph.get(0).getText();
                int commaIndex = CadastralNumber.indexOf(',');
                if (commaIndex != -1) {
                    String startWordCadastralNumber = "Кадастровый номер земельного участка: ";
                    String endWordOrgCadastralNumber = ".";
                    int startIndex = CadastralNumber.indexOf(startWordCadastralNumber);
                    if (startIndex != -1) {
                        int endIndex = CadastralNumber.indexOf(endWordOrgCadastralNumber, startIndex);
                        if (endIndex != -1) {
                            String substring = CadastralNumber.substring(startIndex + startWordCadastralNumber.length(), endIndex);
                            node.appendChild(doc.createTextNode(substring.trim()));
                            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(" +
                                            "select * from xml_project.public.cadastral_number_object_xml " +
                                            "where cadastral_number_value=? and " +
                                            "name_company=? and " +
                                            "id_file=?)", Boolean.class,
                                    substring.trim(), NameCompany, IdFile))
                            ) {
                                jdbcTemplate.update("insert into xml_project.public.cadastral_number_object_xml(" +
                                                "cadastral_number_value, name_company, id_file, id_transaction) VALUES (?, ?, ?, ?)",
                                        substring.trim(), NameCompany, IdFile, UUID.randomUUID());
                            }
                        }
                        else {
                            node.appendChild(doc.createTextNode("Мы не нашли точку в этой строке"));
                            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(" +
                                            "select * from xml_project.public.cadastral_number_object_xml " +
                                            "where cadastral_number_value=? and " +
                                            "name_company=? and " +
                                            "id_file=?)", Boolean.class,
                                    "Мы не нашли точку в этой строке", NameCompany, IdFile))
                            ) {
                                jdbcTemplate.update("insert into xml_project.public.cadastral_number_object_xml(" +
                                                "cadastral_number_value, name_company, id_file, id_transaction) VALUES (?, ?, ?, ?)",
                                        "Мы не нашли точку в этой строке", NameCompany, IdFile, UUID.randomUUID());
                            }
                        }
                    }
                    else {
                        node.appendChild(doc.createTextNode("Кадастровый номер земельного участка: - мы не нашли данные в этой строке"));
                        if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(" +
                                        "select * from xml_project.public.cadastral_number_object_xml " +
                                        "where cadastral_number_value=? and " +
                                        "name_company=? and " +
                                        "id_file=?)", Boolean.class,
                                "Кадастровый номер земельного участка: - мы не нашли данные в этой строке", NameCompany, IdFile))
                        ) {
                            jdbcTemplate.update("insert into xml_project.public.cadastral_number_object_xml(" +
                                            "cadastral_number_value, name_company, id_file, id_transaction) VALUES (?, ?, ?, ?)",
                                    "Кадастровый номер земельного участка: - мы не нашли данные в этой строке",
                                    NameCompany, IdFile, UUID.randomUUID());
                        }
                    }
                }
                else {
                    if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(" +
                                    "select * from xml_project.public.cadastral_number_object_xml " +
                                    "where cadastral_number_value=? and " +
                                    "name_company=? and " +
                                    "id_file=?)", Boolean.class,
                            "Мы не нашли запятую в строке", NameCompany, IdFile))
                    ) {
                        jdbcTemplate.update("insert into xml_project.public.cadastral_number_object_xml(" +
                                        "cadastral_number_value, name_company, id_file, id_transaction) VALUES (?, ?, ?, ?)",
                                "Мы не нашли запятую в строке", NameCompany, IdFile, UUID.randomUUID());
                    }
                }
            } else {
                if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(" +
                                "select * from xml_project.public.cadastral_number_object_xml " +
                                "where cadastral_number_value=? and " +
                                "name_company=? and " +
                                "id_file=?)", Boolean.class,
                        "абзацы не найдены в файле", NameCompany, IdFile))
                ) {
                    jdbcTemplate.update("insert into xml_project.public.cadastral_number_object_xml(" +
                                    "cadastral_number_value, name_company, id_file, id_transaction) VALUES (?, ?, ?, ?)",
                            "абзацы не найдены в файле", NameCompany, IdFile, UUID.randomUUID());
                }
            }
        }
        return node;
    }
}