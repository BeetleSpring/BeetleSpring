package com.beetle.onlinevideo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {


    @RequestMapping("/test")
    public String test(){

        return "admin_main";
    }
}
