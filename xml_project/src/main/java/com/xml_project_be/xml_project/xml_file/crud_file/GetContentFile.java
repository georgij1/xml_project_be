package com.xml_project_be.xml_project.xml_file.crud_file;

import com.xml_project_be.xml_project.aop.CheckHeader;
import com.xml_project_be.xml_project.xml_file.FileStorageService;
import com.xml_project_be.xml_project.xml_file.model.FileDB;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@Controller
@CrossOrigin("*")
@RequestMapping("api/company/file")
@Data
public class GetContentFile {
    Logger logger = Logger.getLogger("");
    private final FileStorageService storageService;

    @PostMapping("/read")
    @ResponseBody
    @SneakyThrows
    @CrossOrigin("*")
    @CheckHeader
    public ResponseEntity<?> UploadXMLFile (
        @RequestBody com.xml_project_be.xml_project.xml_file.forms.GetContentFile getContentFile
    ) {
        FileDB fileDB = storageService.getFile(getContentFile.getNameFileUnique());

        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, "application/msword; filename=\"" + fileDB.getImage_name() + "\"")
            .body(fileDB.getData());
    }
}