package com.mizuki.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor // 无参构造
@AllArgsConstructor // 有参构造
@Data // 生成get、set、toString、equals、hashCode方法
@ToString // 生成toString方法
public class Pet {
    private String name;
}
