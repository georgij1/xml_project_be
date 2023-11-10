package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import static com.xml_project_be.xml_project.file.xml_file.GetPreviousSimpleConclusion.getPreviousSimpleConclusion;

public class GetPreviousSimpleConclusions {
    public static Node getPreviousSimpleConclusions(org.w3c.dom.Document doc) {
        Element PreviousSimpleConclusions = doc.createElement("PreviousSimpleConclusions");
        PreviousSimpleConclusions.appendChild(getPreviousSimpleConclusion(doc));
        return PreviousSimpleConclusions;
    }
}