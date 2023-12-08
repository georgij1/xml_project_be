package com.xml_project_be.xml_project.file.xml_file.put_data;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetPreviousSimpleConclusion {
    public static Node getPreviousSimpleConclusion(
            org.w3c.dom.Document doc,
            String DEST_WORD
    ) {
        Element node = doc.createElement("PreviousSimpleConclusion");
        node.appendChild(doc.createElement("Date")).appendChild(doc.createTextNode("2022-04-11"));
        node.appendChild(doc.createElement("Number")).appendChild(doc.createTextNode("0028-2022"));
        node.appendChild(doc.createElement("Result")).appendChild(doc.createTextNode("1"));
        return node;
    }
}