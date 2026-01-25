package com.example.xmlandjson;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping(
            value = "/stu",
            produces = {"application/xml"}
    )
    public List<Student> getStudent() {

        return Arrays.asList(
                new Student(101, "Reshma", "reshma@gmail.com"),
                new Student(102, "ketaki", "ketaki@gmail.com"),
                new Student(103, "Shivam", "shivam@gmail.com"),
                new Student(104, "Siddhi", "siddhi@gmail.com")
        );
    }
}
