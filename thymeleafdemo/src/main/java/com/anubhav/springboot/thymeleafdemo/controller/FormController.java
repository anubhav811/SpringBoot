package com.anubhav.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "form";
    }
    @RequestMapping("/processForm")
    public String processForm(@RequestParam("studentName") String studentName, Model model){
        studentName = studentName.toUpperCase();
        String result = "Yo ! " + studentName;
        model.addAttribute("message",result);
        return "submit";
    }
}
