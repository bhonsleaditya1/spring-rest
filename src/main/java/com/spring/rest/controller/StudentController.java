package com.spring.rest.controller;

import com.spring.rest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("ABC","Def"));
        students.add(new Student("Sus","Dsdf"));
        students.add(new Student("Mar","Dsdf"));
    }
    // endpoint for /students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        return students.get(studentId);
    }
}
