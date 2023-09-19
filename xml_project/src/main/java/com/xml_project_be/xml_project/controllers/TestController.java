package com.xml_project_be.xml_project.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TestController {
    @GetMapping("/test")
    @ResponseBody
    @CrossOrigin("*")
    public String test() {
        return "test";
    }
}