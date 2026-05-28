package com.example.allsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.allsystem.mapper")
public class AllSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllSystemApplication.class, args);
    }

}
