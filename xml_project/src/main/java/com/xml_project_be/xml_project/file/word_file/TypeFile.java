package com.xml_project_be.xml_project.file.word_file;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

public class TypeFile {
    public static ResponseEntity<?> choose_type(
            Integer IDFile,
            JdbcTemplate jdbcTemplate
    ) {
        jdbcTemplate.queryForList("select * from files where id_file=?", IDFile).get(0).get("");
        return null;
    }
}