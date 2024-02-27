package com.Student.impl;

import com.Student.entity.User;
import com.Student.exception.ResourceNotFoundException;
import com.Student.repositery.UserRespositery;
import com.Student.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRespositery userRespositery;

    @Override
    public User saveUser(User user) {
//        User.setRole("ROLE_NORMAL");
        user.setPassword(passwordEncryption(user.getPassword()));
        String s = UUID.randomUUID().toString();
        user.setId(s);
        return this.userRespositery.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRespositery.findAll();
    }

    @Override
    public User getSingleUser(String id) {
        return this.userRespositery.findById(id).orElseThrow(()->new ResourceNotFoundException("Given the resource not found with the given User id "+id));
    }

    @Override
    public String deleteUser(String userId) {

        this.userRespositery.deleteById(userId);
        return "User with id "+userId+" has been deleted";
    }

    @Override
    public User updateUser(String userId, User userName) {
        User User = getSingleUser(userId);
        User.setName(userName.getName());
        User save = this.userRespositery.save(User);
        return save;
    }

    public String passwordEncryption(String pass){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String password=bCryptPasswordEncoder.encode(pass);
        return password;
    }


}
