package com.example.studentmanagementsystem;

import com.example.studentmanagementsystem.mappers.StudentMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootTest
class StudentManagementSystemApplicationTests {

  private ApplicationContext context = new GenericApplicationContext();

  @Test
  void contextLoads() {}

  @Test
  void findAllStuId() {
    StudentMapper studentMapper = context.getBean("studentMapper", StudentMapper.class);
    List<Integer> allStuId = studentMapper.findAllStuId();
    allStuId.forEach(System.out::println);
  }
}
