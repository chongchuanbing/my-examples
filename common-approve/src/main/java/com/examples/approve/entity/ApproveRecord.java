package com.examples.approve.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class ApproveRecord {

    @Id
    private Long id;

    private String name;

    @Column(name = "is_deleted")
    private Byte deleted;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "approve_time")
    private LocalDateTime approveTime;

    @Column(name = "approve_user_id")
    private Long approveUserId;
}
