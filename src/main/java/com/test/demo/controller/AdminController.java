package com.test.demo.controller;

import com.test.demo.Model.User;
import com.test.demo.Service.UserService;
import com.test.demo.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUserList(){
        return ResponseEntity.ok().body(userDao.getUserList());
    }

    @DeleteMapping("/user")
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam("id") String id){
        System.out.println(id);
        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
