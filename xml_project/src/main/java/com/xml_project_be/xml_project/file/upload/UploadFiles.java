package com.xml_project_be.xml_project.file.upload;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.xml_project_be.xml_project.file.ControllerFile.DIRECTORY;
import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class UploadFiles {
    @SneakyThrows
    public static ResponseEntity<List<String>> uploadFilesDoc(
            List<MultipartFile> multipartFiles,
            String NameCompany,
            String Author,
            String TimeStamp,
            JdbcTemplate jdbcTemplate
    ) {
        List<String> filenames = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(select image_name from files where image_name=? and author=?)", Boolean.class, filename, Author))) {
                if (file.getOriginalFilename().contains("doc")) {
                    Path fileStorage = get("/home/georgii/Загрузки/uploads/" + NameCompany, filename).toAbsolutePath().normalize();
                    copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
                    filenames.add(filename);
                    jdbcTemplate.update(
                            "insert into files(image_name, time_stamp, author, name_company) values (?,?,?, ?)",
                            file.getOriginalFilename(),
                            TimeStamp,
                            Author,
                            NameCompany
                    );
                } else {
                    return ResponseEntity.ok().body(Collections.singletonList("NotCorrect type of file"));
                }
            }
        }
        return ResponseEntity.ok().body(filenames);
    }
}