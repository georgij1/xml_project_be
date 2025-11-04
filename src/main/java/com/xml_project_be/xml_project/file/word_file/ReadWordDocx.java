package com.xml_project_be.xml_project.file.word_file;

import com.spire.doc.Document;
import com.xml_project_be.xml_project.file.dto.ReadFileDTO;
import com.xml_project_be.xml_project.file.dto.ReadFileSplitWordDTO;
import lombok.SneakyThrows;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadWordDocx {
    @SneakyThrows
    public static ResponseEntity<?> readWordDocx(
        ReadFileDTO readFileDTO,
        JdbcTemplate jdbcTemplate
    ) {
        ArrayList<String> arrayListContentFile = new ArrayList<>();
        var fileId = readFileDTO.getFileID();
        var nameCompany = readFileDTO.getNameCompany();
        
        var getFileName = jdbcTemplate.queryForList(
            "select file_name from files where id_file=?", 
            fileId
        )
        .get(0)
        .get("file_name");
        
        String basePath = System.getProperty("user.home");
        String filePath = Paths.get(basePath, "Downloads", "uploads", nameCompany, getFileName.toString()).toString();
        
        arrayListContentFile.add(getFileName.toString());
        
        File file = new File(filePath);
        
        Document document = new Document();
        document.loadFromFile(filePath);
        
        XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(filePath)));

        List<XWPFParagraph> list = doc.getParagraphs();

        for (XWPFParagraph paragraph : list) {
            arrayListContentFile.add(paragraph.getText());
        }

        doc.close();
        
        return new ResponseEntity<>(
            !file.exists() ?
            "File not found: " + filePath
            :
            arrayListContentFile, 
            !file.exists() ?
            HttpStatus.NOT_FOUND
            :
            HttpStatus.OK
        );
    }

    @SneakyThrows
    public static ResponseEntity<?> readWordDocxSplitWords(
        ReadFileSplitWordDTO readFileSplitWordDTO,
        JdbcTemplate jdbcTemplate
    ) {
        ArrayList<String[]> arrayListContentFile = new ArrayList<>();
        var nameCompany = readFileSplitWordDTO.getNameCompany();
        var fileId = readFileSplitWordDTO.getFileID();
        var getFileName = jdbcTemplate.queryForList(
            "select file_name from files where id_file=?", 
            fileId
        )
        .get(0)
        .get("file_name");
        
        String basePath = System.getProperty("user.home");
        String filePath = Paths.get(basePath, "Downloads", "uploads", nameCompany, getFileName.toString()).toString();
        
        File file = new File(filePath);
        Document document = new Document();
        document.loadFromFile(filePath);
        
        XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(filePath)));

        List<XWPFParagraph> list = doc.getParagraphs();
        
        for (XWPFParagraph paragraph : list) {
            System.out.println(Arrays.toString(paragraph.getText().split(" ")));
            arrayListContentFile.add(paragraph.getText().split(" "));
        }

        doc.close();
        
        return new ResponseEntity<>(
            !file.exists() 
            ? 
            "File not found: " + filePath 
            : 
            arrayListContentFile, 
            !file.exists()
            ?
            HttpStatus.NOT_FOUND
            :
            HttpStatus.OK
        );
    }
}