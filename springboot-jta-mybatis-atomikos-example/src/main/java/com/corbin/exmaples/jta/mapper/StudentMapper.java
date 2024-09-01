package com.corbin.exmaples.jta.mapper;

import com.corbin.exmaples.jta.entity.secondary.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select({"select * from Student_loginData where 1=1 ${where}"})
    List<Student> selectUser(@Param("where") String where);

    @Update({"update Dc_User set FPassWord = 'ccc' where 1=1 ${where}"})
    int updateUser(@Param("where")String where);
}
