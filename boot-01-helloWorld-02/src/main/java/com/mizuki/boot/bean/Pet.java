package com.mizuki.boot.bean;

import lombok.Data;

@Data // 给类自动添加get、set、toString、equals、hashCode方法
public class Pet {

    private String name;
    private Double weight;
}
