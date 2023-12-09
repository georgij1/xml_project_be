package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetDesigner {
    public static Node getDesigner(Document doc) {
        Element node = doc.createElement("Designer");
        node.setAttribute("General", "нет");
        node.appendChild(doc.createElement("IP")).appendChild(doc.createElement("FamilyName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("FirstName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("SecondName")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("OGRNIP")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("PostAddress")).appendChild(doc.createElement("Country")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("PostIndex")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Данных нет"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("Данных нет"));
        return node;
    }
}