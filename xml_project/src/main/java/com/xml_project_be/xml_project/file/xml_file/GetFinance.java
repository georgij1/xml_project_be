package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetFinance {
    public static Node getFinance(Document doc) {
        Element node = doc.createElement("Finance");
        node.appendChild(doc.createElement("FinanceType")).appendChild(doc.createTextNode("Данных нет"));
        node.appendChild(doc.createElement("FinanceSize")).appendChild(doc.createTextNode("Данных нет"));
        return node;
    }
}