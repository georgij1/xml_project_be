package com.xml_project_be.xml_project.file.word_file;

import com.xml_project_be.xml_project.file.CreateJson.DomainBeanFile;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReadWordDocx {
    public static ResponseEntity<?> readWordDocx(
        String NameCompany,
        JdbcTemplate jdbcTemplate,
        Integer IDFile
    ) {
        // TODO: Решить проблему с parse'ingom (он парсит только половину файла)
        ArrayList<String> arrayListContentFile = new ArrayList<>();
        DomainBeanFile domainBeanNameFile = new DomainBeanFile();
        domainBeanNameFile.setNameFile(jdbcTemplate.queryForList("select file_name from files").get(0).get("file_name").toString());
        arrayListContentFile.add(String.valueOf((domainBeanNameFile.getNameFile())));

        String filePath = "/home/georgii/Загрузки/uploads/" + NameCompany + "/" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IDFile).get(0).get("file_name");
        try (FileInputStream fis = new FileInputStream(filePath)) {
            XWPFDocument document = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            arrayListContentFile.add(extractor.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(arrayListContentFile);
    }
}