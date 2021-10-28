package com.example.school.model;
import org.springframework.ui.Model;

import javax.persistence.*;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String lesson_header;
    @Column
    private String lesson_text;
    @Column
    private String lesson_video;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "module_id")
    private Module module;

    public Lesson() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLesson_video() {
        return lesson_video;
    }

    public void setLesson_video(String lesson_video) {
        this.lesson_video = lesson_video;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLesson_header() {
        return lesson_header;
    }

    public void setLesson_header(String lesson_header) {
        this.lesson_header = lesson_header;
    }

    public String getLesson_text() {
        return lesson_text;
    }

    public void setLesson_text(String lesson_text) {
        this.lesson_text = lesson_text;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}