package com.xml_project_be.xml_project.file.xml_file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.*;

import static com.xml_project_be.xml_project.file.xml_file.GetApprover.getApprover;
import static com.xml_project_be.xml_project.file.xml_file.GetApprover.getApproverFE;
import static com.xml_project_be.xml_project.file.xml_file.GetCadastralNumber.getCadastralNumber;
import static com.xml_project_be.xml_project.file.xml_file.GetCadastralNumber.getCadastralNumberFE;
import static com.xml_project_be.xml_project.file.xml_file.GetClimateConditions.getClimateConditions;
import static com.xml_project_be.xml_project.file.xml_file.GetClimateConditionsNote.getClimateConditionsNote;
import static com.xml_project_be.xml_project.file.xml_file.GetDeclarant.getDeclarant;
import static com.xml_project_be.xml_project.file.xml_file.GetDesigner.getDesigner;
import static com.xml_project_be.xml_project.file.xml_file.GetDocuments.getDocuments;
import static com.xml_project_be.xml_project.file.xml_file.GetExaminationObject.getExaminationObject;
import static com.xml_project_be.xml_project.file.xml_file.GetExpertOrganization.getExpertOrganization;
import static com.xml_project_be.xml_project.file.xml_file.GetExpertOrganization.getExpertOrganizationFE;
import static com.xml_project_be.xml_project.file.xml_file.GetExpertProjectDocuments.getExpertProjectDocuments;
import static com.xml_project_be.xml_project.file.xml_file.GetExperts.getExperts;
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
    public static ResponseEntity<?> getExpertOrganization_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\ExpertOrganization.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getExpertOrganization_HashMap.put("table", myJsonObject_1.getTable());
        getExpertOrganization_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getExpertOrganization_HashMap.put("value_columns", getExpertOrganizationFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getApprover_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getApprover_HashMap = new HashMap<>();
        ArrayList<Object> getApprover_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\Approver.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getApprover_HashMap.put("table", myJsonObject_1.getTable());
        getApprover_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getApprover_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getApprover_arrayList.add(getApprover_HashMap);
        return ResponseEntity.ok().body(getApprover_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getCadastralNumber_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getCadastralNumberFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDocuments_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getPreviousConclusions_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getPreviousSimpleConclusions_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDeclarant_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getProjectDocumentsDeveloper_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getFinance_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getClimateConditions_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getClimateConditionsNote_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getExpertProjectDocuments_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getExperts_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDesigner_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getSummary_object(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getCadastralNumber_HashMap = new HashMap<>();
        ArrayList<Object> getCadastralNumber_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\CadastralNumber.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getCadastralNumber_HashMap.put("table", myJsonObject_1.getTable());
        getCadastralNumber_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getCadastralNumber_HashMap.put("value_columns", getApproverFE(IdFile, NameCompany, jdbcTemplate));
        getCadastralNumber_arrayList.add(getCadastralNumber_HashMap);
        return ResponseEntity.ok().body(getCadastralNumber_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getNotFoundObject() {
        ArrayList<?> getNotFound = new ArrayList<>();
        getNotFound.add(null);
        return ResponseEntity.ok().body(getNotFound);
    }

    @SneakyThrows
    public static ResponseEntity<?> generateDocument(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        File file_dir = new File("/home/georgii/Загрузки/uploads/" + NameCompany + "/xml");
        String DEST_XML = get("/home/georgii/Загрузки/uploads/" + NameCompany + "/xml/" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name")) + ".xml";
        CheckMKDir.check_dir_exist(file_dir);
        String DEST_WORD = String.valueOf(get("/home/georgii/Загрузки/uploads/" + NameCompany + "/" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name")));
        builder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tableXML.json");
        ObjectMapper objectMapper = new ObjectMapper();
        MyJsonObject myJsonObject = objectMapper.readValue(file_1, new TypeReference<>() {});
        rootElement.setAttribute("ConclusionGUID", "d1ca32e2-a8f0-4776-a499-1d946c6f6064");
        rootElement.setAttribute("SchemaVersion", "01.00");
        rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "conclusion.xsd");
        rootElement.appendChild(getExpertOrganization(doc, DEST_WORD, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getApprover(doc, DEST_WORD, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getExaminationObject(doc, DEST_WORD, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getDocuments(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getPreviousConclusions(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getPreviousSimpleConclusions(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getCadastralNumber(doc, DEST_WORD, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getObject(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getDeclarant(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getProjectDocumentsDeveloper(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getFinance(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getClimateConditions(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getClimateConditionsNote(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getDesigner(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getExpertProjectDocuments(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getSummary(doc, NameCompany, IdFile, jdbcTemplate));
        rootElement.appendChild(getExperts(doc, DEST_WORD, NameCompany, IdFile, jdbcTemplate));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult file = new StreamResult(new File((file_dir).toURI())+"/" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name") + ".xml");
        transformer.transform(source, file);
        DomainBeanXML domainBeanPdf = new DomainBeanXML();
        ArrayList<DomainBeanXML> arrayList = new ArrayList<>();
        File fileXML = new File(DEST_XML);
        BufferedReader reader = new BufferedReader(new FileReader(fileXML));
        String line;
        ArrayList<String> arrayList1 = new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            arrayList1.add(line);
        }
        reader.close();
        JsonNode rootNode = objectMapper.readTree(file_1);
        int objectCount = rootNode.get("tables").size();
        String FileName = jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name").toString();
        domainBeanPdf.setName_file(Collections.singletonList((FileName.replace(".docx", "")) + ".xml"));
        domainBeanPdf.setContent_file(Collections.singletonList(arrayList1.toArray()));
        domainBeanPdf.setTables(myJsonObject.getTables());
        domainBeanPdf.setCount_tables(objectCount);
        arrayList.add(domainBeanPdf);
        return ResponseEntity.ok().body(arrayList);
    }
}