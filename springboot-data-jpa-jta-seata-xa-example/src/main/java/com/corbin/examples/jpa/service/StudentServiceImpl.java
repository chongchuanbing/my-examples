package com.corbin.examples.jpa.service;

import com.corbin.examples.jpa.dao.StudentDao;
import com.corbin.examples.jpa.entity.Student;
import io.seata.spring.annotation.GlobalTransactional;
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
    @GlobalTransactional
    @Transactional
    public Student save(String name) {
        Student student = new Student();
        student.setName(name);
        return studentDao.save(student);
    }

    @Override
    @GlobalTransactional
    @Transactional
    public void delete(Integer id) {
        studentDao.deleteById(id);
    }
}
