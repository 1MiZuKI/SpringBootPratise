package com.mizuki.boot.config;

import com.mizuki.boot.bean.Car;
import com.mizuki.boot.bean.Pet;
import com.mizuki.boot.bean.Son;
import com.mizuki.boot.bean.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Import({User.class, Pet.class})
@Configuration(proxyBeanMethods = false)
//@ConditionalOnBean(name = "son01")// 当容器中有son01组件时，才会加载这个配置类
@ConditionalOnMissingBean(name = "son01")// 当容器中没有son01组件时，才会加载这个配置类
//@Conditional 可以加在类上也可以加在方法上
@ImportResource("classpath:bean.xml")
@EnableConfigurationProperties(Car.class)
// EnableConfigurationProperties(Car.class)：将Car这个组件自动注册到容器中,并且将配置文件中的值赋值给Car
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

    public Son son01() {
        return new Son("Son");
    }
}
