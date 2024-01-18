package com.xml_project_be.xml_project.file.xml_file.put_data;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetOrgElementsValueTXT {
    public static Node getOrgElementsValueTXT(
            org.w3c.dom.Document doc,
            String name,
            String value
    ) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}