package com.xml_project_be.xml_project.account;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("api/account")
public class AccountController {
    JdbcTemplate jdbcTemplate;

    @PostMapping("/edit")
    @ResponseBody
    public formChangeData EditAccount(
            @RequestBody formChangeData formChangeData
    ) {
        System.out.println(formChangeData);
        jdbcTemplate.update("update users set username=? where username=?", formChangeData.getNewLogin(), formChangeData.getOldLogin());
        jdbcTemplate.update("update users set info_person=? where username=?", formChangeData.getInfoPerson(), formChangeData.getNewLogin());
        jdbcTemplate.update("update company set name_company=? where name_company=?", formChangeData.getNewNameCompany(), formChangeData.getOldNameCompany());
        jdbcTemplate.update("update files set name_company=? where name_company=?", formChangeData.getNewNameCompany(), formChangeData.getOldNameCompany());
        return formChangeData;
    }
}