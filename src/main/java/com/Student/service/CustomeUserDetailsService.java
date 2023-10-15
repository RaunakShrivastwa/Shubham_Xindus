package com.Student.service;

import com.Student.entity.Student;
import com.Student.entity.StudentUserDetailsService;
import com.Student.exception.ResourceNotFoundException;
import com.Student.repositery.StudentRespositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomeUserDetailsService implements UserDetailsService {

    @Autowired
    StudentRespositery studentRespositery;

    @Autowired
    StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String email) throws ResourceNotFoundException {
        Student student = this.studentRespositery.findByEmail(email);
        System.out.println("student is:- "+student);
        if(student==null){
            throw new ResourceNotFoundException("not there");
        }
        return new StudentUserDetailsService(student);
    }
}
