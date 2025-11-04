package com.xml_project_be.xml_project.file.list;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import com.xml_project_be.xml_project.file.dto.ListFilesDTO;

public class ListFiles {
    public static ResponseEntity<?> listFiles(
        JdbcTemplate jdbcTemplate, 
        ListFilesDTO listFilesDTO
    ) {
        String nameCompany = listFilesDTO.getNameCompany();

        var isExistsCompany = Boolean.TRUE.equals(
            jdbcTemplate.queryForObject(
                "select exists(select name_company from files where name_company=?)", 
                Boolean.class, 
                nameCompany
            )
        );

        return new ResponseEntity<>(
            isExistsCompany ?
                jdbcTemplate.queryForList(
                    "select * from files where name_company=?", 
                    nameCompany
                )
            :
                "", 
            isExistsCompany ?
                HttpStatus.OK
            :
                HttpStatus.NOT_FOUND
        );
    }
}