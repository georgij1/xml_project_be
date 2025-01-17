package com.xml_project_be.xml_project.file.pdf_file;

import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.xml_project_be.xml_project.file.CreateJson.DomainBeanPdf;
import com.xml_project_be.xml_project.file.dir.CheckMKDir;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import static java.nio.file.Paths.get;

public class ReadPdf {
    public static ResponseEntity<?> readPdf(Integer IdFile, String NameCompany, JdbcTemplate jdbcTemplate) {
        File file = new File("/home/georgii/Загрузки/uploads/" + NameCompany + "/pdf");
        CheckMKDir.check_dir_exist(file);
        String DEST = String.valueOf(get("/home/georgii/Загрузки/uploads/" + NameCompany + "/" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name")));
        String DEST_PDF = String.valueOf(get("/home/georgii/Загрузки/uploads/" + NameCompany + "/pdf/" + jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name")));
        com.aspose.pdf.Document document = new com.aspose.pdf.Document();
        Page page = document.getPages().add();
        DomainBeanPdf domainBeanPdf = new DomainBeanPdf();
        ArrayList<DomainBeanPdf> arrayList = new ArrayList<>();
        com.spire.doc.Document document1 = new com.spire.doc.Document();
        document1.loadFromFile(DEST);
        String content = document1.getText();
        page.getParagraphs().add(new TextFragment(content));
        File file1 = new File(DEST_PDF+".pdf");
        if (!file1.exists()) {
            document.save(DEST_PDF + ".pdf");
        }
        // domainBeanPdf.setName_file(Collections.singletonList(jdbcTemplate.queryForList("select file_name from files where id_file=?", IdFile).get(0).get("file_name").toString()));
        // domainBeanPdf.setContent_file(Collections.singletonList(content));
        arrayList.add(domainBeanPdf);
        return ResponseEntity.ok().body(arrayList);
    }
}