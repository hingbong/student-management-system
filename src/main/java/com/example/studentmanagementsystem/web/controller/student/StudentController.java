package com.example.studentmanagementsystem.web.controller.student;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.services.StudentService;
import com.example.studentmanagementsystem.util.JsonResult;
import com.example.studentmanagementsystem.web.controller.BaseController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/** @author Hingbong */
@RestController
@RequestMapping("student_op")
public class StudentController extends BaseController {

  private StudentService studentService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public JsonResult<Void> addStudent(Student student) {
    studentService.addNewStudent(student);
    return JsonResult.newJson(1);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public JsonResult<List> listAll(String stuName, Integer profession) {
    List<Student> students = studentService.findAllStudent(stuName, profession);
    return JsonResult.newJson(1, students);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public JsonResult<Void> deleteById(@PathVariable("id") Integer stuId) {
    studentService.deleteStudentById(stuId);
    return JsonResult.newJson(1);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public JsonResult<Void> modifyStudent(Student student) {
    studentService.modifyStudent(student);
    return JsonResult.newJson(1);
  }

  @GetMapping("{stuId}")
  @ResponseStatus(HttpStatus.OK)
  public JsonResult<Student> findStudentById(@PathVariable("stuId") Integer stuId) {
    return JsonResult.newJson(1, studentService.findStudentById(stuId));
  }

  @Autowired
  public void setStudentService(StudentService studentService) {
    this.studentService = studentService;
  }
}
