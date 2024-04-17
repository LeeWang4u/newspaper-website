package com.ptit.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class IndexController {
    public String index(){
        return "index";
    }
}
