package com.corbin.examples.mybatis.mapper;

import com.corbin.examples.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("SELECT id, user_name AS name, age, status, create_time AS createTime, update_time AS updateTime FROM user WHERE user_name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO user(id, name, age, status, create_time, update_time) VALUES (NULL, #{name}, #{age}, 1, NOW(), NOW())")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Insert("INSERT INTO user(name, age, status) VALUES (#{user.name}, #{user.age})")
//    @SelectKey(statement = "select currval('user_id_seq')", keyProperty = "id", before = false, resultType = Long.class)
    @Options(useGeneratedKeys = true, keyProperty = "user.id", keyColumn = "id")
    int insert(@Param("user") User user);

    @Select("select id, user_name AS name, age, status, create_time AS createTime, update_time AS updateTime from user")
    List<User> findAll();

    @Update("update user set is_deleted = 1 where id = #{userId}")
    void deleteById(@Param("userId") Long userId);

    User findById(@Param("userId") Long userId);
}
