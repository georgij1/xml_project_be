package com.xml_project_be.xml_project.file.word_file;

import com.xml_project_be.xml_project.file.CreateJson.DomainBeanFile;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReadWordDocMethods {
    @NotNull
    static ResponseEntity<?> getResponseEntity(String NameCompany, JdbcTemplate jdbcTemplate, Integer FileName) {
        ArrayList<String> arrayListContentFile = new ArrayList<>();
        DomainBeanFile domainBeanNameFile = new DomainBeanFile();
        domainBeanNameFile.setNameFile(jdbcTemplate.queryForList("select file_name from files").get(0).get("file_name").toString());
        arrayListContentFile.add(String.valueOf((domainBeanNameFile.getNameFile())));

        try {
            String filePath = "/home/georgii/Загрузки/uploads/" + NameCompany + "/" + jdbcTemplate.queryForList("select file_name from files where id_file=?", FileName).get(0).get("file_name");
            FileInputStream fis = new FileInputStream(filePath);
            XWPFDocument document = new XWPFDocument(fis);

            // Чтение содержимого по строчно
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                arrayListContentFile.add(paragraph.getText());
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(arrayListContentFile);
    }
}