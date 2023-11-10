package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetExpress {
    public static Node getExperts(org.w3c.dom.Document doc) {
        Element node = doc.createElement("Experts");
        node.appendChild(doc.createElement("Expert")).appendChild(doc.createElement("FamilyName")).appendChild(doc.createTextNode("Матвеев"));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("FirstName")).appendChild(doc.createTextNode("Алексей"));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("SecondName")).appendChild(doc.createTextNode("Александрович"));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertType")).appendChild(doc.createTextNode("10."));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificate")).appendChild(doc.createTextNode("МС-Э-1-10-13222"));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificateBeginDate")).appendChild(doc.createTextNode("2020-01-29"));
        node.getElementsByTagName("Expert").item(0).appendChild(doc.createElement("ExpertCertificateEndDate")).appendChild(doc.createTextNode("2025-01-29"));
        return node;
    }
}