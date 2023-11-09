package com.example.placementmodule.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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


}
