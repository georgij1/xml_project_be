package com.xml_project_be.xml_project.file.xml_file.put_data;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetOrgElementsValueFunc {
    public static Node getOrgElementsValueFunc(
            org.w3c.dom.Document doc,
            Element element,
            String value,
            String content
    ) {
        Element node = doc.createElement("Address");
        node.appendChild(doc.createElement(value)).appendChild(doc.createTextNode(content));
        return node;
    }
}