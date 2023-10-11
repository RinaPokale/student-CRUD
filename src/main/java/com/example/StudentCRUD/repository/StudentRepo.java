package com.example.StudentCRUD.repository;

import com.example.StudentCRUD.model.Student;

import java.util.List;

public interface StudentRepo {
    Student insertStudent(Student student);

    Student getStudent(int rollNumber);

    Student updateStudent(int studentId, Student student);

    List<Student> getAllStudent();

    String deleteStudent(int studId);

    List<Student> getParticularBranchStud(String branch);
}
