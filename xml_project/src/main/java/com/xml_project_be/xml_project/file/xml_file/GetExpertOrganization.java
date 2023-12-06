package com.xml_project_be.xml_project.file.xml_file;

import com.spire.doc.Document;
import com.spire.doc.collections.ParagraphCollection;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static com.xml_project_be.xml_project.file.xml_file.GetOrgElementsValueFunc.getOrgElementsValueFunc;
import static com.xml_project_be.xml_project.file.xml_file.GetOrgElementsValueTXT.getOrgElementsValueTXT;

public class GetExpertOrganization {
    public static Node getExpertOrganization(org.w3c.dom.Document doc, String DEST_WORD) {
        File file = new File(DEST_WORD);
        List<String> paragraphTexts = new ArrayList<>();

        String txt_not_valid_structure = "Возможно структура файла не валидна";
        String txt_not_found_structure = "Такой файл не найден";

        if (!file.exists()) {
            System.out.println("File not found: " + DEST_WORD);
            return getNode(doc, txt_not_found_structure);
        }

        else {
            System.out.println(DEST_WORD);

            try {
                // ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Region", "66"));
                // ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "City", "ГОРОД ЕКАТЕРИНБУРГ"));
                // ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Street", "УЛИЦА НИКОЛАЯ НИКОНОВА"));
                // ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Building", "ДОМ 18"));
                // ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Room", "ПОМЕЩЕИЕ 73"));
                // ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Room", "ПОМЕЩЕИЕ 73"));

                Document document = new Document();
                document.loadFromFile(DEST_WORD);
                Element ExpertOrganization = doc.createElement("ExpertOrganization");

                // Check if the document has sections and paragraphs
                if (document.getSections().getCount() > 0 && document.getSections().get(0).getParagraphs().getCount() > 0) {
                    // Get the first paragraph
                    ParagraphCollection firstParagraph = document.getSections().get(0).getParagraphs();
                    String OrgFullName = firstParagraph.get(45).getText();
                    int commaIndex = OrgFullName.indexOf(',');
                    if (commaIndex != -1) {
                        // FullName
                        String endWordFullName = "ИНН ";
                        int startIndexFullName = OrgFullName.indexOf(endWordFullName);

                        if (startIndexFullName != -1) {
                            int endIndex = OrgFullName.indexOf(endWordFullName, startIndexFullName);

                            if (endIndex != -1) {
                                String substring = OrgFullName.substring(0, endIndex);
                                System.out.println("FullName - "+(substring.trim()));
                                ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgFullName", substring.trim()));
                            } else {
                                System.out.println(OrgFullName.substring(0).trim());
                                ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgFullName", "начало строки не найдено"));
                            }
                        } else {
                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgFullName", "Начало строки и ИНН не найдены"));
                        }

                        // INN
                        String startWordINN = "ИНН ";
                        String endWordOrgINN = ", ОГРН";
                        int startIndex = OrgFullName.indexOf(startWordINN);

                        if (startIndex != -1) {
                            int endIndex = OrgFullName.indexOf(endWordOrgINN, startIndex);

                            if (endIndex != -1) {
                                String substring = OrgFullName.substring(startIndex + startWordINN.length(), endIndex);
                                System.out.println("INN - "+(substring.trim()));
                                ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgINN",substring.trim()));
                                int getRegion = Integer.parseInt(substring) / 100000000;
                                System.out.println("Region - "+getRegion);
                                ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Region", "66"));
                            } else {
                                System.out.println(OrgFullName.substring(startIndex + startWordINN.length()).trim());
                                ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgINN", "слово ОГРН не существует"));
                            }
                        } else {
                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgINN", "ОГРН и ИНН не найдены"));
                        }

                        // OGRN
                        String startWordOGRN = ", ОГРН ";
                        String endWordOGRN = ", КПП";
                        int startIndexOGRN = OrgFullName.indexOf(startWordOGRN);

                        if (startIndexOGRN != -1) {
                            int endIndexOGRN = OrgFullName.indexOf(endWordOGRN, startIndexOGRN);

                            if (endIndexOGRN != -1) {
                                String substring = OrgFullName.substring(startIndexOGRN + startWordOGRN.length(), endIndexOGRN);
                                System.out.println("OGRN - "+substring);
                                ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgOGRN" , substring.trim()));
                            } else {
                                ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgOGRN", "слово ОГРН не существует"));
                            }
                        } else {
                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgOGRN", "ОГРН и ИНН не найдены"));
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
                                System.out.println("OrgKPP - "+substring);
                                ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgKPP", substring.trim()));
                            } else {
                                ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgKPP", "символа : не существует"));
                            }
                        } else {
                            ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgKPP", "КПП и символ : не найдены"));
                        }
                    }
                    else {
                        System.out.println(OrgFullName);
                    }
                    String Region = firstParagraph.get(46).getText();
                    System.out.println(Region);
                } else {
                    System.out.println("Document does not contain paragraphs.");
                }

                return ExpertOrganization;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return getNode(doc, txt_not_valid_structure);
    }

    @NotNull
    private static Node getNode(org.w3c.dom.Document doc, String txt_not_found_structure) {
        Element ExpertOrganization = doc.createElement("ExpertOrganization");
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgFullName", txt_not_found_structure));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgOGRN", txt_not_found_structure));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgINN", txt_not_found_structure));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgKPP", txt_not_found_structure));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Region", txt_not_found_structure));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "City", txt_not_found_structure));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Street", txt_not_found_structure));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Building", txt_not_found_structure));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Room", txt_not_found_structure));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Room", txt_not_found_structure));
        return ExpertOrganization;
    }
}