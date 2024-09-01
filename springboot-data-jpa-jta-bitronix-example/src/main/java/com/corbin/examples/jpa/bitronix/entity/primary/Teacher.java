package com.corbin.examples.jpa.bitronix.entity.primary;

import com.corbin.examples.jpa.bitronix.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "teacher", indexes = {@Index(name = "idx_name", columnList = "name"), @Index(name = "idx_createTime", columnList = "create_time")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private Byte sex;

    @Column(name = "age")
    private Integer age;

}
