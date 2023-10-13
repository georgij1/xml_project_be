package com.xml_project_be.xml_project.xml_file.type_file;

import com.xml_project_be.xml_project.xml_file.ResponseMessage;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;

public class TypeNotCorrect {
    Logger logger;

    @NotNull
    public static ResponseEntity<ResponseMessage> responseMessageResponseEntity(@RequestParam("file") MultipartFile file, Logger logger) {
        logger.info("type file is " + file.getContentType());
        logger.info("not correct this type of file");

        String message = "Тип изображения не валиден " + file.getContentType();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}