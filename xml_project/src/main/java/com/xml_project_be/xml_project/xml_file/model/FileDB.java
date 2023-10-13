package com.xml_project_be.xml_project.xml_file.model;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.sql.Blob;

@Entity
@NoArgsConstructor(force=true)
@Table(name="files")
@Data
@RequiredArgsConstructor
public class FileDB {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NonNull
    public String id_image;
    @NonNull
    private String image_name;
    @NonNull
    private String type;
    @Lob
    private byte[] data;
    @NonNull
    public String time_stamp;
    @NonNull
    public Integer sender_id;
    @NonNull
    public String name_company;

    public FileDB (
        @NotNull String name,
        @NotNull String type,
//        @NotNull Integer UserSender,
        @NotNull String NameCompany,
        @NonNull String TimeStamp,
        byte[] data
    ) {
        this.image_name = name;
        this.type = type;
//        this.sender_id = UserSender;
        this.name_company = NameCompany;
        this.time_stamp = TimeStamp;
        this.data = data;
    }
}