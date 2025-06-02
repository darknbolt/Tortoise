package com.darknbolt.tortoise.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("pageTitle", "Tortoise");
        model.addAttribute("headerOne", "Tortoise Header works");
        model.addAttribute("bodyOne", "Tortoise body works");
        return "home";
    }


}
