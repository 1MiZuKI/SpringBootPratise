package com.mizuki.boot.config;

import com.mizuki.boot.bean.Pet;
import com.mizuki.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class MyConfig {

    @Bean
    public User user01() {
        User user = new User("mizuki", 18);
        user.setPet(pet01());
        return user;
    }

    @Bean
    public Pet pet01() {
        return new Pet("wangCai");
    }
}
