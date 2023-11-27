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

import static com.xml_project_be.xml_project.file.word_file.ReadWordDocx.getResponseEntity;

public class ReadWordDoc {
    @SneakyThrows
    public static ResponseEntity<?> readWordDoc(String NameCompany, JdbcTemplate jdbcTemplate, Integer FileName) {
        return getResponseEntity(NameCompany, jdbcTemplate, FileName);
    }
}