// StudentServiceImpl.java
package com.example.placementmodule.service.impl;

import com.example.placementmodule.model.Student;
import com.example.placementmodule.repository.StudentRepository;
import com.example.placementmodule.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);

        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            // Update the fields you want to update
            if (updatedStudent.getRegistrationNumber() != null) {
                student.setRegistrationNumber(updatedStudent.getRegistrationNumber());
            }

            if (updatedStudent.getFirstName() != null) {
                student.setFirstName(updatedStudent.getFirstName());
            }

            if (updatedStudent.getMiddleName() != null) {
                student.setMiddleName(updatedStudent.getMiddleName());
            }

            if (updatedStudent.getLastName() != null) {
                student.setLastName(updatedStudent.getLastName());
            }

            if (updatedStudent.getEmail() != null) {
                student.setEmail(updatedStudent.getEmail());
            }

            // ... update other fields as needed

            return studentRepository.save(student);
        } else {
            // Handle the case where the student with the given id is not found
            return null; // You can throw an exception or handle it as appropriate for your application
        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
