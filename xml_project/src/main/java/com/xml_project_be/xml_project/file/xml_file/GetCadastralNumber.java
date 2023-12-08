package com.xml_project_be.xml_project.file.xml_file;

import com.spire.doc.collections.ParagraphCollection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.io.File;

public class GetCadastralNumber {
    public static Node getCadastralNumber(
            Document doc,
            String DEST_WORD
    ) {
        Element node = doc.createElement("CadastralNumber");
        File file = new File(DEST_WORD);
        if (!file.exists()) {
            System.out.println("File not found: " + DEST_WORD);
        } else {
            try {
                com.spire.doc.Document document = new com.spire.doc.Document();
                document.loadFromFile(DEST_WORD);
                if (document.getSections().getCount() > 0 && document.getSections().get(0).getParagraphs().getCount() > 0) {
                    ParagraphCollection firstParagraph = document.getSections().get(0).getParagraphs();
                    String CadastralNumber = firstParagraph.get(170).getText();
                    int commaIndex = CadastralNumber.indexOf(',');
                    if (commaIndex != -1) {
                        String startWordCadastralNumber = "Кадастровый номер земельного участка: ";
                        String endWordOrgCadastralNumber = ".";
                        int startIndex = CadastralNumber.indexOf(startWordCadastralNumber);

                        if (startIndex != -1) {
                            int endIndex = CadastralNumber.indexOf(endWordOrgCadastralNumber, startIndex);

                            if (endIndex != -1) {
                                String substring = CadastralNumber.substring(startIndex + startWordCadastralNumber.length(), endIndex);
                                System.out.println("CadastralNumber - "+substring.trim());
                                node.appendChild(doc.createTextNode(substring.trim()));
                            }

                            else {
                                System.out.println("Мы не нашли точку CadastralNumber");
                                node.appendChild(doc.createTextNode("Мы не нашли точку в этой строке"));
                            }
                        }

                        else {
                            System.out.println("Кадастровый номер земельного участка: - мы не нашли данные в этой строке");
                            node.appendChild(doc.createTextNode("Кадастровый номер земельного участка: - мы не нашли данные в этой строке"));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return node;
    }
}