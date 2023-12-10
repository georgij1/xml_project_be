package com.xml_project_be.xml_project.file.word_file;

import com.spire.doc.Document;
import com.spire.doc.collections.ParagraphCollection;
import com.xml_project_be.xml_project.file.CreateJson.DomainBeanFile;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadWordDocx {
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

            try {
                // Check if the document has sections and paragraphs
                if (document.getSections().getCount() > 0 && document.getSections().get(0).getParagraphs().getCount() > 0) {
                    // Get the first paragraph
                    ParagraphCollection firstParagraph = document.getSections().get(0).getParagraphs();
                    String OrgFullName = firstParagraph.getDocument().getText();
                    arrayListContentFile.add(Arrays.toString(OrgFullName.split(" ")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.ok().body(arrayListContentFile);
    }
}