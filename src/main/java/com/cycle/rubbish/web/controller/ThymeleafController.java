package com.cycle.rubbish.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    private Logger logger = LogManager.getLogger(ThymeleafController.class);

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index.html");
        return mv;
    }

    @GetMapping("/tables")
    public ModelAndView tables(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/tables.html");
        return mv;
    }
}
