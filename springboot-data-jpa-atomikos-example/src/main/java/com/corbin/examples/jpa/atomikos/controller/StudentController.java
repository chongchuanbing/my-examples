package com.corbin.examples.jpa.atomikos.controller;

import com.corbin.examples.jpa.atomikos.entity.secondary.Student;
import com.corbin.examples.jpa.atomikos.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping(value = "/findById/{id}")
    public Student findById(@PathVariable("id") Integer id) {
        return studentService.findById(id);
    }
}
