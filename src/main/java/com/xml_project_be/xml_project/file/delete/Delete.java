package com.xml_project_be.xml_project.file.delete;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xml_project_be.xml_project.file.dto.ReadFileDTO;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Delete {
    @SneakyThrows
    public static ResponseEntity<?> delete(
        ReadFileDTO readFileDTO,
        JdbcTemplate jdbcTemplate
    ) {
        var nameCompany = readFileDTO.getNameCompany();
        var fileId = readFileDTO.getFileID();
        var getFileName = jdbcTemplate.queryForList("select file_name from files where id_file=?", fileId).get(0).get("file_name");

        Files.delete(Paths.get("/home/georgii/Загрузки/uploads/" + nameCompany + "/" + getFileName));

        jdbcTemplate.update("delete from files where id_file=?", fileId);
        
        return ResponseEntity.ok().body("Success delete file");
    }
}