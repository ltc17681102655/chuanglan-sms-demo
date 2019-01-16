package com.example.chuanglan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChuanglanController {

    @GetMapping("/test")
    public String demo() {
        return "success";
    }
}
