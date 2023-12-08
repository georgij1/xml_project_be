package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;

import static com.xml_project_be.xml_project.file.xml_file.put_data.GetOrgElementsValueTXT.getOrgElementsValueTXT;

public class GetExaminationObject {
    public static Node getExaminationObject(
            org.w3c.dom.Document doc,
            String DEST_WORD
    ) {
        Element ExaminationObject = doc.createElement("ExaminationObject");
        File file = new File(DEST_WORD);

        if (!file.exists()) {
            System.out.println("File not found: " + DEST_WORD);
        } else {
            try {
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationForm", "2"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationResult", "1"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationObjectType", "2"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationType", "2"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ConstructionType", "1"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationStage", "3"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "Name", "Жилая многоэтажная застройка квартала 4.15.1 в границах улиц Краснолесья – Рябинина – Очеретина в\n" +
                        "            Академическом районе г. Екатеринбурга"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ExaminationObject;
    }
}