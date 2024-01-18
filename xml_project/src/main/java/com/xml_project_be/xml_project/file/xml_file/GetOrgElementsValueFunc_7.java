package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetOrgElementsValueFunc_7 {
    public static Node getOrgElementsValueFunc_7(
            org.w3c.dom.Document doc
    ) {
        Element node = doc.createElement("Document");
        node.appendChild(doc.createElement("DocType")).appendChild(doc.createTextNode("01.01"));
        node.appendChild(doc.createElement("DocName")).appendChild(doc.createTextNode("Заявление на заключение договора на экспертное сопровождение в отношении проектной документации объекта капитального строительства"));
        node.appendChild(doc.createElement("DocNumber")).appendChild(doc.createTextNode("43/261"));
        node.appendChild(doc.createElement("DocDate")).appendChild(doc.createTextNode("2022-04-01"));
        node.appendChild(doc.createElement("DocIssueAuthor")).appendChild(doc.createTextNode("ООО «Специализированный застройщик «Лидер констракшн»"));
        node.appendChild(doc.createElement("File")).appendChild(doc.createElement("FileName")).appendChild(doc.createTextNode("Заявление о заключении договора.pdf"));
        node.getElementsByTagName("File").item(0).appendChild(doc.createElement("FileFormat")).appendChild(doc.createTextNode("pdf"));
        node.getElementsByTagName("File").item(0).appendChild(doc.createElement("FileChecksum")).appendChild(doc.createTextNode("eebbdb54"));
        node.getElementsByTagName("File").item(0).appendChild(doc.createElement("SignFile")).appendChild(doc.createElement("FileName")).appendChild(doc.createTextNode("Заявление о заключении договора.pdf.sig"));
        node.getElementsByTagName("SignFile").item(0).appendChild(doc.createElement("FileFormat")).appendChild(doc.createTextNode("sig"));
        node.getElementsByTagName("SignFile").item(0).appendChild(doc.createElement("FileChecksum")).appendChild(doc.createTextNode("3718b4c5"));
        return node;
    }
}