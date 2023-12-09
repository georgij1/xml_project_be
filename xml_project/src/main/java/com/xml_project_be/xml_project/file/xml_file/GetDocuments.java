package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import static com.xml_project_be.xml_project.file.xml_file.GetOrgElementsValueFunc_7.getOrgElementsValueFunc_7;

public class GetDocuments {
    public static Node getDocuments(Document doc) {
        Element Documents = doc.createElement("Documents");
        Documents.appendChild(getOrgElementsValueFunc_7(
                doc
        ));
        return Documents;
    }
}