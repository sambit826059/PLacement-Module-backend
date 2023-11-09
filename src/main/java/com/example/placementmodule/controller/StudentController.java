package com.example.placementmodule.controller;

import com.example.placementmodule.model.Student;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @GetMapping
    public String getAllStudents() {
        //code
        return "List of all students";
    }

    @GetMapping
    public String getStudentByID(@PathVariable Long id) {
        //code
        return "Student details for ID: "+id;
    }

    @PostMapping
    public String createStudent(@RequestBody Student student) {
        //code
        return "Student created";
    }
}
