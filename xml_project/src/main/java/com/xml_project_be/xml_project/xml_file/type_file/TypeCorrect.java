package com.xml_project_be.xml_project.xml_file.type_file;

import com.xml_project_be.xml_project.xml_file.FileStorageService;
import com.xml_project_be.xml_project.xml_file.ResponseMessage;
import com.xml_project_be.xml_project.xml_file.model.FileDB;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.logging.Logger;

public class TypeCorrect {
    @NotNull
    public static ResponseEntity<ResponseMessage> getResponseMessageResponseEntity(@RequestParam("file") MultipartFile file, FileDB formsGetTimeStamp, Logger logger, FileStorageService storageService) throws IOException {
        String message;
        storageService.store (
                file,
//                formsGetTimeStamp.getSender_id(),
                formsGetTimeStamp.getName_company(),
                formsGetTimeStamp.getTime_stamp()
        );
        message = "Файл успешно загружен: " + file.getOriginalFilename();
        logger.info(message);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("message"));
    }
}