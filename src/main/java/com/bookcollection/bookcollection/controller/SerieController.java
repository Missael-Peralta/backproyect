package com.bookcollection.bookcollection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieController {
    @GetMapping("/hello")
    public String hello(){
        return "hola, mundo 123";
    }
}
