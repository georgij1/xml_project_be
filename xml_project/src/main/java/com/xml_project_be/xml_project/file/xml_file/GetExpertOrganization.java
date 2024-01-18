package com.xml_project_be.xml_project.file.xml_file;

import com.spire.doc.Document;
import com.spire.doc.collections.ParagraphCollection;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static com.xml_project_be.xml_project.file.xml_file.put_data.GetOrgElementsValueFunc.getOrgElementsValueFunc;
import static com.xml_project_be.xml_project.file.xml_file.put_data.GetOrgElementsValueTXT.getOrgElementsValueTXT;

@AllArgsConstructor
public class GetExpertOrganization {
    public static ArrayList<Object> getExpertOrganizationFE (
        Integer IdFile,
        String NameCompany,
        JdbcTemplate jdbcTemplate
    ) {
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HashMap<String, Object> arrayList1 = new HashMap<>();

        // org_full_name_value
        int object_item_1 = jdbcTemplate.queryForList("select org_full_name_value from xml_project.public.expert_organization_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).size();
        System.out.println(object_item_1);
        for (int i = 1; i < object_item_1; i++) {
            arrayList1.put("name_"+i+"_org_full_name_value", jdbcTemplate.queryForList("select * from xml_project.public.expert_organization_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("org_full_name_value").toString());
            arrayList1.put("name_"+i+"_org_ogrn_value", jdbcTemplate.queryForList("select * from xml_project.public.expert_organization_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("org_ogrn_value").toString());
            arrayList1.put("name_"+i+"_org_inn_value", jdbcTemplate.queryForList("select * from xml_project.public.expert_organization_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("org_inn_value").toString());
            arrayList1.put("name_"+i+"_org_kpp_value", jdbcTemplate.queryForList("select * from xml_project.public.expert_organization_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("org_kpp_value").toString());
            arrayList1.put("name_"+i+"_region_value", jdbcTemplate.queryForList("select * from xml_project.public.expert_organization_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("region_value").toString());
            arrayList1.put("name_"+i+"_city_value", jdbcTemplate.queryForList("select * from xml_project.public.expert_organization_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("city_value").toString());
            arrayList1.put("name_"+i+"_street_value", jdbcTemplate.queryForList("select * from xml_project.public.expert_organization_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("street_value").toString());
            arrayList1.put("name_"+i+"_building_value", jdbcTemplate.queryForList("select * from xml_project.public.expert_organization_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("building_value").toString());
            arrayList1.put("name_"+i+"_room_value", jdbcTemplate.queryForList("select * from xml_project.public.expert_organization_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).get(i).get("room_value").toString());
        }
        objectHashMap.put("object_item_1", arrayList1);
        hashMap.put("item_1", objectHashMap.get("object_item"));
        objectHashMap.put("count_object_items", jdbcTemplate.queryForList("select org_full_name_value from xml_project.public.expert_organization_object_xml where name_file=? and name_company=?", IdFile.toString(), NameCompany).size());
        hashMap.put("count_value", String.valueOf(hashMap.size()));
        hashMap.put("count_value_items", objectHashMap.get("count_object_items"));
        arrayList.add(objectHashMap.get("object_item_1"));
        arrayList.add(objectHashMap.get("count_object_items"));
        return arrayList;
    }

    public static Node getExpertOrganization(
            org.w3c.dom.Document doc,
            String DEST_WORD,
            String NameCompany,
            Integer IdFile,
            JdbcTemplate jdbcTemplate
    ) {
        File file = new File(DEST_WORD);
        Document document = new Document();
        document.loadFromFile(DEST_WORD);
        Element ExpertOrganization = doc.createElement("ExpertOrganization");

        if (!file.exists()) {
            jdbcTemplate.update("insert into " +
                    "xml_project.public.expert_organization_object_xml(" +
                    "org_full_name_value, org_ogrn_value, org_inn_value, " +
                    "org_kpp_value, region_value, " +
                            "city_value, " +
                    "street_value, building_value, room_value," +
                    "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                    "?, ?, ?, ?, ?)", "Такой файл не найден",
                    "Такой файл не найден",
                    "Такой файл не найден", "Такой файл не найден",
                    "Такой файл не найден", "Такой файл не найден",
                    "Такой файл не найден", "Такой файл не найден",
                    "Такой файл не найден", NameCompany, IdFile);
            return getNode(doc, "Такой файл не найден",
                    "Такой файл не найден",
                    "Такой файл не найден",
                    "Такой файл не найден",
                    "Такой файл не найден",
                    "Такой файл не найден",
                    "Такой файл не найден",
                    "Такой файл не найден",
                    "Такой файл не найден");
        } else {
            if (document.getSections().getCount() > 0 && document.getSections().get(0).getParagraphs().getCount() > 0) {
                ParagraphCollection firstParagraph = document.getSections().get(0).getParagraphs();
                String OrgFullName = firstParagraph.get(0).getText();

                int commaIndex = OrgFullName.indexOf(',');
                if (commaIndex != -1) {
                    // FullName
                    String endWordFullName = "ИНН ";
                    int startIndexFullName = OrgFullName.indexOf(endWordFullName);

                    if (startIndexFullName != -1) {
                        int endIndex = OrgFullName.indexOf(endWordFullName, startIndexFullName);

                        if (endIndex != -1) {
                            String substring = OrgFullName.substring(0, endIndex);
                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgFullName", substring.trim()));
                            jdbcTemplate.update("insert into " +
                                            "xml_project.public.expert_organization_object_xml(" +
                                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                            "org_kpp_value, region_value, " +
                                            "city_value, " +
                                            "street_value, building_value, room_value," +
                                            "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                            "?, ?, ?, ?, ?)", substring.trim(),
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", NameCompany, IdFile);
                        } else {
                            System.out.println(OrgFullName.trim());
                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgFullName", "начало строки не найдено"));
                            jdbcTemplate.update("insert into " +
                                            "xml_project.public.expert_organization_object_xml(" +
                                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                            "org_kpp_value, region_value, " +
                                            "city_value, " +
                                            "street_value, building_value, room_value," +
                                            "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                            "?, ?, ?, ?, ?)", "начало строки не найдено",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", NameCompany, IdFile);
                        }
                    } else {
                        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgFullName", "Начало строки и ИНН не найдены"));
                        jdbcTemplate.update("insert into " +
                                        "xml_project.public.expert_organization_object_xml(" +
                                        "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                        "org_kpp_value, region_value, " +
                                        "city_value, " +
                                        "street_value, building_value, room_value," +
                                        "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                        "?, ?, ?, ?, ?)", "Начало строки и ИНН не найдены",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно", NameCompany, IdFile);
                    }

                    // INN
                    String startWordINN = "ИНН ";
                    String endWordOrgINN = ", ОГРН";
                    int startIndex = OrgFullName.indexOf(startWordINN);

                    if (startIndex != -1) {
                        int endIndex = OrgFullName.indexOf(endWordOrgINN, startIndex);

                        if (endIndex != -1) {
                            String substring = OrgFullName.substring(startIndex + startWordINN.length(), endIndex);
                            System.out.println("INN - " + (substring.trim()));
                            jdbcTemplate.update("insert into " +
                                            "xml_project.public.expert_organization_object_xml(" +
                                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                            "org_kpp_value, region_value, " +
                                            "city_value, " +
                                            "street_value, building_value, room_value," +
                                            "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                            "?, ?, ?, ?, ?)", "Значение не заданно",
                                    "Значение не заданно", substring.trim(),
                                    "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", NameCompany, IdFile);

                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgINN", substring.trim()));
                            // Region
                            if (substring.length() >= 2) {
                                System.out.println("Region - " + (substring.trim()).substring(0, 2));
                                ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "Region", (substring.trim()).substring(0, 2)));
                                jdbcTemplate.update("insert into " +
                                                "xml_project.public.expert_organization_object_xml(" +
                                                "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                                "org_kpp_value, region_value, " +
                                                "city_value, " +
                                                "street_value, building_value, room_value," +
                                                "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                                "?, ?, ?, ?, ?)", "Значение не заданно",
                                        "Значение не заданно", "Значение не заданно",
                                        "Значение не заданно",
                                        (substring.trim()).substring(0, 2), "Значение не заданно",
                                        "Значение не заданно", "Значение не заданно",
                                        "Значение не заданно", NameCompany, IdFile);
                            } else {
                                System.out.println("Region - ИНН меньше 2");
                                ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "Region", "Длина ИНН не соответствует действительности"));
                                jdbcTemplate.update("insert into " +
                                                "xml_project.public.expert_organization_object_xml(" +
                                                "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                                "org_kpp_value, region_value, " +
                                                "city_value, " +
                                                "street_value, building_value, room_value," +
                                                "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                                "?, ?, ?, ?, ?)", "Значение не заданно",
                                        "Значение не заданно", "Значение не заданно",
                                        "Значение не заданно",
                                        "Длина ИНН не соответствует действительности", "Значение не заданно",
                                        "Значение не заданно", "Значение не заданно",
                                        "Значение не заданно", NameCompany, IdFile);
                            }
                        } else {
                            System.out.println(OrgFullName.substring(startIndex + startWordINN.length()).trim());
                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgINN", "слово ОГРН не существует"));
                            jdbcTemplate.update("insert into " +
                                            "xml_project.public.expert_organization_object_xml(" +
                                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                            "org_kpp_value, region_value, " +
                                            "city_value, " +
                                            "street_value, building_value, room_value," +
                                            "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                            "?, ?, ?, ?, ?)", "Значение не заданно",
                                    "Значение не заданно", "слово ОГРН не существует",
                                    "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", NameCompany, IdFile);
                        }
                    } else {
                        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgINN", "ОГРН и ИНН не найдены"));
                        jdbcTemplate.update("insert into " +
                                        "xml_project.public.expert_organization_object_xml(" +
                                        "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                        "org_kpp_value, region_value, " +
                                        "city_value, " +
                                        "street_value, building_value, room_value," +
                                        "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                        "?, ?, ?, ?, ?)", "Значение не заданно",
                                "Значение не заданно", "ОГРН и ИНН не найдены",
                                "Значение не заданно",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно", NameCompany, IdFile);
                    }

                    // OGRN
                    String startWordOGRN = ", ОГРН ";
                    String endWordOGRN = ", КПП";
                    int startIndexOGRN = OrgFullName.indexOf(startWordOGRN);

                    if (startIndexOGRN != -1) {
                        int endIndexOGRN = OrgFullName.indexOf(endWordOGRN, startIndexOGRN);

                        if (endIndexOGRN != -1) {
                            String substring = OrgFullName.substring(startIndexOGRN + startWordOGRN.length(), endIndexOGRN);
                            System.out.println("OGRN - " + substring);
                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgOGRN", substring.trim()));
                            jdbcTemplate.update("insert into " +
                                            "xml_project.public.expert_organization_object_xml(" +
                                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                            "org_kpp_value, region_value, " +
                                            "city_value, " +
                                            "street_value, building_value, room_value," +
                                            "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                            "?, ?, ?, ?, ?)", "Значение не заданно",
                                    substring.trim(), "Значение не заданно",
                                    "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", NameCompany, IdFile);
                        } else {
                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgOGRN", "слово ОГРН не существует"));
                            jdbcTemplate.update("insert into " +
                                            "xml_project.public.expert_organization_object_xml(" +
                                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                            "org_kpp_value, region_value, " +
                                            "city_value, " +
                                            "street_value, building_value, room_value," +
                                            "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                            "?, ?, ?, ?, ?)", "Значение не заданно",
                                    "слово ОГРН не существует", "Значение не заданно",
                                    "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", NameCompany, IdFile);
                        }
                    } else {
                        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgOGRN", "ОГРН и ИНН не найдены"));
                        jdbcTemplate.update("insert into " +
                                        "xml_project.public.expert_organization_object_xml(" +
                                        "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                        "org_kpp_value, region_value, " +
                                        "city_value, " +
                                        "street_value, building_value, room_value," +
                                        "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                        "?, ?, ?, ?, ?)", "Значение не заданно",
                                "ОГРН и ИНН не найдены", "Значение не заданно",
                                "Значение не заданно",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно", NameCompany, IdFile);
                    }

                    // KPP
                    System.out.println(OrgFullName);
                    String startWordKPP = ", КПП ";
                    String endWordKPP = ":";
                    int startIndexKPP = OrgFullName.indexOf(startWordKPP);

                    if (startIndexKPP != -1) {
                        int endIndexKPP = OrgFullName.indexOf(endWordKPP, startIndexKPP);

                        if (endIndexKPP != -1) {
                            String substring = OrgFullName.substring(startIndexKPP + startWordKPP.length(), endIndexKPP);
                            System.out.println("OrgKPP - " + substring);
                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgKPP", substring.trim()));
                            jdbcTemplate.update("insert into " +
                                            "xml_project.public.expert_organization_object_xml(" +
                                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                            "org_kpp_value, region_value, " +
                                            "city_value, " +
                                            "street_value, building_value, room_value," +
                                            "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                            "?, ?, ?, ?, ?)", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    substring.trim(),
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", NameCompany, IdFile);
                        } else {
                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgKPP", "символа : не существует"));
                            jdbcTemplate.update("insert into " +
                                            "xml_project.public.expert_organization_object_xml(" +
                                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                            "org_kpp_value, region_value, " +
                                            "city_value, " +
                                            "street_value, building_value, room_value," +
                                            "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                            "?, ?, ?, ?, ?)", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "символа : не существует",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно", NameCompany, IdFile);
                        }
                    } else {
                        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgKPP", "КПП и символ : не найдены"));
                        jdbcTemplate.update("insert into " +
                                        "xml_project.public.expert_organization_object_xml(" +
                                        "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                        "org_kpp_value, region_value, " +
                                        "city_value, " +
                                        "street_value, building_value, room_value," +
                                        "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                        "?, ?, ?, ?, ?)", "Значение не заданно",
                                "Значение не заданно", "Значение не заданно",
                                "КПП и символ : не найдены",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно", NameCompany, IdFile);
                    }
                } else {
                    System.out.println(OrgFullName);
                }

                // city
                String City = firstParagraph.get(46).getText();
                String startWordCity = "г. ";
                String endWordOrgCity = ", ул.";
                int startIndexCity = City.indexOf(startWordCity);

                if (startIndexCity != -1) {
                    int endIndexCity = City.indexOf(endWordOrgCity, startIndexCity);

                    if (endIndexCity != -1) {
                        String substring = City.substring(startIndexCity + startWordCity.length(), endIndexCity);
                        System.out.println("City - " + (substring.trim()));
                        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "City", "г. " + substring.trim()));
                        jdbcTemplate.update("insert into " +
                                        "xml_project.public.expert_organization_object_xml(" +
                                        "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                        "org_kpp_value, region_value, " +
                                        "city_value, " +
                                        "street_value, building_value, room_value," +
                                        "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                        "?, ?, ?, ?, ?)", "Значение не заданно",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно",
                                "Значение не заданно", "г. " + substring.trim(),
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно", NameCompany, IdFile);
                        // Street
                        String startWordStreet = "ул. ";
                        String endWordStreet = ", д. ";
                        int startIndexStreet = City.indexOf(startWordStreet);
                        int endIndexStreet = City.indexOf(endWordStreet, startIndexStreet);
                        if (endIndexStreet != -1) {
                            String substring_1 = City.substring(startIndexStreet + startWordStreet.length(), endIndexStreet);
                            System.out.println("Street - " + (substring_1.trim()));
                            ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "Street", substring_1.trim()));
                            jdbcTemplate.update("insert into " +
                                            "xml_project.public.expert_organization_object_xml(" +
                                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                            "org_kpp_value, region_value, " +
                                            "city_value, " +
                                            "street_value, building_value, room_value," +
                                            "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                            "?, ?, ?, ?, ?)", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    substring_1.trim(), "Значение не заданно",
                                    "Значение не заданно", NameCompany, IdFile);
                            String startWordBuilding = ", д. ";
                            String endWordBuilding = ", пом. ";
                            int startIndexBuilding = City.indexOf(startWordBuilding);
                            int endIndexBuilding = City.indexOf(endWordBuilding, startIndexBuilding);
                            if (endIndexBuilding != -1) {
                                String substring_2 = City.substring(startIndexBuilding + startWordBuilding.length(), endIndexBuilding);
                                System.out.println("Building - " + (substring_2.trim()));
                                ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "Building", substring_2.trim()));
                                jdbcTemplate.update("insert into " +
                                                "xml_project.public.expert_organization_object_xml(" +
                                                "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                                "org_kpp_value, region_value, " +
                                                "city_value, " +
                                                "street_value, building_value, room_value," +
                                                "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                                "?, ?, ?, ?, ?)", "Значение не заданно",
                                        "Значение не заданно", "Значение не заданно",
                                        "Значение не заданно",
                                        "Значение не заданно", "Значение не заданно",
                                        "Значение не заданно", substring_2.trim(),
                                        "Значение не заданно", NameCompany, IdFile);
                                String startWordRoom = ", пом. ";
                                String endWordRoom = ";";
                                int startIndexRoom = City.indexOf(startWordRoom);
                                int endIndexRoom = City.indexOf(endWordRoom, startIndexRoom);
                                if (endIndexRoom != -1) {
                                    String substring_3 = City.substring(startIndexRoom + startWordRoom.length(), endIndexRoom);
                                    System.out.println("Room - " + (substring_3.trim()));
                                    ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "Room", (substring_3.trim())));
                                    jdbcTemplate.update("insert into " +
                                                    "xml_project.public.expert_organization_object_xml(" +
                                                    "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                                    "org_kpp_value, region_value, " +
                                                    "city_value, " +
                                                    "street_value, building_value, room_value," +
                                                    "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                                    "?, ?, ?, ?, ?)", "Значение не заданно",
                                            "Значение не заданно", "Значение не заданно",
                                            "Значение не заданно",
                                            "Значение не заданно", "Значение не заданно",
                                            "Значение не заданно", "Значение не заданно",
                                            substring_3.trim(), NameCompany, IdFile);
                                } else {
                                    System.out.println("Room - not defined");
                                    jdbcTemplate.update("insert into " +
                                                    "xml_project.public.expert_organization_object_xml(" +
                                                    "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                                    "org_kpp_value, region_value, " +
                                                    "city_value, " +
                                                    "street_value, building_value, room_value," +
                                                    "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                                    "?, ?, ?, ?, ?)", "Значение не заданно",
                                            "Значение не заданно", "Значение не заданно",
                                            "Значение не заданно",
                                            "Значение не заданно", "Значение не заданно",
                                            "Значение не заданно", "Значение не заданно",
                                            "Room - not defined", NameCompany, IdFile);
                                }
                            }
                        } else {
                            ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "Street", "Символ , д. - не найден"));
                            jdbcTemplate.update("insert into " +
                                    "xml_project.public.expert_organization_" +
                                    "object_xml(" +
                                    "street_value, name_file, " +
                                    "name_company) " +
                                    "values (?, ?, ?)", "", IdFile, NameCompany);
                            jdbcTemplate.update("insert into " +
                                            "xml_project.public.expert_organization_object_xml(" +
                                            "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                            "org_kpp_value, region_value, " +
                                            "city_value, " +
                                            "street_value, building_value, room_value," +
                                            "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                            "?, ?, ?, ?, ?)", "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Значение не заданно",
                                    "Значение не заданно", "Значение не заданно",
                                    "Символ , д. - не найден", "Значение не заданно",
                                    "Значение не заданно", NameCompany, IdFile);
                        }
                    } else {
                        System.out.println(OrgFullName.substring(startIndexCity + startWordCity.length()).trim());
                        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "City", "слово ул. не найдено"));
                        jdbcTemplate.update("insert into " +
                                        "xml_project.public.expert_organization_object_xml(" +
                                        "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                        "org_kpp_value, region_value, " +
                                        "city_value, " +
                                        "street_value, building_value, room_value," +
                                        "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                        "?, ?, ?, ?, ?)", "Значение не заданно",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно",
                                "Значение не заданно", "слово ул. не найдено",
                                "Значение не заданно", "Значение не заданно",
                                "Значение не заданно", NameCompany, IdFile);
                    }
                } else {
                    ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "City", "г. и ул. не найдены"));
                    jdbcTemplate.update("insert into " +
                                    "xml_project.public.expert_organization_object_xml(" +
                                    "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                    "org_kpp_value, region_value, " +
                                    "city_value, " +
                                    "street_value, building_value, room_value," +
                                    "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                    "?, ?, ?, ?, ?)", "Значение не заданно",
                            "Значение не заданно", "Значение не заданно",
                            "Значение не заданно",
                            "Значение не заданно", "г. и ул. не найдены",
                            "Значение не заданно", "Значение не заданно",
                            "Значение не заданно", NameCompany, IdFile);
                }
            } else {
                ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "City", "Документ пустой"));
                jdbcTemplate.update("insert into " +
                                "xml_project.public.expert_organization_object_xml(" +
                                "org_full_name_value, org_ogrn_value, org_inn_value, " +
                                "org_kpp_value, region_value, " +
                                "city_value, " +
                                "street_value, building_value, room_value," +
                                "name_company, name_file) VALUES (?, ?, ?, ?, ?, ?, " +
                                "?, ?, ?, ?, ?)", "Документ пустой",
                        "Документ пустой", "Документ пустой",
                        "Документ пустой",
                        "Документ пустой", "Документ пустой",
                        "Документ пустой", "Документ пустой",
                        "Документ пустой", NameCompany, IdFile);
                getNode(doc, "Документ пустой",
                        "Документ пустой",
                        "Документ пустой",
                        "Документ пустой",
                        "Документ пустой",
                        "Документ пустой",
                        "Документ пустой",
                        "Документ пустой",
                        "Документ пустой");
            }

            return getNode(doc, "hashMap.get(City).toString()",
                "", "", "",
                "", "", "", "",
                "");
        }
    }

    @NotNull
    private static Node getNode(
            org.w3c.dom.Document doc,
            String OrgFullNameValue,
            String OrgOGRNValue,
            String OrgINNValue,
            String OrgKPPValue,
            String RegionValue,
            String CityValue,
            String StreetValue,
            String BuildingValue,
            String RoomValue
    ) {
        Element ExpertOrganization = doc.createElement("ExpertOrganization");
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgFullName", OrgFullNameValue));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgOGRN", OrgOGRNValue));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgINN", OrgINNValue));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, "OrgKPP", OrgKPPValue));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "Region", RegionValue));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "City", CityValue));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "Street", StreetValue));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "Building", BuildingValue));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, "Room", RoomValue));
        return ExpertOrganization;
    }
}