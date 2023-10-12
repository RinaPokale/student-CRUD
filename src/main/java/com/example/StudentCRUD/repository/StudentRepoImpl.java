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
    public String insertStudent(Student student) {
        if(existStudent(student)){
            return "student id " + student.getRollNumber() + " already exist!";
        }
        studentMap.put(student.getRollNumber(), student);
        return "successfully inserted!";

    }


    //## Helper function
    //Method overloading
    private boolean existStudent(Student student){
        return existStudent(student.getRollNumber());
    }

    private boolean existStudent(int studID){
        if(studentMap.containsKey(studID)){
            return true;
        }
        return false;
    }

    //get student by id
    @Override
    public Student getStudent(int rollNumber) throws RuntimeException {
        if(existStudent(rollNumber)){
            return studentMap.get(rollNumber);
        }
        throw new RuntimeException("Student id " + rollNumber + " not found!");
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        if(existStudent(studentId)){
            studentMap.put(studentId, student);
            return student;
        }
        else{
            System.out.println("Student id " + studentId + " not found");
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
