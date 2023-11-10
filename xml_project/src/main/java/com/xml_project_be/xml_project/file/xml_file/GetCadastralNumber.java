package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetCadastralNumber {
    public static Node getCadastralNumber(org.w3c.dom.Document doc) {
        Element node = doc.createElement("CadastralNumber");
        node.appendChild(doc.createTextNode("66:41:0313121:85"));
        return node;
    }
}