package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import static com.xml_project_be.xml_project.file.xml_file.GetOrgElementsValueTXT.getOrgElementsValueTXT;

public class GetApprover {
    public static Node getApprover(org.w3c.dom.Document doc) {
        Element Approver = doc.createElement("Approver");
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "FamilyName", "Арзамасцева"));
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "FirstName", "Надежда"));
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "SecondName", "Петровна"));
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "Position", "Управляющий – Индивидуальный предприниматель"));
        return Approver;
    }
}