package com.xml_project_be.xml_project.xml_file.crud_file;

import com.xml_project_be.xml_project.aop.CheckHeader;
import com.xml_project_be.xml_project.xml_file.forms.GetAllFiles;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@Controller
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/company/files")
public class GetAllFileController {
    JdbcTemplate jdbcTemplate;
    @PostMapping("/list/get")
    @ResponseBody
    @SneakyThrows
    @CrossOrigin("*")
    @CheckHeader
    public ResponseEntity<?> UploadXMLFile (
        @RequestBody GetAllFiles getAllFiles
    ) {
        Logger logger = Logger.getLogger("");
        logger.info(getAllFiles.getNameCompany());
        return ResponseEntity.ok(
            jdbcTemplate.queryForList("select * from files where name_company=?",
            getAllFiles.getNameCompany())
        );
    }
}