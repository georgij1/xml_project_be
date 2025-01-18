package com.xml_project_be.xml_project.company.Controllers;

import com.xml_project_be.xml_project.aop.CheckHeader;
import com.xml_project_be.xml_project.company.Dao.AuthCompanyDao;
import com.xml_project_be.xml_project.company.Dao.CreateCompanyDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Controller
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/company")
public class CreateCompany {
    JdbcTemplate jdbcTemplate;

    public static void create_dir_company(String company) {
        File file = new File("/home/georgii/Загрузки/uploads/"+company);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    @PostMapping("/auth")
    @ResponseBody
    // @CheckHeader
    public ResponseEntity<String> AuthCompany(@RequestBody AuthCompanyDao authCompany) throws IOException {
        System.out.println(authCompany.getNameCompany());
        System.out.println(authCompany.getPassword());

        if (Boolean.TRUE.equals(jdbcTemplate.queryForObject
                ("select exists(select * from company where name_company=?)",
                Boolean.class, authCompany.getNameCompany())
        )) {
            if (Boolean.TRUE.equals(jdbcTemplate.queryForObject("select exists(select * from company where password_company=?)", Boolean.class, authCompany.getPassword()))) {
                return new ResponseEntity<>("Success auth in company auth", HttpStatus.OK);
            }

            else {
                return new ResponseEntity<>("Name is exists, but password is not correct", HttpStatus.FORBIDDEN);
            }
        }

        else {
            return new ResponseEntity<>("Name is not exists", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    @ResponseBody
    // @CheckHeader
    public String all_company(@RequestBody CreateCompanyDao createCompany) {
        create_dir_company(createCompany.getName_company());
        System.out.println(createCompany.getName_company());
        System.out.println(createCompany.getPassword_company());
        System.out.println(createCompany.getDesc_company());

        jdbcTemplate.update("insert into xml_project.public.company(" +
            "name_company, password_company, desc_company, owner_company) " +
            "VALUES (?, ?, ?, ?)", createCompany.getName_company(),
            createCompany.getPassword_company(), createCompany.getDesc_company(),
            createCompany.getOwner_company()
        );

        return "success create company";
    }
}