package com.corbin.exmaples.jta.entity;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class BaseEntity {

    private String id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
