package com.xml_project_be.xml_project.file.upload;

import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.xml_project_be.xml_project.file.dto.UploadFilesDTO;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class UploadFiles {
    @SneakyThrows
    public static ResponseEntity<?> uploadFilesDoc(
        UploadFilesDTO uploadFiles,
        JdbcTemplate jdbcTemplate
    ) {
        List<String> filenames = new ArrayList<>();
        var multipartFiles = uploadFiles.getListFiles();
        var nameCompany = uploadFiles.getNameCompany();
        var authorFile = uploadFiles.getAuthor();
        var timeStamp = uploadFiles.getTimeStamp();
        var typeFile = uploadFiles.getTypeFile();

        for (MultipartFile file : multipartFiles) {
            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

            var isExsistFile = Boolean.FALSE.equals(
                jdbcTemplate.queryForObject("select exists(select file_name from files where file_name=? and author=?)", 
                    Boolean.class, 
                    filename, 
                    authorFile
                )
            );

            if (isExsistFile) {
                if (file.getOriginalFilename().contains("doc")) {
                    Path fileStorage = get("/home/georgii/Загрузки/uploads/" + nameCompany, filename).toAbsolutePath().normalize();
                    
                    copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
                    
                    filenames.add(filename);

                    jdbcTemplate.update(
                        "insert into files(file_name, " +
                        "time_stamp, author, name_company, " +
                        "type_file) " +
                        "values (?, ?, ?, ?, ?)",
                        file.getOriginalFilename(),
                        timeStamp,
                        authorFile,
                        nameCompany,
                        typeFile
                    );
                }
                
                else {
                    return new ResponseEntity<>("Не верный тип файла", HttpStatus.BAD_REQUEST);
                }
            }

            else {
                return new ResponseEntity<>("Такой файл уже существует", HttpStatus.BAD_REQUEST);
            }
        }
        
        return new ResponseEntity<>(filenames, HttpStatus.OK);
    }
}