package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface UserMapper extends BaseMapper<User> {
//    @Select("SELECT * from sys_user")
//    List<User> findAll();
//
//    @Insert("INSERT into sys_user(username, password, nickname, email,phone, address) VALUES " +
//            "(#{username}, #{password},#{nickname},#{email},#{phone},#{address})")
//    int insert(User user);
//
//    int update(User user);
//
//    @Delete("Delete from sys_user where id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//
//    @Select("SELECT * from sys_user limit #{arg0}, #{arg1}")
//    List<User> selectPage(Integer pageNum, Integer pageSize);
//
//    @Select("select count(*) from sys_user")
//    Integer selectTotal();
////    @Select("SELECT * from sys_user limit #{pageNum}, #{pageSize}")
////    List<User> selectPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}
