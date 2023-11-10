package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import static com.xml_project_be.xml_project.file.xml_file.GetOrgElementsValueFunc.getOrgElementsValueFunc;
import static com.xml_project_be.xml_project.file.xml_file.GetOrgElementsValueTXT.getOrgElementsValueTXT;

public class GetExpertOrganization {
    public static Node getExpertOrganization(org.w3c.dom.Document doc) {
        Element ExpertOrganization = doc.createElement("ExpertOrganization");
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgFullName", "ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"УРАЛЬСКОЕ УПРАВЛЕНИЕ СТРОИТЕЛЬНОЙ ЭКСПЕРТИЗЫ\""));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgOGRN", "1156658096275"));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgINN", "6678066419"));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgKPP", "667801001"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Region", "66"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "City", "ГОРОД ЕКАТЕРИНБУРГ"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Street", "УЛИЦА НИКОЛАЯ НИКОНОВА"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Building", "ДОМ 18"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Room", "ПОМЕЩЕИЕ 73"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Room", "ПОМЕЩЕИЕ 73"));
        return ExpertOrganization;
    }
}