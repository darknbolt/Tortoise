package com.darknbolt.tortoise.Controllers;

import com.darknbolt.tortoise.Auth.CustomUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() { return "login-form"; }

    @GetMapping("/register")
    public String register() { return "register"; }
}
