package com.Student.service;

import com.Student.entity.Student;

import java.util.List;

public interface StudentService {
//    save the students
    Student saveStudent(Student student);

//    getAllStudents
    List<Student> getAllStudent();

//    get single student
    Student getSingleStudent(String id);

//    delete the student
    String deleteStudent(String studentId);

//    update the student
    Student updateStudent(String studentId,Student studentName);


}
