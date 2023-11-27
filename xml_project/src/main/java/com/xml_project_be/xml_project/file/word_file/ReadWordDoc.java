package com.xml_project_be.xml_project.file.word_file;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.ResponseEntity;
import static com.xml_project_be.xml_project.file.word_file.ReadWordDocMethods.getResponseEntity;

public class ReadWordDoc {
    @SneakyThrows
    public static ResponseEntity<?> readWordDoc(String NameCompany, JdbcTemplate jdbcTemplate, Integer FileName) {
        return getResponseEntity(NameCompany, jdbcTemplate, FileName);
    }
}