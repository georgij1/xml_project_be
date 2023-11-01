package com.xml_project_be.xml_project.xml_file;

import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.words.Document;
import com.aspose.words.NodeType;
import com.aspose.words.Paragraph;
import com.aspose.words.SaveFormat;
import com.groupdocs.parser.options.IDocumentInfo;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import com.groupdocs.parser.Parser;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.*;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class ControllerFile {
    JdbcTemplate jdbcTemplate;
    // define a location
    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

    // Define a method to upload files
    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadFiles(
            @RequestParam("files") List<MultipartFile> multipartFiles,
            @RequestParam("NameCompany") String NameCompany,
            @RequestParam("Author") String Author,
            @RequestParam("TimeStamp") String TimeStamp
    ) throws IOException {
        List<String> filenames = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(select image_name from files where image_name=? and author=?)", Boolean.class, filename, Author))) {
                if (file.getOriginalFilename().contains(String.valueOf("doc"))) {
                    Path fileStorage = get(DIRECTORY + NameCompany, filename).toAbsolutePath().normalize();
                    copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
                    filenames.add(filename);
                    jdbcTemplate.update(
                            "insert into files(image_name, time_stamp, author, name_company) values (?,?,?, ?)",
                            file.getOriginalFilename(),
                            TimeStamp,
                            Author,
                            NameCompany
                    );
                } else {
                    return ResponseEntity.ok().body(Collections.singletonList("NotCorrect type of file"));
                }
            }
        }
        return ResponseEntity.ok().body(filenames);
    }

    @PostMapping("/list")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> list_files(
            @RequestBody Form NameCompany
    ) {
        if (Boolean.TRUE.equals(jdbcTemplate.queryForObject("select exists(select name_company from files where name_company=?)", Boolean.class, NameCompany.getNameCompany()))) {
            File f = new File(System.getProperty("user.home") + "/Downloads/uploads/" + NameCompany.getNameCompany());
            File[] files = f.listFiles();
            ArrayList<String> NameFiles = new ArrayList<>();
            for (File file_1 : Objects.requireNonNull(files)) {
                NameFiles.add(file_1.getName());
            }
            return ResponseEntity.ok().body(
                    jdbcTemplate.queryForList("select * from files where name_company=?", NameCompany.getNameCompany())
            );
        } else {
            ArrayList<DomainBean> arr = new ArrayList<>();
            DomainBean domainBean = new DomainBean();
            domainBean.setId_image("1");
            domainBean.setImage_name("Not found file");
            domainBean.setTime_stamp("Not found file");
            domainBean.setAuthor("Not found file");
            domainBean.setCompany("Not found file");
            arr.add(domainBean);
            return ResponseEntity.ok().body(arr);
        }
    }

    // read content word file
    @GetMapping("/read/{NameCompany}/{FileName}")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readFile(
            @PathVariable("FileName") Integer FileName,
            @PathVariable("NameCompany") String NameCompany
    ) {
        Document doc = new Document(System.getProperty("user.home") + "\\Downloads\\uploads\\" + NameCompany + "\\" + jdbcTemplate.queryForList("select image_name from files where id_image=?", FileName).get(0).get("image_name"));
        ArrayList<List> arrayList = new ArrayList<>();
        for (Object obj : doc.getChildNodes(NodeType.PARAGRAPH, true)) {
            Paragraph para = (Paragraph) obj;
            arrayList.add(Collections.singletonList(para.toString(SaveFormat.TEXT)));
        }
        return ResponseEntity.ok().body(arrayList);
    }

    // convert xml
    @GetMapping("/read/XML/{NameCompany}/{FileName}")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readXMLFile(
            @PathVariable("FileName") Integer IdFile,
            @PathVariable("NameCompany") String NameCompany
    ) {
        File file_dir = new File(System.getProperty("user.home") + "/Downloads/uploads/" + NameCompany + "/xml");
        if (!file_dir.exists()) file_dir.mkdir();
        String DEST = String.valueOf(get(System.getProperty("user.home") + "/Downloads/uploads" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name")));
        String DEST_XML = String.valueOf(get(System.getProperty("user.home") + "/Downloads/uploads" + "/" + NameCompany + "/xml/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name"))) + ".xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.newDocument();
            Element rootElement = doc.createElement("Conclusion");
            doc.appendChild(rootElement);
            rootElement.setAttribute("ConclusionGUID", "d1ca32e2-a8f0-4776-a499-1d946c6f6064");
            rootElement.setAttribute("SchemaVersion", "01.00");
            rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            rootElement.setAttribute("xsi:noNamespaceSchemaLocation", "conclusion.xsd");
            rootElement.appendChild(getExpertOrganization(doc));
            rootElement.appendChild(getApprover(doc));
            rootElement.appendChild(getExaminationObject(doc));
            rootElement.appendChild(getDocuments(doc));
            rootElement.appendChild(getPreviousConclusions(doc));
            rootElement.appendChild(getPreviousSimpleConclusions(doc));
            rootElement.appendChild(getObject(doc));
            rootElement.appendChild(getCadastralNumber(doc));
            rootElement.appendChild(getDeclarant(doc));
            rootElement.appendChild(getProjectDocumentsDeveloper(doc));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(DEST_XML));
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("Создание XML файла закончено");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body("");
    }

    private static Node getProjectDocumentsDeveloper(org.w3c.dom.Document doc) {
        Element node = doc.createElement("ProjectDocumentsDeveloper");
        node.appendChild(doc.createElement("Organization")).appendChild(doc.createElement("OrgFullName")).appendChild(doc.createTextNode("ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ СПЕЦИАЛИЗИРОВАННЫЙ ЗАСТРОЙЩИК ЛИДЕР КОНСТРАКШН"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgOGRN")).appendChild(doc.createTextNode("1076671026728"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgINN")).appendChild(doc.createTextNode("6671236301"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgKPP")).appendChild(doc.createTextNode("665801001"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("66"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Г. ЕКАТЕРИНБУРГ"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("УЛ. ВИКУЛОВА"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Д. 59/К. 1"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("ОФИС 303"));
        return node;
    }

    private static Node getDeclarant(org.w3c.dom.Document doc) {
        Element node = doc.createElement("Declarant");
        node.appendChild(doc.createElement("Organization")).appendChild(doc.createElement("OrgFullName")).appendChild(doc.createTextNode("ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ СПЕЦИАЛИЗИРОВАННЫЙ ЗАСТРОЙЩИК ЛИДЕР КОНСТРАКШН"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgOGRN")).appendChild(doc.createTextNode("1076671026728"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgINN")).appendChild(doc.createTextNode("6671236301"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("OrgKPP")).appendChild(doc.createTextNode("665801001"));
        node.getElementsByTagName("Organization").item(0).appendChild(doc.createElement("Address")).appendChild(doc.createElement("Region")).appendChild(doc.createTextNode("66"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("City")).appendChild(doc.createTextNode("Г. ЕКАТЕРИНБУРГ"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Street")).appendChild(doc.createTextNode("УЛ. ВИКУЛОВА"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Building")).appendChild(doc.createTextNode("Д. 59/К. 1"));
        node.getElementsByTagName("Address").item(0).appendChild(doc.createElement("Room")).appendChild(doc.createTextNode("ОФИС 303"));
        return node;
    }

    private static Node getCadastralNumber(org.w3c.dom.Document doc) {
        Element node = doc.createElement("CadastralNumber");
        node.appendChild(doc.createTextNode("66:41:0313121:85"));
        return node;
    }

    private static Node getObject(
            org.w3c.dom.Document doc
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

    private static Node getPreviousSimpleConclusions(org.w3c.dom.Document doc) {
        Element PreviousSimpleConclusions = doc.createElement("PreviousSimpleConclusions");
        PreviousSimpleConclusions.appendChild(getPreviousSimpleConclusion(
                doc,
                "PreviousSimpleConclusion",
                "Date",
                "2022-04-11",
                "Number",
                "0028-2022",
                "Result",
                "1"
        ));
        return PreviousSimpleConclusions;
    }

    private static Node getPreviousSimpleConclusion(
            org.w3c.dom.Document doc,
            String PreviousSimpleConclusion,
            String Date,
            String context_date,
            String Number,
            String context_number,
            String Result,
            String context_result
    ) {
        Element node = doc.createElement(PreviousSimpleConclusion);
        node.appendChild(doc.createElement(Date)).appendChild(doc.createTextNode(context_date));
        node.appendChild(doc.createElement(Number)).appendChild(doc.createTextNode(context_number));
        node.appendChild(doc.createElement(Result)).appendChild(doc.createTextNode(context_result));
        return node;
    }

    private static Node getPreviousConclusions(org.w3c.dom.Document doc) {
        Element PreviousConclusions = doc.createElement("PreviousConclusions");
        PreviousConclusions.appendChild(getOrgElementsValueFunc_PreviousConsultation(
                doc,
                PreviousConclusions,
                "PreviousConclusion",
                "Date",
                "2020-10-02"
        ));
        return PreviousConclusions;
    }

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

    private static Node getExpertOrganization(org.w3c.dom.Document doc) {
        Element ExpertOrganization = doc.createElement("ExpertOrganization");
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgFullName", "ОБЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ \"УРАЛЬСКОЕ УПРАВЛЕНИЕ СТРОИТЕЛЬНОЙ ЭКСПЕРТИЗЫ\""));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgOGRN", "1156658096275"));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgINN", "6678066419"));
        ExpertOrganization.appendChild(getOrgElementsValueTXT(doc, ExpertOrganization, "OrgKPP", "667801001"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "Region", "66"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "City", "ГОРОД ЕКАТЕРИНБУРГ"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "Street", "УЛИЦА НИКОЛАЯ НИКОНОВА"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "Building", "ДОМ 18"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "Room", "ПОМЕЩЕИЕ 73"));
        ExpertOrganization.appendChild(getOrgElementsValueFunc(doc, ExpertOrganization, "Address", "Room", "ПОМЕЩЕИЕ 73"));
        return ExpertOrganization;
    }

    private static Node getApprover(org.w3c.dom.Document doc) {
        Element Approver = doc.createElement("Approver");
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "FamilyName", "Арзамасцева"));
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "FirstName", "Надежда"));
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "SecondName", "Петровна"));
        Approver.appendChild(getOrgElementsValueTXT(doc, Approver, "Position", "Управляющий – Индивидуальный предприниматель"));
        return Approver;
    }


    private static Node getExaminationObject(org.w3c.dom.Document doc) {
        Element ExaminationObject = doc.createElement("ExaminationObject");
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationForm", "2"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationResult", "1"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationObjectType", "2"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationType", "2"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ConstructionType", "1"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "ExaminationStage", "3"));
        ExaminationObject.appendChild(getOrgElementsValueTXT(doc, ExaminationObject, "Name", "Жилая многоэтажная застройка квартала 4.15.1 в границах улиц Краснолесья – Рябинина – Очеретина в\n" +
                "            Академическом районе г. Екатеринбурга"));

        return ExaminationObject;
    }

    private static Node getDocuments(org.w3c.dom.Document doc) {
        Element Documents = doc.createElement("Documents");
        Documents.appendChild(getOrgElementsValueFunc_7(
                doc, Documents,
                "Document",
                "DocType",
                "DocName",
                "DocIssueAuthor",
                "File",
                "DocDate",
                "DocNumber",
                "01.01",
                "Заявление на заключение договора на экспертное сопровождение в отношении проектной документации\n" +
                        "                объекта капитального строительства",
                "43/261",
                "2022-04-01",
                "ООО «Специализированный застройщик «Лидер констракшн»",
                "FileName",
                "Заявление о заключении договора.pdf",
                "pdf",
                "eebbdb54",
                "SignFile",
                "FileName",
                "Заявление о заключении договора.pdf.sig",
                "FileFormat",
                "sig",
                "FileChecksum",
                "3718b4c5"
        ));
        return Documents;
    }

    private static Node getOrgElementsValueTXT(
            org.w3c.dom.Document doc,
            Element element,
            String name,
            String value
    ) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    private static Node getOrgElementsValueFunc(
            org.w3c.dom.Document doc,
            Element element,
            String name,
            String value,
            String content
    ) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createElement(value)).appendChild(doc.createTextNode(content));
        return node;
    }

    private static Node getOrgElementsValueFunc_7(
            org.w3c.dom.Document doc,
            Element element,
            String name,
            String DocType,
            String DocName,
            String DocIssueAuthor,
            String File,
            String DocDate,
            String DocNumber,
            String content_1,
            String content_2,
            String content_3,
            String content_4,
            String content_5,
            String el_1,
            String content_6,
            String content_7,
            String content_8,
            String SignFile,
            String FileName,
            String content_9,
            String FileFormat,
            String content_10,
            String FileChecksum,
            String content_11
    ) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createElement(DocType)).appendChild(doc.createTextNode(content_1));
        node.appendChild(doc.createElement(DocName)).appendChild(doc.createTextNode(content_2));
        node.appendChild(doc.createElement(DocNumber)).appendChild(doc.createTextNode(content_3));
        node.appendChild(doc.createElement(DocDate)).appendChild(doc.createTextNode(content_4));
        node.appendChild(doc.createElement(DocIssueAuthor)).appendChild(doc.createTextNode(content_5));
        node.appendChild(doc.createElement(File)).appendChild(doc.createElement(el_1)).appendChild(doc.createTextNode(content_6));
        node.getElementsByTagName("File").item(0).appendChild(doc.createElement(FileFormat)).appendChild(doc.createTextNode(content_7));
        node.getElementsByTagName("File").item(0).appendChild(doc.createElement(FileChecksum)).appendChild(doc.createTextNode(content_8));
        node.getElementsByTagName("File").item(0).appendChild(doc.createElement(SignFile)).appendChild(doc.createElement(FileName)).appendChild(doc.createTextNode(content_9));
        node.getElementsByTagName("SignFile").item(0).appendChild(doc.createElement(FileFormat)).appendChild(doc.createTextNode(content_10));
        node.getElementsByTagName("SignFile").item(0).appendChild(doc.createElement(FileChecksum)).appendChild(doc.createTextNode(content_11));
        return node;
    }

    // converter pdf
    @GetMapping("/read/PDF/{NameCompany}/{FileName}")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readPDFFile(
            @PathVariable("FileName") Integer IdFile,
            @PathVariable("NameCompany") String NameCompany
    ) {
        File file = new File(System.getProperty("user.home") + "/Downloads/uploads/" + NameCompany + "/pdf");
        if (!file.exists()) file.mkdir();
        String DEST = String.valueOf(get(System.getProperty("user.home") + "/Downloads/uploads" + "/" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name")));
        String DEST_PDF = String.valueOf(get(System.getProperty("user.home") + "/Downloads/uploads" + "/" + NameCompany + "/pdf/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name")));
        try (com.aspose.pdf.Document document = new com.aspose.pdf.Document()) {
            Page page = document.getPages().add();
            try (Parser parser = new Parser(DEST)) {
                if (!parser.getFeatures().isText()) {
                    System.out.println("The document doesn't support text extraction.");
                }

                IDocumentInfo documentInfo = parser.getDocumentInfo();

                if (documentInfo.getPageCount() == 0) {
                    System.out.println("The document has zero pages.");
                }

                ArrayList<List> arrayList = new ArrayList<>();

                for (int p = 0; p < documentInfo.getPageCount(); p++) {
                    com.spire.doc.Document document1 = new com.spire.doc.Document();
                    document1.loadFromFile(DEST);
                    String content = document1.getText();
                    page.getParagraphs().add(new TextFragment(content));
                    document.save(DEST_PDF + ".pdf");
                    arrayList.add(Collections.singletonList("Page number: " + (p + 1) + "/" + documentInfo.getPageCount()));
                    arrayList.add(Collections.singletonList(content));
                    System.out.println(arrayList);
                }

                return ResponseEntity.ok().body(arrayList);
            }
        }
    }

    // Define a method to download files
    @GetMapping("/download/{NameCompany}/{filename}")
    @SneakyThrows
    public ResponseEntity<Resource> downloadFiles(
            @PathVariable("filename") String filename,
            @PathVariable("NameCompany") String NameCompany
    ) {
        Path filePath = get(DIRECTORY + NameCompany).toAbsolutePath().normalize().resolve(filename);
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException(filename + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filename);
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders).body(resource);
    }

    @DeleteMapping("/delete/file/{NameCompany}/{NameFile}")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> deleteFile(
            @PathVariable("NameCompany") String NameCompany,
            @PathVariable("NameFile") Integer IdFile
    ) {
        Files.delete(Paths.get(System.getProperty("user.home") + "/Downloads/uploads" + "/" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name")));
        jdbcTemplate.update("delete from files where id_image=?", IdFile);
        return ResponseEntity.ok().body("Success delete file");
    }
}