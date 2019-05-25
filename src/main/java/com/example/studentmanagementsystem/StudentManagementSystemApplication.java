package com.example.studentmanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** @author Hingbong */
@SpringBootApplication
@MapperScan("com.example.studentmanagementsystem.mappers")
public class StudentManagementSystemApplication {

  public static void main(String... args) {
    SpringApplication.run(StudentManagementSystemApplication.class, args);
  }
}
