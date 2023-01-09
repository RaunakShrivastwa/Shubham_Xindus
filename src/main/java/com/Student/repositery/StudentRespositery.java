package com.Student.repositery;

import com.Student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespositery extends JpaRepository<Student,String> {
   Student findByEmail(String email);
}
