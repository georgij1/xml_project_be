package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import static com.xml_project_be.xml_project.file.xml_file.GetOrgElementsValueFunc_PreviousConsultation.getOrgElementsValueFunc_PreviousConsultation;

public class GetPreviousConclusions {
    public static Node getPreviousConclusions(org.w3c.dom.Document doc) {
        Element PreviousConclusions = doc.createElement("PreviousConclusions");
        PreviousConclusions.appendChild(getOrgElementsValueFunc_PreviousConsultation(
                doc,
                PreviousConclusions,
                "PreviousConclusion",
                "Date",
                "2020-10-02"
        ));
        return PreviousConclusions;
    }
}