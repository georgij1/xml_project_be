package com.xml_project_be.xml_project.file.xml_file.put_data;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetOrgElementsValueFunc_PreviousConsultation {
    public static Node getOrgElementsValueFunc_PreviousConsultation(
            org.w3c.dom.Document doc,
            Element element,
            String PreviousConclusion,
            String Date,
            String TextDate
    ) {
        Element node = doc.createElement(PreviousConclusion);
        node.appendChild(doc.createElement(Date)).appendChild(doc.createTextNode(TextDate));
        node.appendChild(doc.createElement("Number")).appendChild(doc.createElement("EGRZ")).appendChild(doc.createTextNode("66-2-1-3-049345-2020"));
        node.appendChild(doc.createElement("ExaminationObjectType")).appendChild(doc.createTextNode("3"));
        node.appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Жилая многоэтажная застройка квартала 4.15.1 в границах улиц Краснолесья - Рябинина - Очеретина в Академическом районе г. Екатеринбурга"));
        node.appendChild(doc.createElement("Result")).appendChild(doc.createTextNode("1"));
        return node;
    }
}