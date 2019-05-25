package com.example.studentmanagementsystem.services.impl;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.exception.OperationException;
import com.example.studentmanagementsystem.mappers.StudentMapper;
import com.example.studentmanagementsystem.services.StudentService;
import com.example.studentmanagementsystem.util.Util;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @author Hingbong */
@Service
public class StudentServiceImpl implements StudentService {

  private StudentMapper studentMapper;

  @Override
  public void addNewStudent(Student student) {
    if (!validStudent(student)) {
      throw new OperationException("添加失败");
    }
    List<Student> all = studentMapper.findAllStudent(null, null);
    boolean hasSameIdNum =
        all.stream().map(Student::getIdNum).anyMatch(s -> s.equals(student.getIdNum()));
    if (hasSameIdNum) {
      throw new OperationException("添加失败");
    }
    // integer is the number of affected rows
    Integer integer = studentMapper.addNewStudent(student);
    if (integer <= 0) {
      throw new OperationException("添加失败");
    }
  }

  @Override
  public List<Student> findAllStudent(String stuName, Integer profession) {
    if ("".equals(stuName)) {
      stuName = null;
    }
    if (Integer.valueOf(0).equals(profession)) {
      profession = null;
    }
    return studentMapper.findAllStudent(stuName, profession);
  }

  @Override
  public void deleteStudentById(Integer stuId) {
    if (stuId == null) {
      throw new OperationException("操作错误");
    }
    Integer integer = studentMapper.deleteStudentById(stuId);
    if (integer == null || integer <= 0) {
      throw new OperationException("操作错误");
    }
  }

  @Override
  public void modifyStudent(Student student) {
    Boolean validStudent = validStudent(student);
    if (validStudent) {
      Integer integer = studentMapper.modifyStudent(student);
      if (integer <= 0) {
        throw new OperationException("修改失败");
      }
    }
  }

  @Override
  public Student findStudentById(Integer stuId) {
    Student student = studentMapper.findStudentById(stuId);
    if (student == null) {
      throw new OperationException("无此学号");
    }
    return student;
  }

  private Boolean validStudent(Student student) {
    return !(student.getStuName() == null
        || student.getProfession() == null
        || !Util.isIDNumber(student.getIdNum())
        || student.getDate() == null
        || student.getSex() == null
        || student.getTotalScore() == null);
  }

  @Autowired
  public void setStudentMapper(StudentMapper studentMapper) {
    this.studentMapper = studentMapper;
  }
}
