package com.example.school.controllers;

import com.example.school.actions.CourseAction;
import com.example.school.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
@Autowired
private CourseAction courseAction;


    @GetMapping(path = "/")
    public String index(Map<String, Object> model){
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

    @GetMapping(path = "/course")
    public String course(Model model) {
        Iterable<Course> courses = courseAction.findAll();
        model.addAttribute("courses", courses);
        return "course.html";
    }
    @PostMapping(path = "/course")
    public String add(@RequestParam String name, @RequestParam String tag,
                      Model model){
        Course course = new Course(name, tag);
        courseAction.save(course);
        Iterable<Course> courses = courseAction.findAll();

        model.addAttribute("courses", courses);
        return "course.html";
    }


    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        List<Course> courses = courseAction.findByTag(filter);
        model.put("courses", courses);
        return "course.html";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

}



