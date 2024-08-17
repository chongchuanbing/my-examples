package com.corbin.examples.jpa.atomikos.service;

import com.corbin.examples.jpa.atomikos.dao.secondary.StudentDao;
import com.corbin.examples.jpa.atomikos.entity.secondary.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student findById(Integer id) {
        return studentDao.findById(id).get();
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public List<Student> findByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    @Transactional
    public Student save(String name) {
        Student student = new Student();
        student.setName(name);
        return studentDao.save(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        studentDao.deleteById(id);
    }
}
