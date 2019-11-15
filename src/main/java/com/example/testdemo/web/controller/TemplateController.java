package com.example.testdemo.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/template")
public class TemplateController {

    private Logger logger = LogManager.getLogger(TemplateController.class);

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index.html");
        return mv;
    }

}
