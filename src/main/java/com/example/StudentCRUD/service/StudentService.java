package com.example.StudentCRUD.service;

import com.example.StudentCRUD.model.Student;

import java.util.List;

public interface StudentService {
    String insertStudent(Student student);

    Student getStudent(int rollNumber);

    Student updateStudent(int studentId, Student student);

    List<Student> getAllStudent();

    String deleteStudent(int studId);

    List<Student> getParticularBranchStud(String branch);
}
