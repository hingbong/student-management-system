package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entity.Student;

import java.util.List;

/** @author Hingbong */
public interface StudentService {

  void addNewStudent(Student student);

  List<Student> findAllStudent(String stuName, Integer profession);

  Boolean deleteStudentById(Integer stuId);

  void modifyStudent(Student student);

  Student findStudentById(Integer stuId);
}
