package com.ohgiraffers.hulahoopblue.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ohgiraffers.hulahoopblue")
@MapperScan(basePackages = "com.ohgiraffers.hulahoopblue", annotationClass = Mapper.class)
public class Chap07CrudLectureSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap07CrudLectureSourceApplication.class, args);
    }

}
