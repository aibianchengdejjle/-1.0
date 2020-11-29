package com.jjle.sport;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.jjle.sport.Mapper")
@SpringBootApplication
public class SportApplication {
    public static void main(String[] args) {
        SpringApplication.run(SportApplication.class, args);
    }
}
