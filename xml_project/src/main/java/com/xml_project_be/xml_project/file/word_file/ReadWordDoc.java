package com.xml_project_be.xml_project.file.word_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.xml_project_be.xml_project.file.CreateJson.DomainBeanFile;
import lombok.SneakyThrows;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.ResponseEntity;

public class ReadWordDoc {
    @SneakyThrows
    public static ResponseEntity<?> readWordDoc(String NameCompany, JdbcTemplate jdbcTemplate, Integer FileName) {
        // Document doc = new Document("/home/georgii/Загрузки/uploads/" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", FileName).get(0).get("image_name"));
        ArrayList<String> arrayListContentFile = new ArrayList<>();
        DomainBeanFile domainBeanNameFile = new DomainBeanFile();
        domainBeanNameFile.setNameFile(jdbcTemplate.queryForList("select image_name from files").get(0).get("image_name").toString());

        arrayListContentFile.add(String.valueOf((domainBeanNameFile.getNameFile())));

        // for linux String filePath = "/home/georgii/Загрузки/uploads/" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", FileName).get(0).get("image_name");
        // for windows String filePath = "C:\\Users\\Panov\\Downloads\\uploads\\" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", FileName).get(0).get("image_name");
        try {
            String filePath = "/home/georgii/Загрузки/uploads/" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", FileName).get(0).get("image_name");
            FileInputStream fis = new FileInputStream(filePath);
            HWPFDocument document = new HWPFDocument(fis);
            Range range = document.getRange();
            arrayListContentFile.add(range.text());
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(arrayListContentFile);
    }
}