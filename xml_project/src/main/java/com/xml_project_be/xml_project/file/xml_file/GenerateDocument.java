package com.xml_project_be.xml_project.file.xml_file;

import com.xml_project_be.xml_project.file.dir.CheckMKDir;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import static com.xml_project_be.xml_project.file.xml_file.GetApprover.getApprover;
import static com.xml_project_be.xml_project.file.xml_file.GetCadastralNumber.getCadastralNumber;
import static com.xml_project_be.xml_project.file.xml_file.GetClimateConditions.getClimateConditions;
import static com.xml_project_be.xml_project.file.xml_file.GetClimateConditionsNote.getClimateConditionsNote;
import static com.xml_project_be.xml_project.file.xml_file.GetDeclarant.getDeclarant;
import static com.xml_project_be.xml_project.file.xml_file.GetDesigner.getDesigner;
import static com.xml_project_be.xml_project.file.xml_file.GetDocuments.getDocuments;
import static com.xml_project_be.xml_project.file.xml_file.GetExaminationObject.getExaminationObject;
import static com.xml_project_be.xml_project.file.xml_file.GetExpertOrganization.getExpertOrganization;
import static com.xml_project_be.xml_project.file.xml_file.GetExpertProjectDocuments.getExpertProjectDocuments;
import static com.xml_project_be.xml_project.file.xml_file.GetExpress.getExperts;
import static com.xml_project_be.xml_project.file.xml_file.GetFinance.getFinance;
import static com.xml_project_be.xml_project.file.xml_file.GetObject.getObject;
import static com.xml_project_be.xml_project.file.xml_file.GetPreviousConclusions.getPreviousConclusions;
import static com.xml_project_be.xml_project.file.xml_file.GetPreviousSimpleConclusions.getPreviousSimpleConclusions;
import static com.xml_project_be.xml_project.file.xml_file.GetProjectDocumentsDeveloper.getProjectDocumentsDeveloper;
import static com.xml_project_be.xml_project.file.xml_file.GetSummary.getSummary;
import static java.nio.file.Paths.get;

@AllArgsConstructor
@Data
public class GenerateDocument {
    static DocumentBuilder builder;
    static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    @SneakyThrows
    public static ResponseEntity<?> generateDocument(Integer IdFile, String NameCompany, JdbcTemplate jdbcTemplate) {
        /* File file_dir = new File("/home/georgii/Загрузки/uploads/" + NameCompany + "/xml");*/
        // String DEST_XML = get("/home/georgii/Загрузки/uploads/" + NameCompany + "/xml/" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name")) + ".xml";

        
        /*
        * Bellow this code for windows
        * */
        
        File file_dir = new File("C:\\Users\\Panov\\Downloads\\uploads\\" + NameCompany + "\\xml");
        CheckMKDir.check_dir_exist(file_dir);
        String DEST_XML = String.valueOf(get("C:\\Users\\Panov\\Downloads\\uploads\\" + NameCompany + "\\xml\\" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name") + ".xml"));
        String DEST_WORD = String.valueOf(get("C:\\Users\\Panov\\Downloads\\uploads\\" + NameCompany + "\\" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name")));
        builder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        rootElement.setAttribute("ConclusionGUID", "d1ca32e2-a8f0-4776-a499-1d946c6f6064");
        rootElement.setAttribute("SchemaVersion", "01.00");
        rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "conclusion.xsd");
        rootElement.appendChild(getExpertOrganization(doc, DEST_WORD));
        rootElement.appendChild(getApprover(doc));
        rootElement.appendChild(getExaminationObject(doc));
        rootElement.appendChild(getDocuments(doc));
        rootElement.appendChild(getPreviousConclusions(doc));
        rootElement.appendChild(getPreviousSimpleConclusions(doc));
        rootElement.appendChild(getObject(doc));
        rootElement.appendChild(getCadastralNumber(doc));
        rootElement.appendChild(getDeclarant(doc));
        rootElement.appendChild(getProjectDocumentsDeveloper(doc));
        rootElement.appendChild(getFinance(doc));
        rootElement.appendChild(getClimateConditions(doc));
        rootElement.appendChild(getClimateConditionsNote(doc));
        rootElement.appendChild(getDesigner(doc));
        rootElement.appendChild(getExpertProjectDocuments(doc));
        rootElement.appendChild(getSummary(doc));
        rootElement.appendChild(getExperts(doc));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult file = new StreamResult(new File((file_dir).toURI())+"\\" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name") + ".xml");
        transformer.transform(source, file);
        Path path = Paths.get(DEST_XML);
        List<String> allLines = Files.readAllLines(path);
        return ResponseEntity.ok().body(allLines);
    }
}