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


        System.out.println("=====================================");
        //检测import导入的组件(全类名)
        String[] strings = run.getBeanNamesForType(User.class);
        for (String string : strings) {
            System.out.println(string);
        }

        String[] beanNamesForType = run.getBeanNamesForType(Pet.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        // 测试条件装配
        System.out.println("=====================================");
        boolean ifUser01 = run.containsBean("user01");
        boolean ifPet01 = run.containsBean("pet01");

        System.out.println("ifUser01: " + ifUser01);
        System.out.println("ifPet01: " + ifPet01);

        //测试@ImportResource导入xml配置文件
        System.out.println("=====================================");
        boolean ifHaha = run.containsBean("haha");
        System.out.println("haha: " + ifHaha);
    }
}
