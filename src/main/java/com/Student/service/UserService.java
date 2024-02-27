package com.Student.service;

import com.Student.entity.User;

import java.util.List;

public interface UserService {
//    save the students
    User saveUser(User student);

//    getAllStudents
    List<User> getAllUser();

//    get single student
    User getSingleUser(String id);

//    delete the User
    String deleteUser(String UserId);

//    update the User
    User updateUser(String UserId,User UserName);


}
