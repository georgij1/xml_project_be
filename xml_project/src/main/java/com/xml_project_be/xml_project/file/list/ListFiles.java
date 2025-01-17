package com.xml_project_be.xml_project.file.list;

import com.xml_project_be.xml_project.file.CreateJson.DomainBean;
import com.xml_project_be.xml_project.file.form.Form;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;

public class ListFiles {
    public static ResponseEntity<?> listFiles(JdbcTemplate jdbcTemplate, Form NameCompany) {
        // if (Boolean.TRUE.equals(jdbcTemplate.queryForObject("select exists(select name_company from files where name_company=?)", Boolean.class, NameCompany.getNameCompany()))) {
        //     return ResponseEntity.ok().body(
        //             jdbcTemplate.queryForList("select * from files where name_company=?", NameCompany.getNameCompany())
        //     );
        // } else {
        //     ArrayList<DomainBean> arr = new ArrayList<>();
        //     DomainBean domainBean = new DomainBean();
        //     // domainBean.setId_file("1");
        //     // domainBean.setFile_name("Not found file");
        //     // domainBean.setTime_stamp("Not found file");
        //     // domainBean.setAuthor("Not found file");
        //     // domainBean.setCompany("Not found file");
        //     arr.add(domainBean);
        //     return ResponseEntity.ok().body(arr);
        // }
        return ResponseEntity.ok("");
    }
}