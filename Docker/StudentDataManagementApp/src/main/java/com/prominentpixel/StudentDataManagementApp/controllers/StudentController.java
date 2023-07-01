package com.prominentpixel.StudentDataManagementApp.controllers;

import com.prominentpixel.StudentDataManagementApp.exceptions.NoStudentException;
import com.prominentpixel.StudentDataManagementApp.models.Student;
import com.prominentpixel.StudentDataManagementApp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prominentpixel")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getMessage")
    public ResponseEntity<String> getWelcomeMessage(){
        return new ResponseEntity<>("Welcome to student management application",HttpStatus.ACCEPTED);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student student1=studentService.saveStudent(student);
        return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
    }

    @GetMapping("/student/{roll}")
    public  ResponseEntity<Student> getStudentByRollNo(@PathVariable("roll") Integer rollNumber) throws NoStudentException{
        Student student=studentService.getStudentByRollNo(rollNumber);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent() throws NoStudentException{
        List<Student> students=studentService.getAllStudent();
        return new ResponseEntity<>(students,HttpStatus.CREATED);
    }


}
