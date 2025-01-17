package com.xml_project_be.xml_project.file.xml_file.reader;

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

import static com.xml_project_be.xml_project.file.xml_file.reader.GetApprover.getApprover;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetApprover.getApproverFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetCadastralNumber.getCadastralNumber;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetCadastralNumber.getCadastralNumberFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetClimateConditions.getClimateConditions;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetClimateConditions.getClimateConditionsFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetClimateConditionsNote.getClimateConditionsNote;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetClimateConditionsNote.getClimateConditionsNoteFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetDeclarant.getDeclarant;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetDeclarant.getDeclarantFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetDesigner.getDesigner;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetDesigner.getDesignerFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetDocuments.getDocuments;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetDocuments.getDocumentsFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetExaminationObject.getExaminationObject;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetExaminationObject.getExaminationObjectFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetExpertOrganization.getExpertOrganization;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetExpertOrganization.getExpertOrganizationFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetExpertProjectDocuments.getExpertProjectDocuments;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetExpertProjectDocuments.getExpertProjectDocumentsFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetExperts.getExperts;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetExperts.getExpertsFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetFinance.getFinance;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetFinance.getFinanceFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetObject.getObject;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetObject.getObjectFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetOrgElementsValueFunc_PreviousConsultation.getPreviousConclusionsFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetPreviousConclusions.getPreviousConclusions;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetPreviousSimpleConclusion.getPreviousSimpleConclusionsFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetPreviousSimpleConclusions.getPreviousSimpleConclusions;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetProjectDocumentsDeveloper.getProjectDocumentsDeveloper;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetProjectDocumentsDeveloper.getProjectDocumentsDeveloperFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetSummary.getSummary;
import static com.xml_project_be.xml_project.file.xml_file.reader.GetSummary.getSummaryFE;
import static com.xml_project_be.xml_project.file.xml_file.reader.NotFound.getNotFoundFE;
import static java.nio.file.Paths.get;

@AllArgsConstructor
@Data
public class GenerateDocument {
    static DocumentBuilder builder;
    static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    static String structureData_StructureXMLFile_json = "C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\structure_data\\StructureXMLFile.json";
    static String structureData_Appendix_1_json = "C:\\Users\\Panov\\OneDrive\\Рабочий стол\\xml_project_be\\xml_project\\src\\main\\java\\com\\xml_project_be\\xml_project\\file\\xml_file\\structure_data\\Appendix_1.json";

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_root_element(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        //File file_1 = new File(structureData_StructureXMLFile_json);
        //ObjectMapper objectMapper = new ObjectMapper();
        //JsonNode rootNode = objectMapper.readTree(file_1);
        //System.out.println(rootNode.get("description_of_the_root_element"));
        //getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_root_element"));
        //getExpertOrganization_HashMap.put("value_columns", description_of_the_root_elementFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_complex_field_types(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        //JsonNode rootNode = objectMapper.readTree(file_1);
        //System.out.println(rootNode.get("description_of_complex_field_types"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_complex_field_types"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_complex_field_typesFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tPostAddress_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tPostAddress_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tPostAddress_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tPostAddress_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tOrganization_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tOrganization_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tOrganization_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tOrganization_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tIP_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tIP_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tIP_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tIP_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tPerson_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tPerson_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tPerson_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tPerson_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tWorkPerson_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tWorkPerson_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tWorkPerson_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tWorkPerson_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tExaminationObject_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tWorkPerson_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tExaminationObject_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tExaminationObject_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tDocuments_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tDocuments_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tDocuments_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tDocuments_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tDocument_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tDocument_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tDocument_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tDocument_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tFile_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tFile_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tFile_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tFile_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tSignFile_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tSignFile_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tSignFile_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tSignFile_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tPreviousSimpleConclusions_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tPreviousSimpleConclusions_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tPreviousSimpleConclusions_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tPreviousSimpleConclusions_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tConclusionNumber_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tConclusionNumber_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tConclusionNumber_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tConclusionNumber_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tPreviousConclusion_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tPreviousConclusion_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tPreviousConclusion_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tPreviousConclusion_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tPreviousSimpleConclusion_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tPreviousSimpleConclusion_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tPreviousSimpleConclusion_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tPreviousSimpleConclusion_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tObject_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        //File file_1 = new File(structureData_StructureXMLFile_json);
        //ObjectMapper objectMapper = new ObjectMapper();
        //JsonNode rootNode = objectMapper.readTree(file_1);
        //System.out.println(rootNode.get("description_of_the_complex_tObject_type"));
        //getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tObject_type"));
        //getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tObject_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tObjectPart_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tObjectPart_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tObjectPart_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tObjectPart_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tTEI_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tTEI_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tTEI_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tTEI_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tDeclarant_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tDeclarant_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tDeclarant_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tDeclarant_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tTechnicalCustomer_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tTechnicalCustomer_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tTechnicalCustomer_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tTechnicalCustomer_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tFinance_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tFinance_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tFinance_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tFinance_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tClimateConditions_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tClimateConditions_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tClimateConditions_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tClimateConditions_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tEstimatedCost_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tEstimatedCost_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tEstimatedCost_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tEstimatedCost_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tComplexEstimatedCost_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tComplexEstimatedCost_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tComplexEstimatedCost_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tComplexEstimatedCost_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tDesigner_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tDesigner_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tDesigner_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tDesigner_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tEEPDUse_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tEEPDUse_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tEEPDUse_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tEEPDUse_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tEngineeringSurveyAddress_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tEngineeringSurveyAddress_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tEngineeringSurveyAddress_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tEngineeringSurveyAddress_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tExperts_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tExperts_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tExperts_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tExperts_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tExpert_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tExpert_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tExpert_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tExpert_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tExpertEngineeringSurveys_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tExpertEngineeringSurveys_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tExpertEngineeringSurveys_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tExpertEngineeringSurveys_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tEngineeringSurveyMismatches_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tEngineeringSurveyMismatches_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tEngineeringSurveyMismatches_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tEngineeringSurveyMismatches_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tExpertProjectDocuments_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tExpertProjectDocuments_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tExpertProjectDocuments_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tExpertProjectDocuments_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tProjectDocumentsMismatches_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tProjectDocumentsMismatches_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tProjectDocumentsMismatches_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tProjectDocumentsMismatches_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tExpertEstimate_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tExpertEstimate_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tExpertEstimate_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tExpertEstimate_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tEstimateMismatches_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tEstimateMismatches_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tEstimateMismatches_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tEstimateMismatches_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tSummary_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tSummary_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tSummary_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tSummary_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tMismatch_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tMismatch_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tMismatch_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tMismatch_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tMismatchExtended_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tMismatch_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tMismatchExtended_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tMismatchExtended_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getDescription_of_the_complex_tSeismicActivityCalculatedValue_type(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("description_of_the_complex_tSeismicActivityCalculatedValue_type"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("description_of_the_complex_tSeismicActivityCalculatedValue_type"));
        // getExpertOrganization_HashMap.put("value_columns", description_of_the_complex_tSeismicActivityCalculatedValue_typeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getForm_examination_tExaminationForm(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("form_examination_tExaminationForm"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("form_examination_tExaminationForm"));
        // getExpertOrganization_HashMap.put("value_columns", form_examination_tExaminationFormFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getResult_examination_tExaminationResult(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("result_examination_tExaminationResult"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("result_examination_tExaminationResult"));
        // getExpertOrganization_HashMap.put("value_columns", result_examination_tExaminationResultFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getView_examination_tExaminationStage(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("view_examination_tExaminationStage"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("view_examination_tExaminationStage"));
        // getExpertOrganization_HashMap.put("value_columns", view_examination_tExaminationStageFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getView_object_examination_tExaminationObjectType(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("view_object_examination_tExaminationObjectType"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("view_object_examination_tExaminationObjectType"));
        // getExpertOrganization_HashMap.put("value_columns", view_object_examination_tExaminationObjectTypeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getView_work_tConstractionType(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("view_work_tConstractionType"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("view_work_tConstractionType"));
        // getExpertOrganization_HashMap.put("value_columns", view_work_tConstractionTypeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getView_work_examination_tDocumentType(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("view_work_examination_tDocumentType"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("view_work_examination_tDocumentType"));
        // getExpertOrganization_HashMap.put("value_columns", view_work_examination_tDocumentTypeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getView_work_capital_construction_tObjectType(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("view_work_capital_construction_tObjectType"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("view_work_capital_construction_tObjectType"));
        // getExpertOrganization_HashMap.put("value_columns", view_work_capital_construction_tObjectTypeFE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getСodes_of_the_subjects_of_the_russian_federation_tRegionsRF(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("codes_of_the_subjects_of_the_russian_federation_tRegionsRF"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("codes_of_the_subjects_of_the_russian_federation_tRegionsRF"));
        // getExpertOrganization_HashMap.put("value_columns", codes_of_the_subjects_of_the_russian_federation_tRegionsRF_FE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getView_finance_storage_tFinanceType(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("view_finance_storage_tFinanceType"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("view_finance_storage_tFinanceType"));
        // getExpertOrganization_HashMap.put("value_columns", view_finance_storage_tFinanceType_FE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getBudget_level_tBudgetType(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("budget_level_tBudgetType"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("budget_level_tBudgetType"));
        // getExpertOrganization_HashMap.put("value_columns", budget_level_tBudgetType_FE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getThe_direction_of_the_expert_activity_tExpertType(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("the_direction_of_the_expert_activity_tExpertType"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("the_direction_of_the_expert_activity_tExpertType"));
        // getExpertOrganization_HashMap.put("value_columns", the_direction_of_the_expert_activity_tExpertType_FE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getTypes_of_engineering_surveys_tEngineeringSurveyType(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("types_of_engineering_surveys_tEngineeringSurveyType"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("types_of_engineering_surveys_tEngineeringSurveyType"));
        // getExpertOrganization_HashMap.put("value_columns", types_of_engineering_surveys_tEngineeringSurveyType_FE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getClimatic_region_subdistrict_tClimateDistrict(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("climatic_region_subdistrict_tClimateDistrict"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("climatic_region_subdistrict_tClimateDistrict"));
        // getExpertOrganization_HashMap.put("value_columns", climatic_region_subdistrict_tClimateDistrict_FE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getCategory_of_complexity_of_engineering_and_geological_conditions_tGeologicalCondition(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("category_of_complexity_of_engineering_and_geological_conditions_tGeologicalCondition"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("category_of_complexity_of_engineering_and_geological_conditions_tGeologicalCondition"));
        // getExpertOrganization_HashMap.put("value_columns", category_of_complexity_of_engineering_and_geological_conditions_tGeologicalCondition_FE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getThe_wind_district_tWindDistrict(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("the_wind_district_tWindDistrict"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("the_wind_district_tWindDistrict"));
        // getExpertOrganization_HashMap.put("value_columns", the_wind_district_tWindDistrict_FE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getThe_snow_district_tSnowDistrict(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("the_snow_district_tSnowDistrict"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("the_snow_district_tSnowDistrict"));
        // getExpertOrganization_HashMap.put("value_columns", the_snow_district_tSnowDistrict_FE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getIntensity_of_seismic_impacts_tSeismicActivity(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("intensity_of_seismic_impacts_tSeismicActivity"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("intensity_of_seismic_impacts_tSeismicActivity"));
        // getExpertOrganization_HashMap.put("value_columns", intensity_of_seismic_impacts_tSeismicActivity_FE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getThe_subject_of_the_examination_tExaminationType(
            Integer IdFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ){
        org.w3c.dom.Document doc = builder.newDocument();
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        HashMap<Object, Object> getExpertOrganization_HashMap = new HashMap<>();
        ArrayList<Object> getExpertOrganization_arrayList = new ArrayList<>();
        // File file_1 = new File(structureData_StructureXMLFile_json);
        // ObjectMapper objectMapper = new ObjectMapper();
        // JsonNode rootNode = objectMapper.readTree(file_1);
        // System.out.println(rootNode.get("the_subject_of_the_examination_tExaminationType"));
        // getExpertOrganization_HashMap.put("table", rootNode.get("the_subject_of_the_examination_tExaminationType"));
        // getExpertOrganization_HashMap.put("value_columns", the_subject_of_the_examination_tExaminationType_FE(IdFile, NameCompany, jdbcTemplate));
        getExpertOrganization_arrayList.add(getExpertOrganization_HashMap);
        return ResponseEntity.ok().body(getExpertOrganization_arrayList);
    }

    @SneakyThrows
    public static ResponseEntity<?> getNotFoundObject() {
        HashMap<Object, Object> getNotFound_HashMap = new HashMap<>();
        ArrayList<Object> getNotFound_arrayList = new ArrayList<>();
//        File file_1 = new File(absolutePathTablesDir+"NotFound.json");
        // ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode rootNode = objectMapper.readTree(file_1);
//        System.out.println(rootNode.get("table").get("columns").size());
//        TableObject tableObject_ = objectMapper.readValue(file_1, new TypeReference<>() {});
//        getNotFound_HashMap.put("table", tableObject_.getTable());
//        getNotFound_HashMap.put("count_column_table", rootNode.get("table").get("columns").size());
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
        // Paths to files
        File file_dir = new File("C:\\Users\\Panov\\Downloads\\uploads\\" + NameCompany + "\\xml");
        // String DEST_XML = get("C:\\Users\\Panov\\Downloads\\uploads\\" + NameCompany + "\\xml\\" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name")) + ".xml";
        String DEST_WORD = String.valueOf(get("C:\\Users\\Panov\\Downloads\\uploads\\" + NameCompany + "\\" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name")));
//        File file_1 = new File(absolutePathMainFileTable+"tableXML.json");

        // check create dir
        CheckMKDir.check_dir_exist(file_dir);

        // builder for document
        // builder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.newDocument();

        // create elements
        Element rootElement = doc.createElement("Conclusion");
        doc.appendChild(rootElement);
        // ObjectMapper objectMapper = new ObjectMapper();
//        TablesObject tablesObject = objectMapper.readValue(file_1, new TypeReference<>() {});
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
        // TransformerFactory transformerFactory = TransformerFactory.newInstance();
        // Transformer transformer = transformerFactory.newTransformer();
        // transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        // DOMSource source = new DOMSource(doc);
        // StreamResult file = new StreamResult(new File((file_dir).toURI())+"/" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name") + ".xml");
        // transformer.transform(source, file);
        ObjectTableXML domainBeanPdf = new ObjectTableXML();
        ArrayList<ObjectTableXML> arrayList = new ArrayList<>();
        // File fileXML = new File(DEST_XML);
        // BufferedReader reader = new BufferedReader(new FileReader(fileXML));
        // String line;
        // ArrayList<String> arrayList1 = new ArrayList<>();
        // while ((line = reader.readLine()) != null) {
        //     arrayList1.add(line);
        // }
        // reader.close();
//        JsonNode rootNode = objectMapper.readTree(file_1);
//        int objectCount = rootNode.get("tables").size();
//        domainBeanPdf.setName_file(Collections.singletonList("conclusion_" + UUID.randomUUID() + ".xml"));
//        domainBeanPdf.setContent_file(Collections.singletonList(arrayList1.toArray()));
//        domainBeanPdf.setTables(tablesObject.getTables());
//        domainBeanPdf.setCount_tables(objectCount);
        arrayList.add(domainBeanPdf);
        return ResponseEntity.ok().body(arrayList);
    }
}