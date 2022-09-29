package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping
    public List index(){
        List<User> all = userMapper.findAll();
        return all;
    }

    @PostMapping
    public Integer save(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }
}
