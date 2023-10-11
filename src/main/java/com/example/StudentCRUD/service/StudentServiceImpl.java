package com.example.StudentCRUD.service;

import com.example.StudentCRUD.model.Student;
import com.example.StudentCRUD.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public Student insertStudent(Student student) {
        return studentRepo.insertStudent(student);
    }

    @Override
    public Student getStudent(int rollNumber) {
        return studentRepo.getStudent(rollNumber);
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        return studentRepo.updateStudent(studentId, student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.getAllStudent();
    }

    @Override
    public String deleteStudent(int studId) {
        return studentRepo.deleteStudent(studId);
    }

    @Override
    public List<Student> getParticularBranchStud(String branch) {
        return studentRepo.getParticularBranchStud(branch);
    }
}
