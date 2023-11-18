// StudentService.java
package com.example.placementmodule.service;

import com.example.placementmodule.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();

    Optional<Student> getStudentById(Long id);

    Student createStudent(Student student);

    Student updateStudent(Long id, Student updatedStudent);

    void deleteStudent(Long id);
}
