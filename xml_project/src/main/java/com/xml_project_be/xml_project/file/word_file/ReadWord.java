package com.xml_project_be.xml_project.file.word_file;

import com.aspose.words.Document;
import com.aspose.words.NodeType;
import com.aspose.words.Paragraph;
import com.aspose.words.SaveFormat;
import com.xml_project_be.xml_project.file.CreateJson.DomainBeanFile;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class ReadWord {
    @SneakyThrows
    public static ResponseEntity<?> readWord(String NameCompany, JdbcTemplate jdbcTemplate, Integer FileName) {
        Document doc = new Document(System.getProperty("user.home") + "\\Downloads\\uploads\\" + NameCompany + "\\" + jdbcTemplate.queryForList("select image_name from files where id_image=?", FileName).get(0).get("image_name"));
        ArrayList<String> arrayListContentFile = new ArrayList<>();
        DomainBeanFile domainBeanNameFile = new DomainBeanFile();
        domainBeanNameFile.setNameFile(jdbcTemplate.queryForList("select image_name from files").get(0).get("image_name").toString());

        arrayListContentFile.add(String.valueOf((domainBeanNameFile.getNameFile())));

        for (Object obj : doc.getChildNodes(NodeType.PARAGRAPH, true)) {
            Paragraph para = (Paragraph) obj;
            arrayListContentFile.add(para.toString(SaveFormat.TEXT));
        }

        return ResponseEntity.ok().body(arrayListContentFile);
    }
}