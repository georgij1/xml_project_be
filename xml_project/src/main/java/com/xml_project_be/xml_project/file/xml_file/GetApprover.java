package com.xml_project_be.xml_project.file.xml_file;

import com.spire.doc.Document;
import com.spire.doc.collections.ParagraphCollection;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.util.Arrays;

import static com.xml_project_be.xml_project.file.xml_file.put_data.GetOrgElementsValueTXT.getOrgElementsValueTXT;

public class GetApprover {
    public static Node getApprover(
            org.w3c.dom.Document doc,
            String DEST_WORD
    ) {
        Element Approver = doc.createElement("Approver");
        File file = new File(DEST_WORD);
        if (!file.exists()) {
            System.out.println("File not found: " + DEST_WORD);
        } else {
            try {
                Document document = new Document();
                document.loadFromFile(DEST_WORD);
                if (document.getSections().getCount() > 0 && document.getSections().get(0).getParagraphs().getCount() > 0) {
                    ParagraphCollection firstParagraph = document.getSections().get(0).getParagraphs();
                    String position = firstParagraph.get(14).getText();
                    System.out.println("position - " + position);
                    String person = firstParagraph.get(16).getText();
                    String[] infoPersonsArr = person.split(" ");
                    System.out.println("FamilyName - " + Arrays.stream(infoPersonsArr).toList().get(0));
                    System.out.println("FirstName - " + Arrays.stream(infoPersonsArr).toList().get(1));
                    System.out.println("SecondName - " + Arrays.stream(infoPersonsArr).toList().get(2));
                    Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "FamilyName", Arrays.stream(infoPersonsArr).toList().get(0)));
                    Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "FirstName", Arrays.stream(infoPersonsArr).toList().get(1)));
                    Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "SecondName", Arrays.stream(infoPersonsArr).toList().get(2)));
                    Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "Position", position));
                } else {
                    System.out.println("Документ пустой");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Approver;
    }
}