package com.Student.controller;

import com.Student.entity.User;
import com.Student.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/student")
public class UserController {

    @Autowired
    UserService userService;

    Logger logger= LoggerFactory.getLogger(User.class);

//    save the student
    @PostMapping("/user")
    public ResponseEntity<User> saveStudent(@RequestBody User user){
        User saveuser = this.userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveuser);
    }

//    get All User
    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user = this.userService.getAllUser();
        return ResponseEntity.ok().body(user);
    }

//    get single User
    @GetMapping("/User/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable String id){
        User User = this.userService.getSingleUser(id);
        logger.info("Single User:- "+User);
        return ResponseEntity.ok().body(User);
    }

//    delete single User
    @DeleteMapping("/User/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        String User = this.userService.deleteUser(id);
        logger.info("User deleted:- "+User);
        return ResponseEntity.ok().body(User);
    }

//    update  single User
    @PutMapping("/User/update/{id}")
    public ResponseEntity updateUser(@PathVariable String id,@RequestBody User User){
        User User1 = this.userService.updateUser(id,User);
        logger.info("User Updated Successfully"+User1);
        return ResponseEntity.ok().body(User1);
    }

}
