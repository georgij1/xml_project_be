package com.xml_project_be.xml_project.file;

import com.xml_project_be.xml_project.file.delete.Delete;
import com.xml_project_be.xml_project.file.download.DownloadAll;
import com.xml_project_be.xml_project.file.dto.BodyGetEditedFieldsDTO;
import com.xml_project_be.xml_project.file.dto.CreateRowDTO;
import com.xml_project_be.xml_project.file.dto.GetTableDTO;
import com.xml_project_be.xml_project.file.dto.ListFilesDTO;
import com.xml_project_be.xml_project.file.dto.ReadFileDTO;
import com.xml_project_be.xml_project.file.dto.ReadFileSplitWordDTO;
import com.xml_project_be.xml_project.file.dto.UploadFilesDTO;
import com.xml_project_be.xml_project.file.list.ListFiles;
import com.xml_project_be.xml_project.file.pdf_file.ReadPdf;
import com.xml_project_be.xml_project.file.upload.UploadFiles;
import com.xml_project_be.xml_project.file.word_file.ReadWordDocx;
import com.xml_project_be.xml_project.file.xml_file.editor.EditDocument;
import com.xml_project_be.xml_project.file.xml_file.reader.GenerateDocument;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/file")
@AllArgsConstructor
public class ControllerFile {
    JdbcTemplate jdbcTemplate;

    @PostMapping("/upload")
    @SneakyThrows
    public ResponseEntity<?> uploadFiles(
        @RequestBody UploadFilesDTO uploadFiles
    ) {
        return UploadFiles.uploadFilesDoc(
            uploadFiles, 
            jdbcTemplate
        );
    }

    @PostMapping("/list")
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> listFiles(
        @RequestBody ListFilesDTO listFilesDTO
    ) {
        return ListFiles.listFiles(
            jdbcTemplate, 
            listFilesDTO
        );
    }

    @GetMapping("/read")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readFile(
        @RequestBody ReadFileDTO readFileDTO
    ) {
        return ReadWordDocx.readWordDocx(
            readFileDTO,
            jdbcTemplate
        );
    }

    @GetMapping("/read/split_words")
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> readFileSplitWord(
        @RequestBody ReadFileSplitWordDTO readFileSplitWordDTO
    ) {
        return ReadWordDocx.readWordDocxSplitWords(
            readFileSplitWordDTO, 
            jdbcTemplate
        );
    }

    @GetMapping("/read/XML")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readXMLFile(
        @RequestBody ReadFileDTO readFileDTO
    ) {
        return GenerateDocument.generateDocument(
            readFileDTO,
            jdbcTemplate
        );
    }

    @GetMapping("/read/PDF")
    @CrossOrigin("*")
    @ResponseBody
    @SneakyThrows
    public ResponseEntity<?> readPDFFile(
        @RequestBody ReadFileDTO readFileDTO
    ) {
        return ReadPdf.readPdf(
            readFileDTO, 
            jdbcTemplate
        );
    }

    @GetMapping("/download/all")
    @SneakyThrows
    public ResponseEntity<?> downloadFiles(
        @RequestBody ReadFileDTO readFileDTO
    ) {
        return DownloadAll.downloadAll(readFileDTO);
    }

    @DeleteMapping("/delete/file/{NameCompany}/{NameFile}")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> deleteFile(
        @RequestBody ReadFileDTO readFileDTO
    ) {
        return Delete.delete(
            readFileDTO,
            jdbcTemplate
        );
    }

    @GetMapping("/xml/tables/{NameTable}/{NameCompany}/{NameFile}")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> getTable(
        @RequestBody GetTableDTO getTableDTO
    ) {
        // if (nameObjectXML.equals("ExpertOrganization")) {
        //     return GenerateDocument.getExpertOrga(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("Approver")) {
        //     return GenerateDocument.getApprover_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("ExaminationObject")) {
        //     return GenerateDocument.getExaminationObject_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("Documents")) {
        //     return GenerateDocument.getDocuments_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("PreviousConclusions")) {
        //     return GenerateDocument.getPreviousConclusions_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("PreviousSimpleConclusions")) {
        //     return GenerateDocument.getPreviousSimpleConclusions_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("Object")) {
        //     return GenerateDocument.getObject_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("Declarant")) {
        //     return GenerateDocument.getDeclarant_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("ProjectDocumentsDeveloper")) {
        //     return GenerateDocument.getProjectDocumentsDeveloper_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("Finance")) {
        //     return GenerateDocument.getFinance_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("ClimateConditions")) {
        //     return GenerateDocument.getClimateConditions_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("ClimateConditionsNote")) {
        //     return GenerateDocument.getClimateConditionsNote_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("ExpertProjectDocuments")) {
        //     return GenerateDocument.getExpertProjectDocuments_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("CadastralNumber")) {
        //     return GenerateDocument.getCadastralNumber_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("Experts")) {
        //     return GenerateDocument.getExperts_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("Designer")) {
        //     return GenerateDocument.getDesigner_object(IdFile, NameCompany, jdbcTemplate);
        // }
        // else if (nameObjectXML.equals("Summary")) {
        //     return GenerateDocument.getSummary_object(IdFile, NameCompany, jdbcTemplate);
        // }

        return GenerateDocument.getNotFoundObject();
    }

    @PostMapping("/xml/tables/edit")
    @ResponseBody
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> editTable(@RequestBody BodyGetEditedFieldsDTO bodyGetEditedFields) {
        if (bodyGetEditedFields.getTable_name().equals("ExpertOrganization")) {
            return EditDocument.setExpertOrganization_object(
                jdbcTemplate,
                bodyGetEditedFields.getColumn_name(),
                bodyGetEditedFields.getColumn_value(),
                bodyGetEditedFields.getId_transaction(),
                bodyGetEditedFields.getTable_name(),
                bodyGetEditedFields.getCompany_name(),
                bodyGetEditedFields.getId_file()
            );
        } 
        else if (bodyGetEditedFields.getTable_name().equals("Approver")) {
            return EditDocument.getApprover_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        }
        else if (bodyGetEditedFields.getTable_name().equals("ExaminationObject")) {
            return EditDocument.getExaminationObject_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        } 
        else if (bodyGetEditedFields.getTable_name().equals("Documents")) {
            return EditDocument.getDocuments_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        } 
        else if (bodyGetEditedFields.getTable_name().equals("PreviousConclusions")) {
            return EditDocument.getPreviousConclusions_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        }
        else if (bodyGetEditedFields.getTable_name().equals("PreviousSimpleConclusions")) {
            return EditDocument.getPreviousSimpleConclusions_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        } 
        else if (bodyGetEditedFields.getTable_name().equals("Object")) {
            return EditDocument.getObject_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        } 
        else if (bodyGetEditedFields.getTable_name().equals("Declarant")) {
            return EditDocument.getDeclarant_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        } 
        else if (bodyGetEditedFields.getTable_name().equals("ProjectDocumentsDeveloper")) {
            return EditDocument.getProjectDocumentsDeveloper_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        }
        else if (bodyGetEditedFields.getTable_name().equals("Finance")) {
            return EditDocument.getFinance_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        } 
        else if (bodyGetEditedFields.getTable_name().equals("ClimateConditions")) {
            return EditDocument.getClimateConditions_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        }
        else if (bodyGetEditedFields.getTable_name().equals("ClimateConditionsNote")) {
            return EditDocument.getClimateConditionsNote_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        }
        else if (bodyGetEditedFields.getTable_name().equals("ExpertProjectDocuments")) {
            return EditDocument.getExpertProjectDocuments_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        }
        else if (bodyGetEditedFields.getTable_name().equals("CadastralNumber")) {
            return EditDocument.getCadastralNumber_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        }
        
        else if (bodyGetEditedFields.getTable_name().equals("Experts")) {
            return EditDocument.getExperts_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        }
        else if (bodyGetEditedFields.getTable_name().equals("Designer")) {
            return EditDocument.getDesigner_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        }
        else if (bodyGetEditedFields.getTable_name().equals("Summary")) {
            return EditDocument.getSummary_object(
                    jdbcTemplate,
                    bodyGetEditedFields.getColumn_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getId_file()
            );
        } 
        else {
            return EditDocument.getNotFoundObject(
                    bodyGetEditedFields.getId_file(),
                    bodyGetEditedFields.getCompany_name(),
                    bodyGetEditedFields.getColumn_value(),
                    bodyGetEditedFields.getId_transaction(),
                    bodyGetEditedFields.getTable_name()
            );
        }
    }

    @PostMapping("/xml/tables/create/row")
    @CrossOrigin("*")
    @SneakyThrows
    public ResponseEntity<?> createTableRow(
        @RequestBody CreateRowDTO createRow
    ) {
        return EditDocument.getCreateRow(
            jdbcTemplate,
            createRow.getOrgFullName().toString(),
            createRow.getValue().toString(),
            createRow.getTableName(),
            createRow.getNameCompany(),
            createRow.getId_file()
        );
    }
}