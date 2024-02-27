package com.Student.repositery;

import com.Student.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespositery extends JpaRepository<User,String> {
   
   User findByEmail(String email);
}
