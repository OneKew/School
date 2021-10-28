package com.example.school.controllers;


import com.example.school.actions.UserAction;
import com.example.school.model.Role;
import com.example.school.model.User;
import com.example.school.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserAction userAction;

    @GetMapping(path="/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String addUser(User user, UserInfo userInfo, Model model){
        User userFromDb = userAction.findByUsername(user.getUsername());
        if (userFromDb != null){
            model.addAttribute("message", "User exists!");
            return "/registration";
        }
        else {
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            user.setUserInfo(userInfo);
            user.getUserInfo().setEmail(user.getUsername());
            userAction.save(user);
            return "redirect:/login";
        }
    }
}
