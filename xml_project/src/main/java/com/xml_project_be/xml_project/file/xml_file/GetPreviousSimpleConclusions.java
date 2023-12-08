package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import static com.xml_project_be.xml_project.file.xml_file.put_data.GetPreviousSimpleConclusion.getPreviousSimpleConclusion;

public class GetPreviousSimpleConclusions {
    public static Node getPreviousSimpleConclusions(Document doc, String DEST_WORD) {
        Element PreviousSimpleConclusions = doc.createElement("PreviousSimpleConclusions");
        PreviousSimpleConclusions.appendChild(getPreviousSimpleConclusion(doc, DEST_WORD));
        return PreviousSimpleConclusions;
    }
}