package com.example.swagger2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.swagger2.dao")
public class Swagger2Application {
    public static void main(String[] args) {
        SpringApplication.run(Swagger2Application.class, args);
    }
}
