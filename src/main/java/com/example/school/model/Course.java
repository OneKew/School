package com.example.school.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String tag;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Module> modules = new ArrayList<Module>();

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModule(Module module) {
        this.modules.add(module);
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
