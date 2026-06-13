package com.xml_project_be.xml_project.company.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.xml_project_be.xml_project.company.dto.AuthCompanyDto;
import com.xml_project_be.xml_project.company.dto.CreateCompanyDto;
import com.xml_project_be.xml_project.company.dto.UpdateCompanyDto;

@Service
public class CompanyServicve {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static Boolean createDirCompany(String company) {
        String basePath = System.getProperty("user.home") + File.separator + "xmlApp" + File.separator + "uploads";
        File file = new File(basePath + File.separator + company);
        
        if (!file.exists()) {
            boolean created = file.mkdirs();
            return created;
        }

        return false;
    }

    public ResponseEntity<?> authCompany(AuthCompanyDto authCompany) {
        var isNameCompany = Boolean.TRUE.equals(
            jdbcTemplate.queryForObject(
                "select exists(select * from xml_project.xml_project.company where name_company=?)",
                Boolean.class, 
                authCompany.getNameCompany()
            )
        );

        var isPasswordCompany = Boolean.TRUE.equals(
            jdbcTemplate.queryForObject(
                "select exists(select * from xml_project.xml_project.company where password_company=?)", 
                Boolean.class, 
                authCompany.getPasswordCompany()
            )
        );
        
        return new ResponseEntity<>("", isNameCompany && isPasswordCompany ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }

    public ResponseEntity<?> createCompany(CreateCompanyDto createCompany) {
                createDirCompany(createCompany.getNameCompany());
        
        var isCreate = jdbcTemplate.update(
            "insert into xml_project.xml_project.company(" +
            "name_company, password_company, desc_company, owner_company) " +
            "VALUES (?, ?, ?, ?)", createCompany.getNameCompany(),
            createCompany.getPasswordCompany(), createCompany.getDescCompany(),
            createCompany.getOwnerCompany()
        );

        return new ResponseEntity<>(isCreate==1 ? "success create company" : "error in create company", isCreate==1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getAllCompany() {
        var isCreate = jdbcTemplate.queryForList("select * from xml_project.xml_project.company");
        return new ResponseEntity<>(isCreate, isCreate.size() > 0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <?> getCompanyById(Integer id) {
        var isCreate = jdbcTemplate.queryForList("select * from xml_project.xml_project.company where id=?", id);
        return new ResponseEntity<>(isCreate, isCreate.size() > 0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> deleteCompany(Integer id) {
        var isCreate = jdbcTemplate.update("DELETE FROM xml_project.xml_project.company WHERE id = ?", id);
        return new ResponseEntity<>(isCreate==1 ? "success is delete" : "error delete", isCreate==1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> updateCompany(Integer id, UpdateCompanyDto updateCompanyDto) {
        var isUpdated = jdbcTemplate.update(
            "UPDATE xml_project.xml_project.company SET name_company = ?, password_company = ?, desc_company = ?, owner_company = ? WHERE id = ?",
            updateCompanyDto.getNameCompany(),
            updateCompanyDto.getPasswordCompany(),
            updateCompanyDto.getDescCompany(),
            updateCompanyDto.getOwnerCompany(),
            id
        );
        
        return new ResponseEntity<>(
            isUpdated == 1 ? "success update" : "error update", 
            isUpdated == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST
        );
    }
}
