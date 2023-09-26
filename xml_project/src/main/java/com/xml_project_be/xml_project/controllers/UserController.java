package com.xml_project_be.xml_project.controllers;

import com.xml_project_be.xml_project.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/v1/users")
public class UserController {
    UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    // test request for check filter request
    @GetMapping
    @ResponseBody
    public String Test() {
        return "ResponseEntity.ok(a)";
    }
}