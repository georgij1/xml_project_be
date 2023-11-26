package com.xml_project_be.xml_project.file.pdf_file;

import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.groupdocs.parser.Parser;
import com.groupdocs.parser.options.IDocumentInfo;
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
        File file = new File("C:\\Users\\Panov\\Downloads\\uploads\\" + NameCompany + "/pdf");
        CheckMKDir.check_dir_exist(file);
        String DEST = String.valueOf(get("C:\\Users\\Panov\\Downloads\\uploads\\" + NameCompany + "/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name")));
        String DEST_PDF = String.valueOf(get("C:\\Users\\Panov\\Downloads\\uploads\\" + NameCompany + "/pdf/" + jdbcTemplate.queryForList("select image_name from files where id_image=?", IdFile).get(0).get("image_name")));
        try (com.aspose.pdf.Document document = new com.aspose.pdf.Document()) {
            Page page = document.getPages().add();
            try (Parser parser = new Parser(DEST)) {
                if (!parser.getFeatures().isText()) {
                    System.out.println("The document doesn't support text extraction.");
                }

                IDocumentInfo documentInfo = parser.getDocumentInfo();

                if (documentInfo.getPageCount() == 0) {
                    System.out.println("The document has zero pages.");
                }

                DomainBeanPdf domainBeanPdf = new DomainBeanPdf();
                ArrayList<DomainBeanPdf> arrayList = new ArrayList<>();

                for (int p = 0; p < documentInfo.getPageCount(); p++) {
                    com.spire.doc.Document document1 = new com.spire.doc.Document();
                    document1.loadFromFile(DEST);
                    String content = document1.getText();
                    page.getParagraphs().add(new TextFragment(content));
                    document.save(DEST_PDF + ".pdf");
                    domainBeanPdf.setName_file(Collections.singletonList("Name PDF file"));
                    domainBeanPdf.setContent_file(Collections.singletonList(content));
                    System.out.println(arrayList);
                }

                arrayList.add(domainBeanPdf);

                return ResponseEntity.ok().body(arrayList);
            }
        }
    }
}