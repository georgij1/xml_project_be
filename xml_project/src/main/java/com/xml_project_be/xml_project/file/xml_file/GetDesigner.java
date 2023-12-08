package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetDesigner {
    public static Node getDesigner(Document doc, String DEST_WORD) {
        Element node = doc.createElement("Designer");
        node.setAttribute("General", "нет");
        node.appendChild(doc.createElement("IP")).appendChild(doc.createElement("FamilyName")).appendChild(doc.createTextNode("ГАБЗАЛИЛОВА"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("FirstName")).appendChild(doc.createTextNode("МАРИНА"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("SecondName")).appendChild(doc.createTextNode("РАВИЛЬЕВНА"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("OGRNIP")).appendChild(doc.createTextNode("320665800123804"));
        node.getElementsByTagName("IP").item(0).appendChild(doc.createElement("PostAddress")).appendChild(doc.createElement("Country")).appendChild(doc.createTextNode("Россия"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("66"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("PostIndex")).appendChild(doc.createTextNode("623281"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("г Ревда"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("ул Ленина"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("34"));
        node.getElementsByTagName("PostAddress").item(0).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("58"));
        return node;
    }
}