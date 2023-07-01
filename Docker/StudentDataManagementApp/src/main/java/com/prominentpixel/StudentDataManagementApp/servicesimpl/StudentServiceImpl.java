package com.prominentpixel.StudentDataManagementApp.servicesimpl;

import com.prominentpixel.StudentDataManagementApp.exceptions.NoStudentException;
import com.prominentpixel.StudentDataManagementApp.models.Student;
import com.prominentpixel.StudentDataManagementApp.repo.StudentRepo;
import com.prominentpixel.StudentDataManagementApp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentByRollNo(Integer rollNumber) throws NoStudentException {
        Optional<Student> optionalStudent= studentRepo.findById(rollNumber);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }
        else
            throw new NoStudentException("No student found with roll no "+rollNumber);
    }

    @Override
    public List<Student> getAllStudent() throws NoStudentException {
        List<Student> allStudent=studentRepo.findAll();
        if(allStudent.size()>0){
            return allStudent;
        }
        else
            throw new NoStudentException("No data found in database");
    }
}
