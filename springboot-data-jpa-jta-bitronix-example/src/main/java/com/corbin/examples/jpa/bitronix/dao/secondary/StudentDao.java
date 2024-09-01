package com.corbin.examples.jpa.bitronix.dao.secondary;

import com.corbin.examples.jpa.bitronix.entity.secondary.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

    @Query("from Student where name like ?1")
    List<Student> findByName(String name);

    List<Student> findByCreateTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
}
