package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetProjectDocumentsDeveloper {
    public static Node getProjectDocumentsDeveloper(Document doc) {
        Element node = doc.createElement("ProjectDocumentsDeveloper");
        node.appendChild(doc.createElement("Organization")).appendChild(doc.createElement("OrgFullName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgOGRN")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgINN")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgKPP")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("Данных нет"));
        return node;
    }
}