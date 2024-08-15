package com.corbin.examples.jpa.atomikos.service;

import com.corbin.examples.jpa.atomikos.entity.secondary.Student;

import java.util.List;

public interface StudentService {

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByName(String name);

    Student save(String name);

    void delete(Integer id);

}
