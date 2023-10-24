package com.xml_project_be.xml_project.xml_file;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import static java.nio.file.Files.copy;
import com.aspose.words.Document;
import com.aspose.words.Font;
import com.aspose.words.License;
import com.aspose.words.NodeType;
import com.aspose.words.Paragraph;
import com.aspose.words.Run;
import com.aspose.words.SaveFormat;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class ControllerFile {
    JdbcTemplate jdbcTemplate;
    // define a location
    public static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/uploads/";

    // Define a method to upload files
    @PostMapping("/upload")
    public ResponseEntity<List<String>> uploadFiles (
        @RequestParam("files") List <MultipartFile> multipartFiles,
        @RequestParam("NameCompany") String NameCompany,
        @RequestParam("Author") String Author,
        @RequestParam("TimeStamp") String TimeStamp
    ) throws IOException {
        List<String> filenames = new ArrayList<>();
        for (MultipartFile file : multipartFiles) {
            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            if (Boolean.FALSE.equals(jdbcTemplate.queryForObject("select exists(select image_name from files where image_name=? and author=?)", Boolean.class, filename, Author))) {
                if (file.getOriginalFilename().contains(String.valueOf("doc"))) {
                    Path fileStorage = get(DIRECTORY+NameCompany, filename).toAbsolutePath().normalize();
                    copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
                    filenames.add(filename);
                    jdbcTemplate.update(
                            "insert into files(image_name, time_stamp, author, name_company) values (?,?,?, ?)",
                            file.getOriginalFilename(),
                            TimeStamp,
                            Author,
                            NameCompany
                    );
                }

                else {
                    return ResponseEntity.ok().body(Collections.singletonList("NotCorrect type of file"));
                }
            }
        }
        return ResponseEntity.ok().body(filenames);
    }

    @PostMapping("/list")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> list_files(
        @RequestBody Form NameCompany
    ) {
        if (Boolean.TRUE.equals(jdbcTemplate.queryForObject("select exists(select name_company from files where name_company=?)", Boolean.class, NameCompany.getNameCompany()))) {
            File f = new File(System.getProperty("user.home")+"/Downloads/uploads/"+NameCompany.getNameCompany());
            File[] files = f.listFiles();
            ArrayList<String> NameFiles = new ArrayList<>();
            for (File file_1 : Objects.requireNonNull(files)) {
                NameFiles.add(file_1.getName());
            }
            return ResponseEntity.ok().body(
                jdbcTemplate.queryForList("select * from files where name_company=?", NameCompany.getNameCompany())
            );
        }

        else {
            ArrayList<DomainBean> arr = new ArrayList<>();
            DomainBean domainBean = new DomainBean();
            domainBean.setId_image("1");
            domainBean.setImage_name("Not found file");
            domainBean.setTime_stamp("Not found file");
            domainBean.setAuthor("Not found file");
            domainBean.setCompany("Not found file");
            arr.add(domainBean);
            return ResponseEntity.ok().body(arr);
        }
    }

    // read content file
    @GetMapping("/read/{NameCompany}/{FileName}")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readFile(
        @PathVariable("FileName") Integer FileName,
        @PathVariable("NameCompany") String NameCompany
    ) {
        Document doc = new Document(System.getProperty("user.home")+"\\Downloads\\uploads\\"+NameCompany+"\\"+jdbcTemplate.queryForList("select image_name from files where id_image=?", FileName).get(0).get("image_name"));
        ArrayList <List> arrayList = new ArrayList<>();
        for (Object obj : doc.getChildNodes(NodeType.PARAGRAPH, true))
        {
            Paragraph para = (Paragraph)obj;
            arrayList.add(Collections.singletonList(para.toString(SaveFormat.TEXT)));
        }
//        for (Object obj : doc.getChildNodes(NodeType.RUN, true))
//        {
//            Run run = (Run)obj;
//            Font font = run.getFont();
//            arrayList.add(Collections.singletonList(font.getName() + "," + font.getSize()));
//            arrayList.add(Collections.singletonList(run.getText()));
//        }
        return ResponseEntity.ok().body(arrayList);
    }

    // Define a method to download files
    @GetMapping("download/{NameCompany}/{filename}")
    public ResponseEntity<Resource> downloadFiles (
        @PathVariable("filename") String filename,
        @PathVariable("NameCompany") String NameCompany
    ) throws IOException {
        Path filePath = get(DIRECTORY+NameCompany).toAbsolutePath().normalize().resolve(filename);
        if(!Files.exists(filePath)) {
            throw new FileNotFoundException(filename + " was not found on the server");
        }
        Resource resource = new UrlResource(filePath.toUri());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("File-Name", filename);
        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                .headers(httpHeaders).body(resource);
    }
}