package com.example.school.controllers;


import com.example.school.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @GetMapping(path = "/profile")
    public String profile(@ModelAttribute("usr") User user, Model model) {
        model.addAttribute("usr", user );
        return "profile";
    }
    @PostMapping("/profile")
    public String userProfile(@ModelAttribute("usr") User user){

        return "profile";
    }
}
