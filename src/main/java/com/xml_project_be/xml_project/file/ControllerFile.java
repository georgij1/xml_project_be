package com.xml_project_be.xml_project.file;

import com.xml_project_be.xml_project.file.delete.Delete;
import com.xml_project_be.xml_project.file.download.DownloadAll;
import com.xml_project_be.xml_project.file.dto.GetTableDTO;
import com.xml_project_be.xml_project.file.dto.ListFilesDTO;
import com.xml_project_be.xml_project.file.dto.ReadFileDTO;
import com.xml_project_be.xml_project.file.dto.ReadFileSplitWordDTO;
import com.xml_project_be.xml_project.file.dto.UploadFilesDTO;
import com.xml_project_be.xml_project.file.list.ListFiles;
import com.xml_project_be.xml_project.file.pdf_file.ReadPdf;
import com.xml_project_be.xml_project.file.upload.UploadFiles;
import com.xml_project_be.xml_project.file.word_file.ReadWordDocx;
import com.xml_project_be.xml_project.file.xml_file.reader.GenerateDocument;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class ControllerFile {
    JdbcTemplate jdbcTemplate;

    @PostMapping("/upload")
    @SneakyThrows
    public ResponseEntity<?> uploadFiles(
        @RequestBody UploadFilesDTO uploadFiles
    ) {
        return UploadFiles.uploadFilesDoc(
            uploadFiles, 
            jdbcTemplate
        );
    }

    @PostMapping("/list")
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> listFiles(
        @RequestBody ListFilesDTO listFilesDTO
    ) {
        return ListFiles.listFiles(
            jdbcTemplate, 
            listFilesDTO
        );
    }

    @GetMapping("/read")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readFile(
        @RequestBody ReadFileDTO readFileDTO
    ) {
        return ReadWordDocx.readWordDocx(
            readFileDTO,
            jdbcTemplate
        );
    }

    @GetMapping("/read/split_words")
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> readFileSplitWord(
        @RequestBody ReadFileSplitWordDTO readFileSplitWordDTO
    ) {
        return ReadWordDocx.readWordDocxSplitWords(
            readFileSplitWordDTO, 
            jdbcTemplate
        );
    }

    @GetMapping("/read/XML")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readXMLFile(
        @RequestBody ReadFileDTO readFileDTO
    ) {
        return GenerateDocument.generateDocument(
            readFileDTO,
            jdbcTemplate
        );
    }

    @GetMapping("/read/PDF")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readPDFFile(
        @RequestBody ReadFileDTO readFileDTO
    ) {
        return ReadPdf.readPdf(
            readFileDTO, 
            jdbcTemplate
        );
    }

    @GetMapping("/download/all")
    @SneakyThrows
    public ResponseEntity<?> downloadFiles(
        @RequestBody ReadFileDTO readFileDTO
    ) {
        return DownloadAll.downloadAll(readFileDTO);
    }

    @DeleteMapping("/delete/file/{NameCompany}/{NameFile}")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> deleteFile(
        @RequestBody ReadFileDTO readFileDTO
    ) {
        return Delete.delete(
            readFileDTO,
            jdbcTemplate
        );
    }

    @GetMapping("/xml/tables/{NameTable}/{NameCompany}/{NameFile}")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> getTable(
        @RequestBody GetTableDTO getTableDTO
    ) {
        return GenerateDocument.getNotFoundObject();
    }
}