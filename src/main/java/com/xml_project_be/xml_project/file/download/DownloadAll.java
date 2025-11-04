package com.xml_project_be.xml_project.file.download;

import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.xml_project_be.xml_project.file.dto.ReadFileDTO;

import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadAll {
    private static String path = System.getProperty("user.home") + File.separator + "xmlApp" + File.separator + "uploads";

    @SneakyThrows
    public static ResponseEntity<Resource> downloadAll(
        ReadFileDTO readFileDTO
    ) {
        var companyName = readFileDTO.getNameCompany();
        var fileId = readFileDTO.getFileID();

        Path companyDir = Paths.get(
            path, 
            companyName
        )
            .toAbsolutePath()
            .normalize();
        
        Path filePath = companyDir.resolve(fileId.toString()).normalize();
        
        if (
            !filePath.startsWith(companyDir)
        ) {
            return ResponseEntity.badRequest().build();
        }
        
        if (
            !Files.exists(filePath) 
            || 
            !Files.isRegularFile(filePath)
        ) {
            return ResponseEntity.notFound().build();
        }
        
        Resource resource = new UrlResource(filePath.toUri());
        
        if (
            !resource.exists() 
            || 
            !resource.isReadable()
        ) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        
        String contentType = Files.probeContentType(
            filePath
        );
        String encodedFilename = URLEncoder.encode(
            fileId.toString(), 
            StandardCharsets.UTF_8
        ).replaceAll("\\+", "%20");
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("File-Name", fileId.toString());
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFilename + "\"");
        
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(
                contentType != null ? contentType : "application/octet-stream"
            ))
            .headers(headers)
            .body(resource);
    }
}