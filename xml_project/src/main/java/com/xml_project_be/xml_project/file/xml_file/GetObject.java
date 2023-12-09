package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetObject {
    public static Node getObject(
            Document doc
    ) {
        Element node = doc.createElement("Object");
        node.appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Type")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Functions")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Address")).appendChild(doc.createElement("Country")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Note")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("TEI")).appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("TEI").item(0).appendChild(doc.createElement("Measure")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("TEI").item(0).appendChild(doc.createElement("Value")).appendChild(doc.createTextNode("Данных нет"));
        return node;
    }
}