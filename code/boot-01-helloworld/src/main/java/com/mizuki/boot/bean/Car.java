package com.mizuki.boot.bean;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
@Data
@ToString
@ConfigurationProperties(prefix = "mycar")
// ConfigurationProperties默认从全局配置文件中获取值
public class Car {
    private String brand;

    private Double price;

}
