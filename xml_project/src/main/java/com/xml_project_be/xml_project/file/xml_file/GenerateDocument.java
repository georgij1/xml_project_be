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
import static com.xml_project_be.xml_project.file.xml_file.GetClimateConditions.getClimateConditionsFE;
import static com.xml_project_be.xml_project.file.xml_file.GetClimateConditionsNote.getClimateConditionsNote;
import static com.xml_project_be.xml_project.file.xml_file.GetClimateConditionsNote.getClimateConditionsNoteFE;
import static com.xml_project_be.xml_project.file.xml_file.GetDeclarant.getDeclarant;
import static com.xml_project_be.xml_project.file.xml_file.GetDeclarant.getDeclarantFE;
import static com.xml_project_be.xml_project.file.xml_file.GetDesigner.getDesigner;
import static com.xml_project_be.xml_project.file.xml_file.GetDesigner.getDesignerFE;
import static com.xml_project_be.xml_project.file.xml_file.GetDocuments.getDocuments;
import static com.xml_project_be.xml_project.file.xml_file.GetDocuments.getDocumentsFE;
import static com.xml_project_be.xml_project.file.xml_file.GetExaminationObject.getExaminationObject;
import static com.xml_project_be.xml_project.file.xml_file.GetExpertOrganization.getExpertOrganization;
import static com.xml_project_be.xml_project.file.xml_file.GetExpertOrganization.getExpertOrganizationFE;
import static com.xml_project_be.xml_project.file.xml_file.GetExpertProjectDocuments.getExpertProjectDocuments;
import static com.xml_project_be.xml_project.file.xml_file.GetExpertProjectDocuments.getExpertProjectDocumentsFE;
import static com.xml_project_be.xml_project.file.xml_file.GetExperts.getExperts;
import static com.xml_project_be.xml_project.file.xml_file.GetExperts.getExpertsFE;
import static com.xml_project_be.xml_project.file.xml_file.GetFinance.getFinance;
import static com.xml_project_be.xml_project.file.xml_file.GetFinance.getFinanceFE;
import static com.xml_project_be.xml_project.file.xml_file.GetObject.getObject;
import static com.xml_project_be.xml_project.file.xml_file.GetOrgElementsValueFunc_PreviousConsultation.getPreviousConclusionsFE;
import static com.xml_project_be.xml_project.file.xml_file.GetPreviousConclusions.getPreviousConclusions;
import static com.xml_project_be.xml_project.file.xml_file.GetPreviousSimpleConclusion.getPreviousSimpleConclusionsFE;
import static com.xml_project_be.xml_project.file.xml_file.GetPreviousSimpleConclusions.getPreviousSimpleConclusions;
import static com.xml_project_be.xml_project.file.xml_file.GetProjectDocumentsDeveloper.getProjectDocumentsDeveloper;
import static com.xml_project_be.xml_project.file.xml_file.GetProjectDocumentsDeveloper.getProjectDocumentsDeveloperFE;
import static com.xml_project_be.xml_project.file.xml_file.GetSummary.getSummary;
import static com.xml_project_be.xml_project.file.xml_file.GetSummary.getSummaryFE;
import static com.xml_project_be.xml_project.file.xml_file.NotFound.getNotFoundFE;
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
        HashMap<Object, Object> getDocuments_HashMap = new HashMap<>();
        ArrayList<Object> getDocuments_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\Documents.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getDocuments_HashMap.put("table", myJsonObject_1.getTable());
        getDocuments_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getDocuments_HashMap.put("value_columns", getDocumentsFE(IdFile, NameCompany, jdbcTemplate));
        getDocuments_arrayList.add(getDocuments_HashMap);
        return ResponseEntity.ok().body(getDocuments_arrayList);
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
        HashMap<Object, Object> getPreviousConclusions_HashMap = new HashMap<>();
        ArrayList<Object> getPreviousConclusions_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\PreviousConclusions.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getPreviousConclusions_HashMap.put("table", myJsonObject_1.getTable());
        getPreviousConclusions_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getPreviousConclusions_HashMap.put("value_columns", getPreviousConclusionsFE(IdFile, NameCompany, jdbcTemplate));
        getPreviousConclusions_arrayList.add(getPreviousConclusions_HashMap);
        return ResponseEntity.ok().body(getPreviousConclusions_arrayList);
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
        HashMap<Object, Object> getPreviousSimpleConclusions_HashMap = new HashMap<>();
        ArrayList<Object> getPreviousSimpleConclusions_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\PreviousSimpleConclusions.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getPreviousSimpleConclusions_HashMap.put("table", myJsonObject_1.getTable());
        getPreviousSimpleConclusions_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getPreviousSimpleConclusions_HashMap.put("value_columns", getPreviousSimpleConclusionsFE(IdFile, NameCompany, jdbcTemplate));
        getPreviousSimpleConclusions_arrayList.add(getPreviousSimpleConclusions_HashMap);
        return ResponseEntity.ok().body(getPreviousSimpleConclusions_arrayList);
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
        HashMap<Object, Object> getDeclarant_HashMap = new HashMap<>();
        ArrayList<Object> getDeclarant_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\Declarant.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getDeclarant_HashMap.put("table", myJsonObject_1.getTable());
        getDeclarant_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getDeclarant_HashMap.put("value_columns", getDeclarantFE(IdFile, NameCompany, jdbcTemplate));
        getDeclarant_arrayList.add(getDeclarant_HashMap);
        return ResponseEntity.ok().body(getDeclarant_arrayList);
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
        HashMap<Object, Object> getProjectDocumentsDeveloper_HashMap = new HashMap<>();
        ArrayList<Object> getProjectDocumentsDeveloper_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\ProjectDocumentsDeveloper.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getProjectDocumentsDeveloper_HashMap.put("table", myJsonObject_1.getTable());
        getProjectDocumentsDeveloper_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getProjectDocumentsDeveloper_HashMap.put("value_columns", getProjectDocumentsDeveloperFE(IdFile, NameCompany, jdbcTemplate));
        getProjectDocumentsDeveloper_arrayList.add(getProjectDocumentsDeveloper_HashMap);
        return ResponseEntity.ok().body(getProjectDocumentsDeveloper_arrayList);
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
        HashMap<Object, Object> getFinance_HashMap = new HashMap<>();
        ArrayList<Object> getFinance_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\Finance.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getFinance_HashMap.put("table", myJsonObject_1.getTable());
        getFinance_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getFinance_HashMap.put("value_columns", getFinanceFE(IdFile, NameCompany, jdbcTemplate));
        getFinance_arrayList.add(getFinance_HashMap);
        return ResponseEntity.ok().body(getFinance_arrayList);
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
        HashMap<Object, Object> getClimateConditions_HashMap = new HashMap<>();
        ArrayList<Object> getClimateConditions_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\ClimateConditions.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getClimateConditions_HashMap.put("table", myJsonObject_1.getTable());
        getClimateConditions_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getClimateConditions_HashMap.put("value_columns", getClimateConditionsFE(IdFile, NameCompany, jdbcTemplate));
        getClimateConditions_arrayList.add(getClimateConditions_HashMap);
        return ResponseEntity.ok().body(getClimateConditions_arrayList);
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
        HashMap<Object, Object> getClimateConditions_HashMap = new HashMap<>();
        ArrayList<Object> getClimateConditions_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\ClimateConditions.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getClimateConditions_HashMap.put("table", myJsonObject_1.getTable());
        getClimateConditions_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getClimateConditions_HashMap.put("value_columns", getClimateConditionsNoteFE(IdFile, NameCompany, jdbcTemplate));
        getClimateConditions_arrayList.add(getClimateConditions_HashMap);
        return ResponseEntity.ok().body(getClimateConditions_arrayList);
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
        HashMap<Object, Object> getExpertProjectDocuments_HashMap = new HashMap<>();
        ArrayList<Object> getExpertProjectDocuments_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\ExpertProjectDocuments.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getExpertProjectDocuments_HashMap.put("table", myJsonObject_1.getTable());
        getExpertProjectDocuments_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getExpertProjectDocuments_HashMap.put("value_columns", getExpertProjectDocumentsFE(IdFile, NameCompany, jdbcTemplate));
        getExpertProjectDocuments_arrayList.add(getExpertProjectDocuments_HashMap);
        return ResponseEntity.ok().body(getExpertProjectDocuments_arrayList);
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
        HashMap<Object, Object> getExperts_HashMap = new HashMap<>();
        ArrayList<Object> getExperts_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\Experts.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getExperts_HashMap.put("table", myJsonObject_1.getTable());
        getExperts_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getExperts_HashMap.put("value_columns", getExpertsFE(IdFile, NameCompany, jdbcTemplate));
        getExperts_arrayList.add(getExperts_HashMap);
        return ResponseEntity.ok().body(getExperts_arrayList);
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
        HashMap<Object, Object> getDesigner_HashMap = new HashMap<>();
        ArrayList<Object> getDesigner_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\Designer.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getDesigner_HashMap.put("table", myJsonObject_1.getTable());
        getDesigner_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getDesigner_HashMap.put("value_columns", getDesignerFE(IdFile, NameCompany, jdbcTemplate));
        getDesigner_arrayList.add(getDesigner_HashMap);
        return ResponseEntity.ok().body(getDesigner_arrayList);
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
        HashMap<Object, Object> getSummary_HashMap = new HashMap<>();
        ArrayList<Object> getSummary_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\Summary.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getSummary_HashMap.put("table", myJsonObject_1.getTable());
        getSummary_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getSummary_HashMap.put("value_columns", getSummaryFE(IdFile, NameCompany, jdbcTemplate));
        getSummary_arrayList.add(getSummary_HashMap);
        return ResponseEntity.ok().body(getSummary_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getNotFoundObject() {
        HashMap<Object, Object> getNotFound_HashMap = new HashMap<>();
        ArrayList<Object> getNotFound_arrayList = new ArrayList<>();
        File file_1 = new File("C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\configs\\tables\\NotFound.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(file_1);
        System.out.println(rootNode.get("table").get("columns").size());
        MyJsonObject_1 myJsonObject_1 = objectMapper.readValue(file_1, new TypeReference<>() {});
        getNotFound_HashMap.put("table", myJsonObject_1.getTable());
        getNotFound_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
        getNotFound_HashMap.put("value_columns", getNotFoundFE());
        getNotFound_arrayList.add(getNotFound_HashMap);
        return ResponseEntity.ok().body(getNotFound_arrayList);
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