package com.Student.controller;

import com.Student.entity.Student;
import com.Student.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    Logger logger= LoggerFactory.getLogger(Student.class);

//    save the student
    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student saveStudent = this.studentService.saveStudent(student);
        logger.info("Data saved as:- "+saveStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
    }

//    get All Student
    @GetMapping("/getallstudents")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> student = this.studentService.getAllStudent();
        logger.info("All Data as:- "+student);
        return ResponseEntity.ok().body(student);
    }

//    get single Student
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getSingleStudent(@PathVariable String id){
        Student student = this.studentService.getSingleStudent(id);
        logger.info("Single Student:- "+student);
        return ResponseEntity.ok().body(student);
    }

//    delete single Student
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id){
        String student = this.studentService.deleteStudent(id);
        logger.info("Student deleted:- "+student);
        return ResponseEntity.ok().body(student);
    }

//    update  single Student
    @PutMapping("/student/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id,@RequestBody Student student){
        Student student1 = this.studentService.updateStudent(id,student);
        logger.info("Student Updated Successfully"+student1);
        return ResponseEntity.ok().body(student1);
    }

    @PostMapping("/eror")
  public void ErrorMessage(){
        System.out.println("error!!!");
  }

  @GetMapping("/hallo")
  public String hallo(){
        return "this is home page";
  }

}
