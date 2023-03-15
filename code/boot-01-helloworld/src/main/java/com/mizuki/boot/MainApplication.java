package com.mizuki.boot;

import com.mizuki.boot.bean.Pet;
import com.mizuki.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        // 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 获取容器里的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

        // 从容器中获取组件
        User user01 = run.getBean("user01", User.class);
        User user02 = run.getBean("user01", User.class);
        System.out.println(user01 == user02);

        User user011 = run.getBean("user01", User.class);
        Pet pet01 = run.getBean("pet01", Pet.class);
        System.out.println(user011.getPet() == pet01);
    }
}
