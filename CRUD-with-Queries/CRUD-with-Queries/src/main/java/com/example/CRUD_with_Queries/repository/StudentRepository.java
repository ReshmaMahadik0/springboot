package com.example.CRUD_with_Queries.repository;

import com.example.CRUD_with_Queries.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Transactional
    @Query("INSERT INTO Student(name, email, age) VALUES (:name, :email, :age)")
    void insertStudent(@Param("name") String name, @Param("email") String email,
                       @Param("age") int age);

    @Query("FROM Student")
    List<Student> getAllStudents();

    @Query("FROM Student s WHERE s.id = :id")
    Student getStudentById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.name = :name, s.email = :email WHERE s.id = :id")
    int updateStudent(@Param("id") Long id, @Param("name") String name,
                      @Param("email") String email);


    @Modifying
    @Transactional
    @Query("DELETE FROM Student s WHERE s.id = :id")
    int deleteStudent(@Param("id") Long id);
}
