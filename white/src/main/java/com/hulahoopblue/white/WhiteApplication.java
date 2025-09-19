package com.hulahoopblue.white;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.hulahoopblue.white")
@MapperScan(basePackages = "com.hulahoopblue.white", annotationClass = Mapper.class)
public class WhiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhiteApplication.class, args);
    }

}
