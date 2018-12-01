package com.devwook88.learn_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
    @RequestMapping("/th")
    public String templatePage(Model model) {
        model.addAttribute("message", "boot template");
        return "th";
    }
}
