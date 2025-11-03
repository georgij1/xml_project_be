package com.xml_project_be.xml_project.file.download;

import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.io.File;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadAll {
    private static final String DIRECTORY = System.getProperty("user.home") + File.separator + "xmlApp" + File.separator + "uploads";

    @SneakyThrows
    public static ResponseEntity<Resource> downloadAll(
        String filename, 
        String companyName
    ) {
        Path companyDir = Paths.get(
            DIRECTORY, 
            companyName
        ).toAbsolutePath().normalize();
        
        Path filePath = companyDir.resolve(filename).normalize();
        
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
            filename, 
            StandardCharsets.UTF_8
        ).replaceAll("\\+", "%20");
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("File-Name", filename);
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFilename + "\"");
        
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(
                contentType != null ? contentType : "application/octet-stream"
            ))
            .headers(headers)
            .body(resource);
    }
}