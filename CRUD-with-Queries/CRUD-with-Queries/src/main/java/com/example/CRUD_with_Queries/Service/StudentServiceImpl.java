package com.example.CRUD_with_Queries.Service;

import com.example.CRUD_with_Queries.entity.Student;
import com.example.CRUD_with_Queries.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        studentRepository.insertStudent(student.getName(), student.getEmail(), student.getAge());
        return student;
    }

    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public int updateStudent(Long id, String name, String email) {
        return studentRepository.updateStudent(id, name, email);
    }

    public int deleteStudent(Long id) {
        return studentRepository.deleteStudent(id);
    }
}
