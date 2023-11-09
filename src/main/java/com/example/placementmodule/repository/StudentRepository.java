package com.example.placementmodule.repository;

import com.example.placementmodule.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
