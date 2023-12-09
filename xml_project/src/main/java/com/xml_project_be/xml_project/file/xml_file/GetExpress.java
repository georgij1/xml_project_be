package com.xml_project_be.xml_project.file.xml_file;

import com.spire.doc.collections.ParagraphCollection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;

public class GetExpress {
    public static Node getExperts(Document doc, String DEST_WORD) {
        Element node = doc.createElement("Experts");
        File file = new File(DEST_WORD);
        com.spire.doc.Document document = new com.spire.doc.Document();
        document.loadFromFile(DEST_WORD);
        if (!file.exists()) {
            System.out.println("File not found: " + DEST_WORD);
            return node;
        } else {
            System.out.println(DEST_WORD);

            try {
                if (document.getSections().getCount() > 0 && document.getSections().get(0).getParagraphs().getCount() > 0) {
                    String GetTextFile = String.valueOf(document.getChildObjects().get(0).getDocument().getText());
                    System.out.println(GetTextFile);
                }

                else {
                    System.out.println("Not found string");
                    return node;
                }

                node.appendChild(doc.createElement("Expert")).appendChild(doc.createElement("FamilyName")).appendChild(doc.createTextNode("Матвеев"));
                node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("FirstName")).appendChild(doc.createTextNode("Алексей"));
                node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("SecondName")).appendChild(doc.createTextNode("Александрович"));
                node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertType")).appendChild(doc.createTextNode("Нет данных"));
                node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificate")).appendChild(doc.createTextNode("МС-Э-1-10-13222"));
                node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificateBeginDate")).appendChild(doc.createTextNode("2020-01-29"));
                node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificateEndDate")).appendChild(doc.createTextNode("2025-01-29"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return node;
    }
}