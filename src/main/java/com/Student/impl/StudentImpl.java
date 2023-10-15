package com.Student.impl;

import com.Student.entity.Student;
import com.Student.exception.ResourceNotFoundException;
import com.Student.repositery.StudentRespositery;
import com.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentImpl implements StudentService {


    @Autowired
    StudentRespositery studentRespositery;

    @Override
    public Student saveStudent(Student student) {
//        student.setRole("ROLE_NORMAL");
        student.setPassword(passwordEncryption(student.getPassword()));
        String s = UUID.randomUUID().toString();
        student.setId(s);
        return this.studentRespositery.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return this.studentRespositery.findAll();
    }

    @Override
    public Student getSingleStudent(String id) {
        return this.studentRespositery.findById(id).orElseThrow(()->new ResourceNotFoundException("Given the resource not found with the given Student id "+id));
    }

    @Override
    public String deleteStudent(String studentId) {

        this.studentRespositery.deleteById(studentId);
        return "Student with id "+studentId+" has been deleted";
    }

    @Override
    public Student updateStudent(String studentId, Student studentName) {
        Student student = getSingleStudent(studentId);
        student.setName(studentName.getName());
        student.setSection(studentName.getSection());
        Student save = this.studentRespositery.save(student);
        return save;
    }

    public String passwordEncryption(String pass){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String password=bCryptPasswordEncoder.encode(pass);
        return password;
    }


}
