package com.xml_project_be.xml_project.file.delete;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Delete {
    public static ResponseEntity<?> delete(String NameCompany, JdbcTemplate jdbcTemplate, Integer IdFile) throws IOException {
        Files.delete(Paths.get("/home/georgii/Загрузки/uploads/" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name")));
        jdbcTemplate.update("delete from files where id_image=?", IdFile);
        return ResponseEntity.ok().body("Success delete file");
    }
}