package com.example.school.controllers;

import com.example.school.actions.UserAction;
import com.example.school.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
@Autowired
private UserAction userAction;


    @GetMapping(path = "/")
    public String home(Map<String, Object> model){
        return "index";
    }

    @GetMapping(path = "/main")
    public String main(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "main";
    }

    @GetMapping(path = "/admin")
    public String admin(Map<String, Object> model) {
        Iterable<User> users = userAction.findAll();
        model.put("users", users);
        return "admin";
    }
    @PostMapping(path = "/admin")
    public String add(@RequestParam String email, @RequestParam String first_name,
                      Map<String, Object> model){
        User user = new User(email, first_name);
        userAction.save(user);
        Iterable<User> users = userAction.findAll();
        model.put("users", users);
        return "admin";
    }


    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        List<User> users = userAction.findByEmail(filter);
        model.put("users", users);
        return "admin";
    }

}



