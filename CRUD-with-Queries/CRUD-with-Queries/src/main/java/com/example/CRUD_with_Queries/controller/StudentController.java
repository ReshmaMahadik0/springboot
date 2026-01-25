package com.example.CRUD_with_Queries.controller;

import com.example.CRUD_with_Queries.Service.StudentService;
import com.example.CRUD_with_Queries.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student student1 = service.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);

    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Student student) {
        service.updateStudent(id, student.getName(), student.getEmail());
        return "Student Updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Student Deleted";
    }
}