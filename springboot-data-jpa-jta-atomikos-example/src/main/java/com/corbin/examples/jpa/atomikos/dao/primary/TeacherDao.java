package com.corbin.examples.jpa.atomikos.dao.primary;

import com.corbin.examples.jpa.atomikos.entity.primary.Teacher;
import com.corbin.examples.jpa.atomikos.entity.secondary.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TeacherDao extends JpaRepository<Teacher, Integer> {

    @Query("from Teacher where name like ?1")
    List<Student> findByName(String name);

    List<Student> findByCreateTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
}
