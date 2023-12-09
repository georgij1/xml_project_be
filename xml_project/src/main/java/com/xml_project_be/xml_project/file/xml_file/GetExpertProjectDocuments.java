package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetExpertProjectDocuments {
    public static Node getExpertProjectDocuments(Document doc) {
        Element node = doc.createElement("ExpertProjectDocuments");
        node.setAttribute("ExpertType", "Данных нет");
        node.appendChild(doc.createElement("ProjectDocumentsReview")).appendChild(doc.createTextNode("Данных нет"));
        return node;
    }
}