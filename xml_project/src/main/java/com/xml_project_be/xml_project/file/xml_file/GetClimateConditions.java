package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetClimateConditions {
    public static Node getClimateConditions(Document doc) {
        Element node = doc.createElement("ClimateConditions");
        node.appendChild(doc.createElement("ClimateDistrict")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("GeologicalConditions")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("WindDistrict")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("SnowDistrict")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("SeismicActivity")).appendChild(doc.createTextNode("Данных нет"));
        return node;
    }
}