package com.example.ris.controllers;

import com.example.ris.models.entities.User;
import com.example.ris.services.RadnikService;
import com.example.ris.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {
    
    @Autowired
    private UserService _UserService;

    @PostMapping("/registracija")
    public String registerNewUser(@ModelAttribute("user") User user, RedirectAttributes message) {
        _UserService.registerUser(user);
        message.addFlashAttribute("message", "Uspješno ste se registrovali.");
        return "redirect:login";
    }
}
