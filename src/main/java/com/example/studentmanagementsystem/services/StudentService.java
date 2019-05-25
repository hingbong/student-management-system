package com.example.studentmanagementsystem.services;

import com.example.studentmanagementsystem.entity.Student;
import java.util.List;

/** @author Hingbong */
public interface StudentService {

  /**
   * add new student
   *
   * @param student student
   */
  void addNewStudent(Student student);

  /**
   * find all student or student name and profession filter
   *
   * @param stuName student name
   * @param profession profession
   * @return
   */
  List<Student> findAllStudent(String stuName, Integer profession);

  /**
   * delete a student by id
   *
   * @param stuId student
   */
  void deleteStudentById(Integer stuId);

  /**
   * modify a student info
   *
   * @param student student
   */
  void modifyStudent(Student student);

  /**
   * find a student by id
   *
   * @param stuId student id
   * @return student
   */
  Student findStudentById(Integer stuId);
}
