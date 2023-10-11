package com.example.StudentCRUD.repository;

import com.example.StudentCRUD.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepoImpl implements StudentRepo {
    private Map<Integer, Student> studentMap = new HashMap<>(); //in-memory --> temporary
    @Override
    public Student insertStudent(Student student) {
        studentMap.put(student.getRollNumber(), student);
        return student;
    }

    @Override
    public Student getStudent(int rollNumber) {
       return studentMap.get(rollNumber);
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        if(studentMap.containsKey(studentId)){
            studentMap.put(studentId, student);
            return student;
        }
        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        for (Integer n :studentMap.keySet()){
            students.add(studentMap.get(n));
        }
        return students;
    }

    @Override
    public String deleteStudent(int studId) {
        studentMap.remove(studId);
        return "Successfully deleted";
    }

    @Override
    public List<Student> getParticularBranchStud(String branch) {
        List<Student> students = new ArrayList<>();
        for(int n: studentMap.keySet()){
           Student student = studentMap.get(n);
           if(student.getBranch().equals(branch)){
               students.add(student);
           }
        }
        return students;

    }
}
