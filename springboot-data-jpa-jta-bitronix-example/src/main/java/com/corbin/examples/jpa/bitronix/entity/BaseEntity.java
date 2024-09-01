package com.corbin.examples.jpa.bitronix.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false, name = "create_time", updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column(nullable = false, name = "update_time")
    @LastModifiedDate
    private LocalDateTime updateTime;
}
