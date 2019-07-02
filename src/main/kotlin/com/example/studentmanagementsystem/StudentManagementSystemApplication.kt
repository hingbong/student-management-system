package com.example.studentmanagementsystem

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.example.studentmanagementsystem.mappers")
class StudentManagementSystemApplication

fun main(args: Array<String>) {
    runApplication<StudentManagementSystemApplication>(*args)
}
