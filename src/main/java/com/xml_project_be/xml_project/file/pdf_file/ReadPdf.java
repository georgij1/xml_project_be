package com.xml_project_be.xml_project.file.pdf_file;

// import com.aspose.pdf.Page;
// import com.aspose.pdf.TextFragment;
import com.xml_project_be.xml_project.file.dir.CheckMKDir;
import com.xml_project_be.xml_project.file.dto.DomainBeanPdfDTO;
import com.xml_project_be.xml_project.file.dto.ReadFileDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import static java.nio.file.Paths.get;

public class ReadPdf {
    public static ResponseEntity<?> readPdf(
        ReadFileDTO readFileDTO, 
        JdbcTemplate jdbcTemplate
    ) {
        var nameCompany = readFileDTO.getNameCompany();
        var fileId = readFileDTO.getFileID();
        ArrayList<DomainBeanPdfDTO> arrayListPdf = new ArrayList<>();

        File file = new File("/home/georgii/Загрузки/uploads/"+nameCompany+"/pdf");

        var getFileName = jdbcTemplate.queryForList(
            "select file_name from files where id_file=?", 
            fileId
        ).get(0).get("file_name");

        CheckMKDir.check_dir_exist(file);
        
        // String pathWithOutFormatDir = String.valueOf(
        //     get(
        //         "/home/georgii/Загрузки/uploads/"
        //         +
        //         nameCompany
        //         +
        //         "/"
        //         +
        //         getFileName
        //     )
        // );
        
        String pathFormatDirPdf = String.valueOf(
            get(
                "/home/georgii/Загрузки/uploads/"
                +
                nameCompany
                +
                "/pdf/"
                +
                getFileName
            )
        );

        com.aspose.pdf.Document documentPdf = new com.aspose.pdf.Document();

        // Page pagePdf = documentPdf.getPages().add();
        
        DomainBeanPdfDTO domainBeanPdf = new DomainBeanPdfDTO();

        // com.spire.doc.Document documentWord = new com.spire.doc.Document();
        // documentWord.loadFromFile(pathWithOutFormatDir);

        // String contentWord = documentWord.getText();
        
        // pagePdf.getParagraphs().add(new TextFragment(contentWord));

        File filePathPdf = new File(pathFormatDirPdf+".pdf");
        
        if (!filePathPdf.exists()) {
            documentPdf.save(pathFormatDirPdf + ".pdf");
        }
        
        documentPdf.close();
        // documentWord.close();
        
        domainBeanPdf.setNameFile(Collections.singletonList(getFileName.toString()));

        // domainBeanPdf.setContentFile(Collections.singletonList(contentWord));
        
        arrayListPdf.add(domainBeanPdf);
        
        return ResponseEntity.ok().body(arrayListPdf);
    }
}