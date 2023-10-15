package com.Student.repositery;

import com.Student.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespositery extends MongoRepository<Student,String> {
   
   Student findByEmail(String email);
}
