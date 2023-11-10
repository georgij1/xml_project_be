package com.xml_project_be.xml_project.file.xml_file;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GetSummary {
    public static Node getSummary(org.w3c.dom.Document doc) {
        Element node = doc.createElement("Summary");
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("1"));
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("2"));
        node.appendChild(doc.createElement("EngineeringSurveyType")).appendChild(doc.createTextNode("4"));
        node.appendChild(doc.createElement("ProjectDocumentsSummary")).appendChild(doc.createTextNode("""
                Изменения, внесенные в проектные решения, не повлияли на общую устойчивость и
                            конструктивную неизменяемость объекта в целом, не влекут за собой превышение предельных параметров
                            разрешенного строительства объекта (высоты, этажности, объема), полностью совместимы с ранее принятыми
                            техническими решениями в разделах, изменения в которые не вносились.

                            Проектная документация соответствует требованиям технических регламентов и сводов правил (применение которых
                            на обязательной основе включен в перечень, утвержденный Постановлением Правительства РФ № 985 от
                            04.07.2020), иным установленным требованиям, а также результатам инженерных изысканий, выполненных для
                            подготовки проектной документации, и заданию на проектирование."""));
        node.appendChild(doc.createElement("ProjectDocumentsSummaryDate")).appendChild(doc.createTextNode("""
                Экспертная оценка проведена на соответствие требованиям, примененным при
                            первоначальном проведении экспертизы проектной документации и результатов инженерных изысканий, по
                            результатам которого было получено положительное заключение от 17.03.2021 № 66-2-1-012042-2021."""));
        node.appendChild(doc.createElement("ExaminationSummary")).appendChild(doc.createTextNode("""
                Проектная документация по объекту: «Жилая многоэтажная застройка квартала 4.15.1 в границах
                            улиц Краснолесья – Рябинина – Очеретина в Академическом районе
                            г. Екатеринбурга»
                            - соответствует результатам инженерных изысканий, выполненных для её подготовки;
                            - соответствует заданию на проектирование;
                            - соответствует техническим регламентам и иным установленным требованиям."""));
        return node;
    }
}