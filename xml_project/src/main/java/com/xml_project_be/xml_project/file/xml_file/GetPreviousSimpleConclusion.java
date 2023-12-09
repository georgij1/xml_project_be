package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetPreviousSimpleConclusion {
    public static Node getPreviousSimpleConclusion(
            org.w3c.dom.Document doc
    ) {
        Element node = doc.createElement("PreviousSimpleConclusion");
        node.appendChild(doc.createElement("Date")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Number")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("Result")).appendChild(doc.createTextNode("Данных нет"));
        return node;
    }
}