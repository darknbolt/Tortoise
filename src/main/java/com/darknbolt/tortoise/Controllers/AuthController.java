package com.darknbolt.tortoise.Controllers;

import com.darknbolt.tortoise.Models.UserDTO;
import com.darknbolt.tortoise.Services.PasswordValidatorService;
import com.darknbolt.tortoise.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;
    private final PasswordValidatorService passwordValidatorService;

    public AuthController(UserService userService, PasswordValidatorService passwordValidatorService) {
        this.userService = userService;
        this.passwordValidatorService = passwordValidatorService;
    }

    @GetMapping("/login")
    public String login() { return "login-form"; }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute("user") UserDTO userDTO, Model model) {
        if(!userDTO.getPassword().equals(userDTO.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }

        if(!passwordValidatorService.validatePassword(userDTO.getPassword())) {
            model.addAttribute("error", "Password must be: 8 Characters, has a digit, at least 1 capital letter and 1 lower letter");
            return "register";
        }

        userService.registerNewUser(userDTO);
        return "redirect:/index";
    }
}
