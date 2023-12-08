package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetObject {
    public static Node getObject(
            Document doc,
            String DEST_WORD
    ) {
        Element node = doc.createElement("Object");
        node.appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("Жилая многоэтажная застройка квартала 4.15.1 в границах улиц Краснолесья – Рябинина – Очеретина в Академическом районе г. Екатеринбурга"));
        node.appendChild(doc.createElement("Type")).appendChild(doc.createTextNode("2"));
        node.appendChild(doc.createElement("Functions")).appendChild(doc.createTextNode("жилые объекты для постоянного проживания -- многоэтажный многоквартирный жилой дом (код 19.7.1.5 в соответствии с Пр. Минстроя от 10.07.2020 № 374/пр)"));
        node.appendChild(doc.createElement("Address")).appendChild(doc.createElement("Country")).appendChild(doc.createTextNode("Россия"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("66"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Город Екатеринбург"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Note")).appendChild(doc.createTextNode("Верх-Исетский район, в границах улиц Амундсена – Институтской – дублера Серафимы Дерябиной"));
        node.appendChild(doc.createElement("TEI")).appendChild(doc.createElement("Name")).appendChild(doc.createTextNode("1 этап строительства. Жилой дом № 1. Жилой дом № 2. Площадь земельного участка по ГПЗУ"));
        node.getElementsByTagName("TEI").item(0).appendChild(doc.createElement("Measure")).appendChild(doc.createTextNode("м2"));
        node.getElementsByTagName("TEI").item(0).appendChild(doc.createElement("Value")).appendChild(doc.createTextNode("14087,0"));
        return node;
    }
}