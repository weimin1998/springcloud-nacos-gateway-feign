package cn.itcast.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@MapperScan("cn.itcast.user.mapper")
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(UserApplication.class, args);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        System.out.println(environment);

        System.out.println(environment.getProperty("person.name"));
        System.out.println(environment.getProperty("person.age"));
    }
}
