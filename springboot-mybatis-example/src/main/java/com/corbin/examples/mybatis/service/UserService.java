package com.corbin.examples.mybatis.service;

import com.corbin.examples.mybatis.entity.User;
import com.corbin.examples.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(String userName, Integer age) {
        return userMapper.insert(userName, age) > 0 ? true : false;
    }

    public User getUserByName(String userName) {
        return userMapper.findByName(userName);
    }
}
