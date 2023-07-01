package com.prominentpixel.StudentDataManagementApp.repo;

import com.prominentpixel.StudentDataManagementApp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
