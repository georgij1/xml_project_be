package com.xml_project_be.xml_project.file.word_file;

import com.spire.doc.Document;
import com.spire.doc.collections.ParagraphCollection;
import com.xml_project_be.xml_project.file.CreateJson.DomainBeanFile;
import lombok.SneakyThrows;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadWordDocx {
    @SneakyThrows
    public static ResponseEntity<?> readWordDocx(
        String NameCompany,
        JdbcTemplate jdbcTemplate,
        Integer IDFile
    ) {
        ArrayList<String> arrayListContentFile = new ArrayList<>();
        DomainBeanFile domainBeanNameFile = new DomainBeanFile();
        domainBeanNameFile.setNameFile(jdbcTemplate.queryForList("select file_name from files where id_file=?", IDFile).get(0).get("file_name").toString());
        arrayListContentFile.add(String.valueOf((domainBeanNameFile.getNameFile())));

        String filePath = "/home/georgii/Загрузки/uploads/" + NameCompany + "/" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IDFile).get(0).get("file_name");
        File file = new File(filePath);
        Document document = new Document();
        document.loadFromFile(filePath);
        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            arrayListContentFile.add("File not found: " + filePath);
        } else {
            System.out.println(filePath);

            try (XWPFDocument doc = new XWPFDocument(
                Files.newInputStream(Paths.get(filePath)))
            ) {
                List<XWPFParagraph> list = doc.getParagraphs();
                for (XWPFParagraph paragraph : list) {
                    System.out.println(paragraph.getText());
                    arrayListContentFile.add(paragraph.getText());
                }
            }
        }
        return ResponseEntity.ok().body(arrayListContentFile);
    }
}