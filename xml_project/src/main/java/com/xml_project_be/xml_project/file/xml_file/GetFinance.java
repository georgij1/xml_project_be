package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetFinance {
    public static Node getFinance(Document doc, String DEST_WORD) {
        Element node = doc.createElement("Finance");
        node.appendChild(doc.createElement("FinanceType")).appendChild(doc.createTextNode("3"));
        node.appendChild(doc.createElement("FinanceSize")).appendChild(doc.createTextNode("100.0"));
        return node;
    }
}