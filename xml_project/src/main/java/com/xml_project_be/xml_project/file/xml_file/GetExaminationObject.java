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
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationForm", "Данные не указаны"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationResult", "Данные не указаны"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationObjectType", "Данные не указаны"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationType", "Данные не указаны"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ConstructionType", "Данные не указаны"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationStage", "Данные не указаны"));
                ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "Name", "Данные не указаны"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ExaminationObject;
    }
}