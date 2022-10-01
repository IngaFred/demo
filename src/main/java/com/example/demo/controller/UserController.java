package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.controller.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //查询所有
    @GetMapping
    public List index(){
        return userService.list();
    }

    //添加更改
    @PostMapping
    public boolean save(@RequestBody User user){
        return userService.saveUser(user);
    }

    //删除
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return userService.removeById(id);
    }

//    //分页查询
//    @GetMapping("/page")
//    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
//        pageNum = (pageNum - 1) * pageSize;
//        List<User> data = userMapper.selectPage(pageNum,pageSize);
//        Integer total = userMapper.selectTotal();
//        Map<String, Object> res =new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//        return res;
//    }

    //分页查询 - mybatis-plus   视频wrapper配置
    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue="") String username){
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //模糊查询  视频batis-plus  swaggerui  位置
        queryWrapper.like("username",username);
        return userService.page(page,queryWrapper);
    }


//    @PostMapping
//    public boolean login(@RequestBody UserDTO userDTO){
//        return userService.login(userDTO);
//    }

}
