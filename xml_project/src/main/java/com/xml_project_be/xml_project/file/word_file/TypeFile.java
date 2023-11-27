package com.xml_project_be.xml_project.file.word_file;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

public class TypeFile {
    public static ResponseEntity<?> choose_type(
            Integer IDFile,
            String NameCompany,
            JdbcTemplate jdbcTemplate
    ) {
        if (jdbcTemplate.queryForList("select * from files where id_file=?", IDFile).get(0).get("TypeFile").equals("application/msword")) {
            ReadWordDocx.readWordDocx(NameCompany, jdbcTemplate, IDFile);
        }

        else if (jdbcTemplate.queryForList("select * from files where id_file=?", IDFile).get(0).get("TypeFile").equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
            ReadWordDoc.readWordDoc(NameCompany, jdbcTemplate, IDFile);
        }

        return ResponseEntity.ok().body("Такой тип не возможно отобразить");
    }
}