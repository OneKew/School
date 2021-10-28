package com.example.school.controllers;

import com.example.school.actions.CourseAction;
import com.example.school.actions.LessonAction;
import com.example.school.actions.ModuleAction;
import com.example.school.model.Course;
import com.example.school.model.Lesson;
import com.example.school.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseAction courseAction;
    @Autowired
    ModuleAction moduleAction;
    @Autowired
    LessonAction lessonAction;

    @GetMapping()
    public String course(Model model) {
        Iterable<Course> courses = courseAction.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("course", new Course());
        return "course";
    }
    @PostMapping()
    public String add(@ModelAttribute("course") Course course, Model model){
        courseAction.save(course);
        model.addAttribute("courses", courseAction.findAll());
        return "course";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model) {
        model.addAttribute("filter", filter);
        List<Course> courses = courseAction.findByTag(filter);
        model.addAttribute("courses", courses);
        return "course";
    }


    @GetMapping("/{course}")
    public String showCourse(@PathVariable Course course, Model model) {
        model.addAttribute("course", course);
        List<Module> modules = moduleAction.findModulesByCourseId(course.getId());
        model.addAttribute("modules", modules);
        Module module = new Module();
        model.addAttribute("module", module);
        return "module";
    }
    
    @PostMapping("/{course}")
    public String addModule(@PathVariable Course course,
                            @ModelAttribute("module") Module module,
                            Model model){
        course.setModule(module);
        moduleAction.save(module);
        List<Module> modules = moduleAction.findModulesByCourseId(course.getId());
        model.addAttribute("modules", modules);
        return "module";

    }

    @GetMapping("/{course}/{module}")
    public String showModule(@PathVariable Course course,
                             @PathVariable Module module,
                             Model model) {
        model.addAttribute("module", module);
        model.addAttribute("lessons", lessonAction.findLessonsByModuleId(module.getId()));
        Lesson lesson = new Lesson();
        model.addAttribute("lesson", lesson);
        return "lesson";
    }
    @PostMapping("/{course}/{module}")
    public String addLesson(@PathVariable Course course,
                            @PathVariable Module module,
                            @ModelAttribute("lesson") Lesson lesson,
                            Model model) {
        module.setLesson(lesson);
        lessonAction.save(lesson);
        return "lesson";
    }

}
