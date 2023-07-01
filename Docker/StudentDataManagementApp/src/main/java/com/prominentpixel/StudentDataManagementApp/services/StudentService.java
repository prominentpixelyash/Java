package com.prominentpixel.StudentDataManagementApp.services;

import com.prominentpixel.StudentDataManagementApp.models.Student;
import com.prominentpixel.StudentDataManagementApp.exceptions.NoStudentException;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);

    public  Student getStudentByRollNo(Integer rollNumber) throws NoStudentException;

    public List<Student> getAllStudent() throws NoStudentException;

}
