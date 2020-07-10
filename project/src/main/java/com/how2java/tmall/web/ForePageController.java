package com.how2java.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ForePageController {
    @GetMapping(value="/")
    public String index(){
        return "redirect:home";
    }

    @GetMapping(value="/home")
    public String home(){
        return "redirect:admin_department_list";
    }

    @GetMapping(value="/login")
    public String login(){
        return "fore/login";
    }

    @GetMapping("/forelogout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:login";
    }
}
