package com.corbin.exmaples.jta.entity.primary;

import com.corbin.exmaples.jta.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends BaseEntity {

    private String name;

    private Byte sex;

    private Integer age;

}
