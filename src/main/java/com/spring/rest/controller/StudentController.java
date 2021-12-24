package com.spring.rest.controller;

import com.spring.rest.entity.Student;
import com.spring.rest.exception.StudentNotFound;
import org.springframework.web.bind.annotation.*;


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
        if(studentId>=students.size()||studentId<0){
            throw new StudentNotFound("Student id not found: "+studentId);
        }
        return students.get(studentId);
    }
}
