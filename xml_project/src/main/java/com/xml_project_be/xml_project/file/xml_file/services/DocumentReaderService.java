package com.xml_project_be.xml_project.file.xml_file.services;

import lombok.SneakyThrows;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.List;

@Service
public class DocumentReaderService {
    @SneakyThrows
    public static List<String> readLines(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            // Итерируем по параграфам документа
            for (XWPFPictureData picture : document.getAllPictures()) {
                PackagePart pictureData = picture.getPackagePart().getPackage().getParts().get(Integer.decode(String.valueOf(picture.getPackagePart().getPartName())));
                // Обрабатываем данные изображения по необходимости
                System.out.println(pictureData);
            }

            // Итерируем по параграфам документа
            document.getParagraphs().forEach(paragraph -> {
                String paragraphText = paragraph.getText();
                // Теперь у вас есть текст параграфа, который можно обработать по вашему усмотрению
                System.out.println(paragraphText);
            });
        }

        return Collections.singletonList("");
    }
}