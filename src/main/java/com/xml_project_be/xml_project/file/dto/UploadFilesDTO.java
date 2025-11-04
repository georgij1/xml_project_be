package com.xml_project_be.xml_project.file.dto;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UploadFilesDTO {
    @JsonProperty("listFiles")
    private List<MultipartFile> listFiles;
    @JsonProperty("nameCompany")
    private String nameCompany;
    @JsonProperty("author")
    private String author;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("typeFile")
    private String typeFile;
}