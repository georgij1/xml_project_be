package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetSummary {
    public static Node getSummary(Document doc) {
        Element node = doc.createElement("Summary");
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("ProjectDocumentsSummary")).appendChild(doc.createTextNode("Данных нет"));
        return node;
    }
}