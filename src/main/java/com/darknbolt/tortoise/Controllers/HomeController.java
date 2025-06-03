package com.darknbolt.tortoise.Controllers;

import com.darknbolt.tortoise.Auth.CustomUserDetailsService;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("pageTitle", "Tortoise");
        model.addAttribute("headerOne", "Tortoise Header works");
        model.addAttribute("bodyOne", "Tortoise body works");
        return "base";
    }


}
