package com.xml_project_be.xml_project.file;

import com.xml_project_be.xml_project.file.delete.Delete;
import com.xml_project_be.xml_project.file.download.DownloadAll;
import com.xml_project_be.xml_project.file.form.Form;
import com.xml_project_be.xml_project.file.list.ListFiles;
import com.xml_project_be.xml_project.file.pdf_file.ReadPdf;
import com.xml_project_be.xml_project.file.upload.UploadFiles;
import com.xml_project_be.xml_project.file.word_file.ReadWord;
import com.xml_project_be.xml_project.file.xml_file.GenerateDocument;
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
    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

    @PostMapping("/upload")
    @SneakyThrows
    public ResponseEntity<List<String>> uploadFiles(
            @RequestParam("files") List<MultipartFile> multipartFiles,
            @RequestParam("NameCompany") String NameCompany,
            @RequestParam("Author") String Author,
            @RequestParam("TimeStamp") String TimeStamp
    ) {
        return UploadFiles.uploadFilesDoc(multipartFiles, NameCompany, Author, TimeStamp, jdbcTemplate);
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
            @PathVariable("FileName") Integer FileName,
            @PathVariable("NameCompany") String NameCompany
    ) {
        return ReadWord.readWord(NameCompany, jdbcTemplate, FileName);
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
}