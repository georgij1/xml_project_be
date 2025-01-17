package com.xml_project_be.xml_project.file;

import com.xml_project_be.xml_project.file.delete.Delete;
import com.xml_project_be.xml_project.file.download.DownloadAll;
import com.xml_project_be.xml_project.file.form.Form;
import com.xml_project_be.xml_project.file.list.ListFiles;
import com.xml_project_be.xml_project.file.pdf_file.ReadPdf;
import com.xml_project_be.xml_project.file.upload.UploadFiles;
import com.xml_project_be.xml_project.file.word_file.ReadWordDocx;
import com.xml_project_be.xml_project.file.xml_file.editor.BodyCreateFields;
import com.xml_project_be.xml_project.file.xml_file.editor.BodyGetEditedFields;
import com.xml_project_be.xml_project.file.xml_file.editor.CreateRow;
import com.xml_project_be.xml_project.file.xml_file.editor.EditDocument;
import com.xml_project_be.xml_project.file.xml_file.reader.GenerateDocument;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Example API", tags = "Пример API")
@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class ControllerFile {
    JdbcTemplate jdbcTemplate;
    HttpServletResponse response;
    HttpServletRequest request;
    public static final String DIRECTORY = "C:\\Users\\Panov\\Downloads\\uploads\\";

    // Контроллер для загрузки файла
    @ApiOperation(value = "Получить пример", notes = "Возвращает пример сообщения")
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

    // Получение списка файлов
    @PostMapping("/list")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> list_files(@RequestBody Form NameCompany) {
        return ListFiles.listFiles(jdbcTemplate, NameCompany);
    }

    // Чтение файла word с форматом docx
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

    // Чтение файла word с форматом docx по каждому слову
    @GetMapping("/read/split_words/{NameCompany}/{FileName}")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readFileSplitWord(
            @PathVariable("FileName") Integer FileID,
            @PathVariable("NameCompany") String NameCompany
    ) {
        return ReadWordDocx.readWordDocxSplitWords(NameCompany, jdbcTemplate, FileID);
    }

    // Чтение файла word с форматом docx по каждому слову
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

    // Чтение файла pdf
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

    // Контроллер для скачивания файла
    @GetMapping("/download/{NameCompany}/{filename}")
    @SneakyThrows
    public ResponseEntity<?> downloadFiles(
            @PathVariable("filename") String filename,
            @PathVariable("NameCompany") String NameCompany
    ) {
        return DownloadAll.downloadAll(filename, NameCompany);
    }

    // Удаление одного файла
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

    // Получение контента каждого объекта
    @GetMapping("/xml/tables/{NameTable}/{NameCompany}/{NameFile}")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> getTable(
            @PathVariable("NameTable") String nameObjectXML,
            @PathVariable("NameCompany") String NameCompany,
            @PathVariable("NameFile") Integer IdFile
    ) {
        // if (nameObjectXML.equals("ExpertOrganization")) {
        //     return GenerateDocument.getExpertOrganization_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("Approver")) {
        //     return GenerateDocument.getApprover_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("ExaminationObject")) {
        //     return GenerateDocument.getExaminationObject_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("Documents")) {
        //     return GenerateDocument.getDocuments_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("PreviousConclusions")) {
        //     return GenerateDocument.getPreviousConclusions_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("PreviousSimpleConclusions")) {
        //     return GenerateDocument.getPreviousSimpleConclusions_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("Object")) {
        //     return GenerateDocument.getObject_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("Declarant")) {
        //     return GenerateDocument.getDeclarant_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("ProjectDocumentsDeveloper")) {
        //     return GenerateDocument.getProjectDocumentsDeveloper_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("Finance")) {
        //     return GenerateDocument.getFinance_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("ClimateConditions")) {
        //     return GenerateDocument.getClimateConditions_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("ClimateConditionsNote")) {
        //     return GenerateDocument.getClimateConditionsNote_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("ExpertProjectDocuments")) {
        //     return GenerateDocument.getExpertProjectDocuments_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("CadastralNumber")) {
        //     return GenerateDocument.getCadastralNumber_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("Experts")) {
        //     return GenerateDocument.getExperts_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("Designer")) {
        //     return GenerateDocument.getDesigner_object(IdFile, NameCompany, jdbcTemplate);
        // } else if (nameObjectXML.equals("Summary")) {
        //     return GenerateDocument.getSummary_object(IdFile, NameCompany, jdbcTemplate);
        // } else {
        //     return GenerateDocument.getNotFoundObject();
        // }
        return ResponseEntity.ok("");
    }

    // Контроллер для редактирования таблиц
    @PostMapping("/xml/tables/edit")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> editTable(@RequestBody BodyGetEditedFields bodyGetEditedFields) {
        // if (bodyGetEditedFields.getTable_name().equals("ExpertOrganization")) {
        //     return EditDocument.setExpertOrganization_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("Approver")) {
        //     return EditDocument.getApprover_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("ExaminationObject")) {
        //     return EditDocument.getExaminationObject_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("Documents")) {
        //     return EditDocument.getDocuments_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("PreviousConclusions")) {
        //     return EditDocument.getPreviousConclusions_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("PreviousSimpleConclusions")) {
        //     return EditDocument.getPreviousSimpleConclusions_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("Object")) {
        //     return EditDocument.getObject_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("Declarant")) {
        //     return EditDocument.getDeclarant_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("ProjectDocumentsDeveloper")) {
        //     return EditDocument.getProjectDocumentsDeveloper_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("Finance")) {
        //     return EditDocument.getFinance_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("ClimateConditions")) {
        //     return EditDocument.getClimateConditions_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("ClimateConditionsNote")) {
        //     return EditDocument.getClimateConditionsNote_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("ExpertProjectDocuments")) {
        //     return EditDocument.getExpertProjectDocuments_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("CadastralNumber")) {
        //     return EditDocument.getCadastralNumber_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("Experts")) {
        //     return EditDocument.getExperts_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("Designer")) {
        //     return EditDocument.getDesigner_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else if (bodyGetEditedFields.getTable_name().equals("Summary")) {
        //     return EditDocument.getSummary_object(
        //             jdbcTemplate,
        //             bodyGetEditedFields.getColumn_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getId_file()
        //     );
        // } else {
        //     return EditDocument.getNotFoundObject(
        //             bodyGetEditedFields.getId_file(),
        //             bodyGetEditedFields.getCompany_name(),
        //             bodyGetEditedFields.getColumn_value(),
        //             bodyGetEditedFields.getId_transaction(),
        //             bodyGetEditedFields.getTable_name()
        //     );
        // }
        return ResponseEntity.ok("");
    }

    // Контроллер для создания rows в таблице (не пустых)
    @PostMapping("/xml/tables/create/row")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> createTableRow(
            @RequestBody CreateRow createRow
    ) {
        // return EditDocument.getCreateRow(
        //     jdbcTemplate,
        //     createRow.getOrgFullName().toString(),
        //     createRow.getValue().toString(),
        //     createRow.getTableName(),
        //     createRow.getNameCompany(),
        //     createRow.getId_file()
        // );
        return EditDocument.getCreateRow(
            jdbcTemplate,
            "",
            "",
            "",
            "",
            0
        );
    }
}