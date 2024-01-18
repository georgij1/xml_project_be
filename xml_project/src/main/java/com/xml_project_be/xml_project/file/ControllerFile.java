package com.xml_project_be.xml_project.file;

import com.xml_project_be.xml_project.file.delete.Delete;
import com.xml_project_be.xml_project.file.download.DownloadAll;
import com.xml_project_be.xml_project.file.form.Form;
import com.xml_project_be.xml_project.file.list.ListFiles;
import com.xml_project_be.xml_project.file.pdf_file.ReadPdf;
import com.xml_project_be.xml_project.file.upload.UploadFiles;
import com.xml_project_be.xml_project.file.word_file.ReadWordDocx;
import com.xml_project_be.xml_project.file.xml_file.GenerateDocument;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class ControllerFile {
    JdbcTemplate jdbcTemplate;
    HttpServletResponse response;
    HttpServletRequest request;
    public static final String DIRECTORY = "/home/georgii/Загрузки/uploads/";

    @PostMapping("/upload")
    @SneakyThrows
    public ResponseEntity<List<String>> uploadFiles(
            @RequestParam("files") List<MultipartFile> multipartFiles,
            @RequestParam("NameCompany") String NameCompany,
            @RequestParam("Author") String Author,
            @RequestParam("TimeStamp") String TimeStamp,
            @RequestParam("TypeFile") String TypeFile
    ) {
        return UploadFiles.uploadFilesDoc(response, multipartFiles, NameCompany, Author, TimeStamp, TypeFile, jdbcTemplate);
    }

    @PostMapping("/list")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> list_files(@RequestBody Form NameCompany) {
        return ListFiles.listFiles(jdbcTemplate, NameCompany);
    }

    @GetMapping("/read/{NameCompany}/{FileName}")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readFile(
            @PathVariable("FileName") Integer FileID,
            @PathVariable("NameCompany") String NameCompany
    ) {
        return ReadWordDocx.readWordDocx(NameCompany, jdbcTemplate, FileID);
    }

    @GetMapping("/read/XML/{NameCompany}/{FileName}")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readXMLFile(
            @PathVariable("FileName") Integer IdFile,
            @PathVariable("NameCompany") String NameCompany
    ) {
        return GenerateDocument.generateDocument(IdFile, NameCompany, jdbcTemplate);
    }

    @GetMapping("/read/PDF/{NameCompany}/{FileName}")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readPDFFile(
            @PathVariable("FileName") Integer IdFile,
            @PathVariable("NameCompany") String NameCompany
    ) {
        return ReadPdf.readPdf(IdFile, NameCompany, jdbcTemplate);
    }

    @GetMapping("/download/{NameCompany}/{filename}")
    @SneakyThrows
    public ResponseEntity<?> downloadFiles(
            @PathVariable("filename") String filename,
            @PathVariable("NameCompany") String NameCompany
    ) {
        return DownloadAll.downloadAll(filename, NameCompany);
    }

    @DeleteMapping("/delete/file/{NameCompany}/{NameFile}")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> deleteFile(
            @PathVariable("NameCompany") String NameCompany,
            @PathVariable("NameFile") Integer IdFile
    ) {
        return Delete.delete(NameCompany, jdbcTemplate, IdFile);
    }

    @GetMapping("/xml/tables/{NameTable}/{NameCompany}/{NameFile}")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> getExpertOrganizationObject(
            @PathVariable("NameTable") String nameObjectXML,
            @PathVariable("NameCompany") String NameCompany,
            @PathVariable("NameFile") Integer IdFile
    ) {
        if (nameObjectXML.equals("ExpertOrganization")) {
            return GenerateDocument.getExpertOrganization_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("Approver")) {
            return GenerateDocument.getApprover_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("ExaminationObject")) {
            return GenerateDocument.getExpertOrganization_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("Documents")) {
            return GenerateDocument.getDocuments_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("PreviousConclusions")) {
            return GenerateDocument.getPreviousConclusions_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("PreviousSimpleConclusions")) {
            return GenerateDocument.getPreviousSimpleConclusions_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("Object")) {
            return GenerateDocument.getPreviousSimpleConclusions_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("Declarant")) {
            return GenerateDocument.getDeclarant_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("ProjectDocumentsDeveloper")) {
            return GenerateDocument.getProjectDocumentsDeveloper_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("Finance")) {
            return GenerateDocument.getFinance_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("ClimateConditions")) {
            return GenerateDocument.getClimateConditions_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("ClimateConditionsNote")) {
            return GenerateDocument.getClimateConditionsNote_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("ExpertProjectDocuments")) {
            return GenerateDocument.getExpertProjectDocuments_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("CadastralNumber")) {
            return GenerateDocument.getCadastralNumber_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("Experts")) {
            return GenerateDocument.getExperts_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("Designer")) {
            return GenerateDocument.getDesigner_object(IdFile, NameCompany, jdbcTemplate);
        }

        else if (nameObjectXML.equals("Summary")) {
            return GenerateDocument.getSummary_object(IdFile, NameCompany, jdbcTemplate);
        }

        else {
            return GenerateDocument.getNotFoundObject();
        }
    }
}