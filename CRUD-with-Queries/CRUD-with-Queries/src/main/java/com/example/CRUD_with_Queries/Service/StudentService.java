package com.example.CRUD_with_Queries.Service;

import com.example.CRUD_with_Queries.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    int updateStudent(Long id, String name, String email);
    int deleteStudent(Long id);
}
