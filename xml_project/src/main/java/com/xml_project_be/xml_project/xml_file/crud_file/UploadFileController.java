package com.xml_project_be.xml_project.xml_file.crud_file;

import com.xml_project_be.xml_project.xml_file.FileStorageService;
import com.xml_project_be.xml_project.xml_file.ResponseMessage;
import com.xml_project_be.xml_project.xml_file.model.FileDB;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Objects;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import static com.xml_project_be.xml_project.xml_file.type_file.TypeCorrect.getResponseMessageResponseEntity;
import static com.xml_project_be.xml_project.xml_file.type_file.TypeNotCorrect.responseMessageResponseEntity;

@Controller
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/company/file")
public class UploadFileController {
    public FileStorageService storageService;
    @PostMapping("/upload")
    @ResponseBody
    @SneakyThrows
    @CrossOrigin("*")
    public ResponseEntity<ResponseMessage> UploadXMLFile (
        @RequestParam("file") MultipartFile file,
        FileDB formsGetTimeStamp
    ) {
        Logger logger = Logger.getLogger("");

        if (
            Objects.equals(file.getContentType(), "application/msword")
        ) {
            return getResponseMessageResponseEntity(file, formsGetTimeStamp, logger, storageService);
        }

        else {
            return responseMessageResponseEntity(file, logger);
        }
    }
}