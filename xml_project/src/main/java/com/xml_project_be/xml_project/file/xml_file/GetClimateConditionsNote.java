package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetClimateConditionsNote {
    public static Node getClimateConditionsNote(Document doc) {
        Element node = doc.createElement("ClimateConditionsNote");
        node.appendChild(doc.createTextNode("Данных нет"));
        return node;
    }
}