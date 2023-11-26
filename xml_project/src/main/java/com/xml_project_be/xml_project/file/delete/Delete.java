package com.xml_project_be.xml_project.file.delete;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Delete {
    @SneakyThrows
    public static ResponseEntity<?> delete(String NameCompany, JdbcTemplate jdbcTemplate, Integer IdFile) {
        Files.delete(Paths.get("/home/georgii/Загрузки/uploads/" + NameCompany + "/" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("image_name")));
        jdbcTemplate.update("delete from files where id_file=?", IdFile);
        return ResponseEntity.ok().body("Success delete file");
    }
}