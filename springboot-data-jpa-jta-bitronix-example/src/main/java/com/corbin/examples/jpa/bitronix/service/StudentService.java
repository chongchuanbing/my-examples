package com.corbin.examples.jpa.bitronix.service;


import com.corbin.examples.jpa.bitronix.entity.secondary.Student;

import java.util.List;

public interface StudentService {

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByName(String name);

    Student save(String name);

    void delete(Integer id);

}
