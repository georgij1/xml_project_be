package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetDeclarant {
    public static Node getDeclarant (
            Document doc,
            String DEST_WORD
    ) {
        Element node = doc.createElement("Declarant");
        node.appendChild(doc.createElement("Organization")).appendChild(doc.createElement("OrgFullName")).appendChild(doc.createTextNode("ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ СПЕЦИАЛИЗИРОВАННЫЙ ЗАСТРОЙЩИК ЛИДЕР КОНСТРАКШН"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgOGRN")).appendChild(doc.createTextNode("1076671026728"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgINN")).appendChild(doc.createTextNode("6671236301"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgKPP")).appendChild(doc.createTextNode("665801001"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("66"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Г. ЕКАТЕРИНБУРГ"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("УЛ. ВИКУЛОВА"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Д. 59/К. 1"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("ОФИС 303"));
        return node;
    }
}