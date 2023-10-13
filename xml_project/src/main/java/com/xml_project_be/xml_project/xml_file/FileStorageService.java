package com.xml_project_be.xml_project.xml_file;

import com.xml_project_be.xml_project.xml_file.model.FileDB;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class FileStorageService {
    private FileDBRepository fileDBRepository;

    public FileDB store (
        MultipartFile file,
//        @NotNull Integer UserSender,
        @NonNull String NameCompany,
        @NonNull String time_stamp
    ) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileDB FileDB = new FileDB (
            fileName,
            Objects.requireNonNull(file.getContentType()),
//            UserSender,
            NameCompany,
            time_stamp,
            file.getBytes()
        );
        return fileDBRepository.save(FileDB);
    }

    public FileDB getFile(String IdImage) {
        System.out.println(fileDBRepository.findById(IdImage).get());
        if (fileDBRepository.findById(IdImage).isPresent()) {
            return fileDBRepository.findById(IdImage).get();
        }

        else {
            return null;
        }
    }
}