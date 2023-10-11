package com.example.StudentCRUD.controller;

import com.example.StudentCRUD.model.Student;
import com.example.StudentCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Insert --> create
    @PostMapping("/student")
    private Student insertStudent(@RequestBody Student student){
        return studentService.insertStudent(student);
    }

    //Read --> fetch student by id
    @GetMapping("/student/{rollNumber}")
    private Student getStudent(@PathVariable int rollNumber){
        return studentService.getStudent(rollNumber);
    }

    //Read --> fetch all students
    @GetMapping("/students")
    private List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    //Update
    @PutMapping("/student/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student student){
        return studentService.updateStudent(studentId, student);
    }

    //Delete
    @DeleteMapping("/student/{studId}")
    public String deleteStudent(@PathVariable int studId){
        return studentService.deleteStudent(studId);
    }

    @GetMapping("/student/branch/{branch}")
    public List<Student> getParticularBranchStud(@PathVariable String branch){
        return studentService.getParticularBranchStud(branch);
    }
}
